package it.cofidimpresa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.cofidimpresa.data.AntiriciclaggioData;
import it.cofidimpresa.facades.AntiriciclaggioFacade;
import it.cofidimpresa.facades.FinanziamentiFacade;

@Controller
public class AntiriciclaggioController {
	private static final Logger logger = Logger.getLogger(DocumentController.class);

	@Resource(name="messageSource")
	ReloadableResourceBundleMessageSource  messageSource;

	@Resource(name = "finanziamentiFacade")
	FinanziamentiFacade finanziamentiFacade;
	
	@Resource(name="antiriciclaggioFacade")
	AntiriciclaggioFacade antiriciclaggioFacade;
	
	@RequestMapping(value = "/inserisciAntiriciclaggio", method = RequestMethod.GET)
	public String inserisciAntiriciclaggio(final Model model, final HttpServletRequest request,
			@RequestParam("idFin") Integer idFin, @RequestParam("idSoci") Integer idSocio, final HttpServletResponse response) {
		logger.debug("*** inserisciAntiriciclaggio ***");
		AntiriciclaggioData antData = new AntiriciclaggioData();
		antData.setIdFinanziamento(idFin);
		antData.setIdSoci(idSocio);
		model.addAttribute("antData", antData);
		return "insAntiriciclaggio";
	}
	
	@RequestMapping(value = "/insAntiriciclaggio", method = RequestMethod.POST)
	public String insAntiriciclaggio(final Model model,
			@ModelAttribute("antTmp") AntiriciclaggioData antData, BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** insAntiriciclaggio ***");
		
		try {
			int idAntRic = antiriciclaggioFacade.inserisciAntiriciclaggio(antData);
			antData.setIdAntiriciclaggio(idAntRic);
			model.addAttribute("confirmMsg",messageSource.getMessage("insert.antiriciclaggio", null, LocaleContextHolder.getLocale()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("antData", antData);
		return "modAntiriciclaggio";
	}
	
	@RequestMapping(value = "/modAntiriciclaggio", method = RequestMethod.POST)
	public String modAntiriciclaggio(final Model model,
			@ModelAttribute("antData") AntiriciclaggioData antData, BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** modAntiriciclaggio ***");
		
		try {
			int idAntRic = antiriciclaggioFacade.updateAntiriciclaggio(antData);
			model.addAttribute("confirmMsg",messageSource.getMessage("modifica.antiriciclaggio", null, LocaleContextHolder.getLocale()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("antData", antData);
		return "modAntiriciclaggio";
	}
	
	@RequestMapping(value = "/modAntiriciclaggio", method = RequestMethod.GET)
	public String getAntiriciclaggio(final Model model,
			@RequestParam("idAnt") Integer idAnt,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** modAntiriciclaggio ***");
		
		try {
			AntiriciclaggioData antData= antiriciclaggioFacade.getAntiriciclaggioById(idAnt).get(0);
			model.addAttribute("antData", antData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "modAntiriciclaggio";
	}
	
	@RequestMapping(value = "/elencoAntiriciclaggio", method = RequestMethod.GET)
	public String elencoAntiriciclaggio(final Model model,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** insAntiriciclaggio ***");
		
		try {
			List<AntiriciclaggioData> antiriciclaggioList= antiriciclaggioFacade.elecoAntiriciclaggio();
			model.addAttribute("antiriciclaggioList", antiriciclaggioList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "elencoAntiriciclaggio";
	}
	
	@RequestMapping(value = "/estraiElencoAntiriciclaggio", method = RequestMethod.GET)
	public String getEstraiElencoAntiriciclaggio(final Model model,
			@RequestParam("idAnt") Integer idAnt,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** estraiElencoAntiriciclaggio ***");
		String anno="";
		model.addAttribute("selectAnno", anno);	
		return "modAntiriciclaggio";
	}
	
	@RequestMapping(value = "/estraiElencoAntiriciclaggio", method = RequestMethod.POST)
	public String getEstraiElencoAntiriciclaggioPost(final Model model,
			@RequestParam("selectAnno") String anno,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** estraiElencoAntiriciclaggio ***");
		
		try {
			List<AntiriciclaggioData> antiriciclaggioList= antiriciclaggioFacade.elecoAntiriciclaggio();
			model.addAttribute("antiriciclaggioList", antiriciclaggioList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "modAntiriciclaggio";
	}
	
}
