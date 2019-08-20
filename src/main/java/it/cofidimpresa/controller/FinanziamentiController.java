package it.cofidimpresa.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
import it.cofidimpresa.data.FinanziamentiData;
import it.cofidimpresa.data.FinanziamentiTableData;
import it.cofidimpresa.data.SociData;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.facades.AntiriciclaggioFacade;
import it.cofidimpresa.facades.BancheFacade;
import it.cofidimpresa.facades.ControgaranziaFacade;
import it.cofidimpresa.facades.FinanziamentiFacade;
import it.cofidimpresa.facades.SociFacade;
import it.cofidimpresa.facades.StatoFinanziamentoFacade;
import it.cofidimpresa.validator.InsFinanziamentiValidator;

@Controller
public class FinanziamentiController {
	private static final Logger logger = Logger.getLogger(FinanziamentiController.class);

	@Resource(name="messageSource")
	private ReloadableResourceBundleMessageSource  messageSource;
	
	@Resource(name = "finanziamentiFacade")
	private FinanziamentiFacade finanziamentiFacade;

	@Resource(name = "controgaranziaFacade")
	private ControgaranziaFacade controgaranziaFacade;

	@Resource(name = "bancheFacade")
	private BancheFacade bancheFacade;

	@Resource(name = "statoFinanziamentoFacade")
	private StatoFinanziamentoFacade statoFinanziamentoFacade;

	@Resource(name = "sociFacade")
	private SociFacade sociFacade;
	
	@Resource(name = "antiriciclaggioFacade")
	private AntiriciclaggioFacade antiriciclaggioFacade;
	
	@Resource
	private InsFinanziamentiValidator insFinanziamentiValidator;

	@RequestMapping(value = "/elencoFinanziamenti", method = RequestMethod.GET)
	public String elencoFinanziamenti(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** elencoFinanziamenti ***");
		List<FinanziamentiTableData> finanziamentiTableDatas = finanziamentiFacade.getAllFinanziamenti();
		model.addAttribute("finanziamentiTableDatas", finanziamentiTableDatas);
		return "elencoFinanziamenti";
	}

	@RequestMapping(value = "/modificaFinanziamento", method = RequestMethod.GET)
	public String modifyFinanziamento(final Model model, @RequestParam("idFin") Integer idFin,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** modifyFinanziamento ***");

		FinanziamentiData finanziamentiData = new FinanziamentiData();
		List<AntiriciclaggioData> antiriciclaggioList = new ArrayList<AntiriciclaggioData>();

		try {
			finanziamentiData = finanziamentiFacade.getFinanziamentiById(idFin);
			antiriciclaggioList=antiriciclaggioFacade.getAntiriciclaggioByIdFin(idFin);
			model.addAttribute("antiriciclaggioList", antiriciclaggioList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setModelPageForFinanziamento(model,finanziamentiData,request.getSession());
		setSocioForFinanziamento(model, finanziamentiData);

		model.addAttribute("finanziamentiData", finanziamentiData);
		return "modificaFinanziamento";
	}

	@RequestMapping(value = "/inserisciFinanziamento", method = RequestMethod.GET)
	public String insertFinanziamento(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** modifyFinanziamento ***");
		FinanziamentiData finanziamentiData = new FinanziamentiData();
		
		setModelPageForFinanziamento(model,finanziamentiData,request.getSession());
		
		return "insFinanziamento";
	}

	@RequestMapping(value = "/inserisciFinanziamentoSocio", method = RequestMethod.GET)
	public String inserisciFinanziamentoSocio(final Model model, final HttpServletRequest request,
			@RequestParam("idSocio") final Integer idSocio, final HttpServletResponse response) {
		logger.debug("*** inserisciFinanziamentoSocio ***");
		FinanziamentiData finanziamentiData = new FinanziamentiData();
		finanziamentiData.setIdSoci(idSocio);
		setSocioForFinanziamento(model, finanziamentiData);
		setModelPageForFinanziamento(model, finanziamentiData,request.getSession());
		return "insFinanziamento";
	}

	

	@RequestMapping(value = "/inserisciFin", method = RequestMethod.POST)
	public String insertFinanziamento(final Model model,
			@ModelAttribute("finanziamentiData") FinanziamentiData finanziamentiData, BindingResult bindingResult,
			@RequestParam(value = "piva", required=false) String piva, final HttpServletRequest request,
			final HttpServletResponse response) {
		logger.debug("*** insertFinanziamento ***");
		if(StringUtils.isNotEmpty(piva)) {
			try {
				insFinanziamentiValidator.validate(finanziamentiData, bindingResult);
				if(bindingResult.hasErrors()) {
					model.addAttribute("finanziamentiData", finanziamentiData);
					return "insFinanziamento";
				}
				Integer idSocio = sociFacade.getIdSocioByPIva(piva);
				finanziamentiData.setIdSoci(idSocio);
				model.addAttribute("confirmMsg",messageSource.getMessage("insert.finanziamento", null, LocaleContextHolder.getLocale()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			finanziamentiFacade.insertFinanziamento(finanziamentiData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSocioForFinanziamento(model, finanziamentiData);
		setModelPageForFinanziamento(model,finanziamentiData,request.getSession());
		
		return "modificaFinanziamento";
	}


	@RequestMapping(value = "/updateFinanziamento", method = RequestMethod.POST)
	public String updateFinanziamento(final Model model,
			@ModelAttribute("finanziamentiData") FinanziamentiData finanziamentiData, BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response) {
		logger.debug("*** insertFinanziamento ***");
		
		try {
			finanziamentiFacade.updateFinanziamento(finanziamentiData);
			model.addAttribute("confirmMsg",messageSource.getMessage("insert.finanziamento", null, LocaleContextHolder.getLocale()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setSocioForFinanziamento(model, finanziamentiData);
		setModelPageForFinanziamento(model,finanziamentiData,request.getSession());

		return "modificaFinanziamento";
	}
	

	private void setSocioForFinanziamento(final Model model, FinanziamentiData finanziamentiData) {
		try {
			SociData socio = sociFacade.dettaglioSocio(finanziamentiData.getIdSoci());
			model.addAttribute("impresa", socio.getImpresa());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void setModelPageForFinanziamento(final Model model, FinanziamentiData finanziamentiData, HttpSession session) {
		List<StateObjectData> bancheList = (List<StateObjectData>) session.getAttribute("bancheList");
		model.addAttribute("bancheList", bancheList);

		List<StateObjectData> statoFinList = (List<StateObjectData>) session.getAttribute("statoFinList");
		model.addAttribute("statoFinList", statoFinList);

		List<StateObjectData> garanziaList = (List<StateObjectData>) session.getAttribute("garanziaList");
		model.addAttribute("garanziaList", garanziaList);

		model.addAttribute("finanziamentiData", finanziamentiData);
	}

	
}
