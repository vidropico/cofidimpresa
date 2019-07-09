package it.cofidimpresa.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.cofidimpresa.data.TableExcelData;
import it.cofidimpresa.facades.impl.DefaultGeneraFileCrifFacade;
import it.cofidimpresa.utils.DefaultJavaUtils;

@Controller
public class GenerateFileXLSController {
	private static final Logger logger = Logger.getLogger(GenerateFileXLSController.class);

	@Resource(name = "messageSource")
	ReloadableResourceBundleMessageSource messageSource;

	@Resource(name = "defaultJavaUtils")
	DefaultJavaUtils defaultJavaUtils;

	@Resource(name = "generaFileCrifFacade")
	DefaultGeneraFileCrifFacade crifFacade;

	@RequestMapping(value = "/generaFileXls", method = RequestMethod.GET)
	public String generaFileXls(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** generaFileXls ***");
		String dateFilterEnd = getLastMonthLastDate();
		String dateFilterStart = getFirsDateYear();
		model.addAttribute("dateFilterEnd", dateFilterEnd);
		model.addAttribute("dateFilterStart", dateFilterStart);
		return "finanziamentiFilter";
	}

	@RequestMapping(value = "/generateFileExcel", method = RequestMethod.POST)
	public String generateFileExcel(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			String dateFilterStart, String dateFilterEnd) {
		logger.debug("*** generateFileExcel ***");
		Date dateStart = null;
		Date dateEnd = null;
		List<TableExcelData> tableExcelDataList = new ArrayList<TableExcelData>();
		try {
			dateStart = defaultJavaUtils.convertDateFromString(dateFilterStart);
			dateEnd = defaultJavaUtils.convertDateFromString(dateFilterEnd);
			tableExcelDataList = crifFacade.generaFileExcel(dateStart, dateEnd);
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		model.addAttribute("tableExcelDataList", tableExcelDataList);
		return "reportExcel";
	}

	public static String getLastMonthLastDate() {
		Calendar calendar = Calendar.getInstance();

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		return formatter.format(calendar.getTime());
	}
	public static String getFirsDateYear() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR));
		calendar.set(Calendar.MONTH,0);

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		return formatter.format(calendar.getTime());
	}
}
