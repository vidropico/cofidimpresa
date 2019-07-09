package it.cofidimpresa.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.cofidimpresa.data.FinanziamentiTableData;
import it.cofidimpresa.documents.AddebitoBanca;
import it.cofidimpresa.documents.AddebitoJasper;
import it.cofidimpresa.documents.DomandaBanca;
import it.cofidimpresa.documents.DomandaJasper;
import it.cofidimpresa.documents.Ricapitolo;
import it.cofidimpresa.documents.RicapitoloJasper;
import it.cofidimpresa.facades.FinanziamentiFacade;

@Controller
public class DocumentController {
	private static final Logger logger = Logger.getLogger(DocumentController.class);

	@Resource
	ApplicationContext context;

	@Resource(name = "addebitoBanca")
	AddebitoBanca addebitoBanca;

	@Resource(name = "messageSource")
	ReloadableResourceBundleMessageSource messageSource;

	@Resource(name = "finanziamentiFacade")
	FinanziamentiFacade finanziamentiFacade;

	@Resource(name = "domandaBanca")
	DomandaBanca domandabanca;

	@Resource(name = "ricapitolo")
	Ricapitolo ricapitolo;

	@Resource(name = "ricapitoloJasper")
	RicapitoloJasper ricapitoloJasper;

	@Resource(name = "addebitoJasper")
	AddebitoJasper addebitoJasper;

	@Resource(name = "domandaBancaJasper")
	DomandaJasper domandaBancaJasper;

	@RequestMapping(value = "/addebitoBanca", method = RequestMethod.GET)
	public String addebitoBanca(final Model model, @RequestParam("idSocio") Integer idSocio,
			@RequestParam("idFinanziamenti") Integer idFinanziamenti, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** addebitoBanca ***");
		try {

			String fileGenerate = addebitoJasper.createAddebito(idSocio, idFinanziamenti);
			saveFile(response, fileGenerate);
			model.addAttribute("confirmMsg",
					messageSource.getMessage("addebito.banca", null, LocaleContextHolder.getLocale()));
		} catch (Exception e) {
			logger.error("Si è verificato un errore nella stampa del documento");
			model.addAttribute("errorMsg",
					messageSource.getMessage("error.stampa.document", null, LocaleContextHolder.getLocale()));
		}
		List<FinanziamentiTableData> finanziamentiTableDatas = finanziamentiFacade.getAllFinanziamenti();
		model.addAttribute("finanziamentiTableDatas", finanziamentiTableDatas);
		logger.debug("*** end addebitoBanca ***");
		return "elencoFinanziamenti";
	}

	

	@RequestMapping(value = "/domandaBanca", method = RequestMethod.GET)
	public String domandaBanca(final Model model, @RequestParam("idSocio") Integer idSocio,
			@RequestParam("idFinanziamenti") Integer idFinanziamenti, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** domandaBanca ***");
		try {
			String fileGenerate = domandaBancaJasper.createDomandaBanca(idSocio, idFinanziamenti);
			saveFile(response, fileGenerate);
			model.addAttribute("confirmMsg",
					messageSource.getMessage("domanda.banca", null, LocaleContextHolder.getLocale()));
		} catch (Exception e) {
			logger.error("Si è verificato un errore nella stampa del documento");
			model.addAttribute("errorMsg",
					messageSource.getMessage("error.stampa.document", null, LocaleContextHolder.getLocale()));

		}

		List<FinanziamentiTableData> finanziamentiTableDatas = finanziamentiFacade.getAllFinanziamenti();
		model.addAttribute("finanziamentiTableDatas", finanziamentiTableDatas);
		logger.debug("*** end domandaBanca ***");
		return "elencoFinanziamenti";
	}

	@RequestMapping(value = "/ricapitolo", method = RequestMethod.GET)
	public String ricapitolo(final Model model, @RequestParam("idSocio") Integer idSocio,
			@RequestParam("idFinanziamenti") Integer idFinanziamenti, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** ricapitolo ***");
		try {
			String fileGenerate = ricapitoloJasper.createRicapitolo(idSocio, idFinanziamenti);
			saveFile(response, fileGenerate);
			model.addAttribute("confirmMsg",
					messageSource.getMessage("ricapitolo.banca", null, LocaleContextHolder.getLocale()));
		} catch (Exception e) {
			logger.error("Si è verificato un errore nella stampa del documento");
			model.addAttribute("errorMsg",
					messageSource.getMessage("error.stampa.document", null, LocaleContextHolder.getLocale()));

		}
		List<FinanziamentiTableData> finanziamentiTableDatas = finanziamentiFacade.getAllFinanziamenti();
		model.addAttribute("finanziamentiTableDatas", finanziamentiTableDatas);
		logger.debug("*** end ricapitolo ***");
		return "elencoFinanziamenti";
	}
	
	/**
	 * @param response
	 * @param fileGenerate
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void saveFile(final HttpServletResponse response, String fileGenerate)
			throws FileNotFoundException, IOException {
		OutputStream outputStream = null;
		InputStream in = null;
		try {
		    in = new FileInputStream(fileGenerate); // I assume files are at /tmp
		    byte[] buffer = new byte[1024];
		    int bytesRead = 0;
		    response.setHeader(
		        "Content-Disposition",
		        "attachment;filename=\"" + fileGenerate + "\"");
		    outputStream = response.getOutputStream();
		    while( 0 < ( bytesRead = in.read( buffer ) ) )
		    {
		        outputStream.write( buffer, 0, bytesRead );
		    }
		}
		finally
		{
		    if ( null != in )
		    {
		        in.close();
		    }
		}
	}

}
