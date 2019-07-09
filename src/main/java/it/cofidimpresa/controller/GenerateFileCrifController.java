package it.cofidimpresa.controller;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import it.cofidimpresa.facades.impl.DefaultGeneraFileCrifFacade;
import it.cofidimpresa.utils.DefaultJavaUtils;


@Controller
public class GenerateFileCrifController {
	private static final Logger logger = Logger.getLogger(GenerateFileCrifController.class);
	
	@Resource(name="messageSource")
	ReloadableResourceBundleMessageSource  messageSource;
	
	@Resource(name="defaultJavaUtils")
	DefaultJavaUtils defaultJavaUtils;
	
	@Resource(name = "generaFileCrifFacade")
	DefaultGeneraFileCrifFacade crifFacade;
	
	@RequestMapping(value = "/generaFileCrif", method = RequestMethod.GET)
	public String generaFileCrif(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** generaFileCrif ***");
		String dateFile = getLastMonthLastDate();
		model.addAttribute("dateFile", dateFile);
		return "generaFileCrif";
	}
	
	@RequestMapping(value = "/generateFile", method = RequestMethod.POST)
	public String generateFile(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, String dateFile) {
		logger.debug("*** generateFile ***");
		Date date = null;
		try {
			date = defaultJavaUtils.convertDateFromString(dateFile);
			boolean generateFile = crifFacade.generaFileCrif(date,dateFile);
			if(generateFile) {
				model.addAttribute("confirmMsg",messageSource.getMessage("generate.crif.file", null, LocaleContextHolder.getLocale()));				
			}else {
				model.addAttribute("errorMsg",messageSource.getMessage("error.generate.crif.file", null, LocaleContextHolder.getLocale()));
			}
		} catch (ParseException e) {		
			model.addAttribute("errorMsg",e.getMessage());
		}
		model.addAttribute("dateFile", dateFile);
		return "generaFileCrif";
	}
	
	 public static String getLastMonthLastDate() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.MONTH, -1);

	        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	        calendar.set(Calendar.DAY_OF_MONTH, max);
	        
	        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        
	        return formatter.format(calendar.getTime());
	    }
}
