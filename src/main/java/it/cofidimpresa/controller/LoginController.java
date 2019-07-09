
package it.cofidimpresa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.facades.AtecoFacade;
import it.cofidimpresa.facades.BancheFacade;
import it.cofidimpresa.facades.ControgaranziaFacade;
import it.cofidimpresa.facades.FinanziamentiFacade;
import it.cofidimpresa.facades.QualitaTitolareFacade;
import it.cofidimpresa.facades.SettoreImpresaFacade;
import it.cofidimpresa.facades.SociFacade;
import it.cofidimpresa.facades.StatoFinanziamentoFacade;
import it.cofidimpresa.facades.StatoSocioFacade;
import it.cofidimpresa.facades.TipoSocietaFacade;

@Controller
@RequestMapping(value = "/**")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	
	@Resource
	ApplicationContext context;
	
	@Resource(name="messageSource")
	ReloadableResourceBundleMessageSource  messageSource;
	
	@Resource(name="sociFacade")
	SociFacade sociFacade;
	
	@Resource(name="finanziamentiFacade")
	FinanziamentiFacade finanziamentiFacade;
	

	@Resource(name = "controgaranziaFacade")
	ControgaranziaFacade controgaranziaFacade;

	@Resource(name = "bancheFacade")
	BancheFacade bancheFacade;

	@Resource(name = "statoFinanziamentoFacade")
	StatoFinanziamentoFacade statoFinanziamentoFacade;
	
	@Resource(name = "statoSocioFacade")
	StatoSocioFacade statoSocioFacade;

	@Resource(name = "qualitaTitolareFacade")
	QualitaTitolareFacade qualitaTitolareFacade;

	@Resource(name = "settoreImpresaFacade")
	SettoreImpresaFacade settoreImpresaFacade;

	@Resource(name = "tipoSocietaFacade")
	TipoSocietaFacade tipoSocietaFacade;
	
	@Resource(name="atecoFacade")
	AtecoFacade atecoFacede;

	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLogin(final Model model,
    		@RequestParam(value="error", required=false, defaultValue="false") boolean error, 
    		final HttpServletRequest request, final HttpServletResponse response) {
    	logger.info("*** Start Gestione Soci ***");
    	if(error) {
    		model.addAttribute("errorMsg",messageSource.getMessage("error.login", null, LocaleContextHolder.getLocale()));
    	}else {
    		HttpSession session = request.getSession();
    		
    		List<StateObjectData> bancheList = bancheFacade.getAllBanche();
    		session.setAttribute("bancheList", bancheList);

    		List<StateObjectData> statoFinList = statoFinanziamentoFacade.getAllStatoFinanziamenti();
    		session.setAttribute("statoFinList", statoFinList);

    		List<StateObjectData> garanziaList = controgaranziaFacade.getAllControgaranzia();
    		session.setAttribute("garanziaList",garanziaList);
    		
    		List<StateObjectData> statoSocio = statoSocioFacade.getAllStatoSocio();
    		session.setAttribute("statoSocioList", statoSocio);

    		List<StateObjectData> qualitaTitolare = qualitaTitolareFacade.getAllQualitaTitolare();
    		session.setAttribute("qualitaTitolareList", qualitaTitolare);

    		List<StateObjectData> settoreImpresa = settoreImpresaFacade.getAllSettoreImpresa();
    		session.setAttribute("settoreImpresaList", settoreImpresa);

    		List<StateObjectData> tipoSocieta = tipoSocietaFacade.getAllTipoSocieta();
    		session.setAttribute("tipoSocietaList", tipoSocieta);

    		List<StateObjectData> atecoList = sociFacade.getAtecoList();
    		session.setAttribute("atecoList", atecoList);

    	}
    	
    	model.addAttribute("context",request.getContextPath());
        
        return "login";
    }
    
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage(final Model model,
    		final HttpServletRequest request, final HttpServletResponse response) {
    	int numSoci = sociFacade.getNumeroSoci();
    	int numFin = finanziamentiFacade.getNumeroFinanziamenti();
        
    	model.addAttribute("numSoci", numSoci);
        model.addAttribute("numFin", numFin);
        return "hello";
    }
}
