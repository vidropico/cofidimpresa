package it.cofidimpresa.controller;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.cofidimpresa.data.FinanziamentiTableData;
import it.cofidimpresa.data.SociData;
import it.cofidimpresa.data.SociTableData;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.facades.AtecoFacade;
import it.cofidimpresa.facades.FinanziamentiFacade;
import it.cofidimpresa.facades.QualitaTitolareFacade;
import it.cofidimpresa.facades.SettoreImpresaFacade;
import it.cofidimpresa.facades.SociFacade;
import it.cofidimpresa.facades.StatoSocioFacade;
import it.cofidimpresa.facades.TipoSocietaFacade;
import it.cofidimpresa.validator.SociValidator;

@Controller
public class SociController {
	private static final Logger logger = Logger.getLogger(SociController.class);

	@Resource
	private ApplicationContext context;

	@Resource(name = "messageSource")
	private ReloadableResourceBundleMessageSource messageSource;

	@Resource(name = "sociFacade")
	private SociFacade sociFacade;

	@Resource(name = "statoSocioFacade")
	private StatoSocioFacade statoSocioFacade;

	@Resource(name = "qualitaTitolareFacade")
	private QualitaTitolareFacade qualitaTitolareFacade;

	@Resource(name = "settoreImpresaFacade")
	private SettoreImpresaFacade settoreImpresaFacade;

	@Resource(name = "tipoSocietaFacade")
	private TipoSocietaFacade tipoSocietaFacade;

	@Resource(name = "atecoFacade")
	private AtecoFacade atecoFacede;

	@Resource(name = "finanziamentiFacade")
	private FinanziamentiFacade finanziamentiFacade;
	
	@Resource
	private SociValidator sociValidator;

	@RequestMapping(value = "/elencoSoci", method = RequestMethod.GET)
	public String elencoSoci(final Model model, final HttpServletRequest request, final HttpServletResponse response) {
		List<SociTableData> sociTableDatas = sociFacade.getAllSoci();
		model.addAttribute("sociTables", sociTableDatas);
		return "elencoSoci";
	}

	@RequestMapping(value = "/inserisciSocio", method = RequestMethod.GET)
	public String inserisciSocio(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) {
		SociData sociData = new SociData();
		setModelPage(model, sociData, request.getSession());
		model.addAttribute("context", request.getContextPath());
		return "insertSoci";
	}

	private void setModelPage(final Model model, SociData sociData, HttpSession session) {
		List<StateObjectData> statoSocio = (List<StateObjectData>) session.getAttribute("statoSocioList");
		model.addAttribute("statoSocioList", statoSocio);

		List<StateObjectData> qualitaTitolare = (List<StateObjectData>) session.getAttribute("qualitaTitolareList");
		model.addAttribute("qualitaTitolareList", qualitaTitolare);

		List<StateObjectData> settoreImpresa = (List<StateObjectData>) session.getAttribute("settoreImpresaList");
		model.addAttribute("settoreImpresaList", settoreImpresa);

		List<StateObjectData> tipoSocieta = (List<StateObjectData>) session.getAttribute("tipoSocietaList");
		model.addAttribute("tipoSocietaList", tipoSocieta);

		List<StateObjectData> atecoList = (List<StateObjectData>) session.getAttribute("atecoList");
		model.addAttribute("atecoList", atecoList);

		model.addAttribute("sociData", sociData);
	}

	@RequestMapping(value = "/addSocio", method = RequestMethod.POST)
	public String inserisciSocioPost(final Model model, @ModelAttribute("sociData") SociData socio,
			@RequestParam("to[]") List<Integer> idAteco, BindingResult bindingResult, final HttpServletRequest request,
			final HttpServletResponse response) {

		try {
			sociValidator.validate(socio, bindingResult);
			if(bindingResult.hasErrors()) {
				model.addAttribute("sociData", socio);
				return "insertSoci";
			}
			int socioId = 0;
			socioId = sociFacade.getIdSocioByPIva(socio.getPartitaIva());
			if (socioId == 0) {
				if (!(CollectionUtils.isEmpty(idAteco))) {
					socio.setIdAteco(idAteco);
				}
				socio = sociFacade.addSocio(socio);
				model.addAttribute("confirmMsg",
						messageSource.getMessage("insert.socio", null, LocaleContextHolder.getLocale()));
			}else {
				socio = sociFacade.dettaglioSocio(socioId);
				model.addAttribute("confirmMsg",
						messageSource.getMessage("exist.socio", null, LocaleContextHolder.getLocale()));
			}
		} catch (ParseException e) {
			logger.error("Si è verificato un errore nell'inserimento del socio", e.getCause());
		}

		setModelPage(model, socio, request.getSession());

		List<StateObjectData> atecoSelected = createListAtecoSelected(socio,
				(List<StateObjectData>) request.getSession().getAttribute("atecoList"));
		model.addAttribute("atecoSelected", atecoSelected);

		model.addAttribute("confirmMsg",
				messageSource.getMessage("insert.socio", null, LocaleContextHolder.getLocale()));
		return "modificaSocio";
	}

	@RequestMapping(value = "/modificaSocio", method = RequestMethod.GET)
	public String modificaSocioPost(final Model model, @RequestParam("idSocio") Integer idSocio,
			final HttpServletRequest request, final HttpServletResponse response) {

		SociData socio = new SociData();
		try {
			socio = sociFacade.dettaglioSocio(idSocio);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("Si è verificato un errore nella lettura del socio", e.getCause());
		}

		setModelPage(model, socio, request.getSession());

		List<StateObjectData> atecoSelected = atecoFacede.getAtecoFromSocio(idSocio);

		model.addAttribute("atecoSelected", atecoSelected);

		List<FinanziamentiTableData> finanziamentiList = finanziamentiFacade.getFinanziamentioListBySocio(idSocio);
		model.addAttribute("finanziamentiList", finanziamentiList);

		return "modificaSocio";
	}

	@RequestMapping(value = "/updateSocio", method = RequestMethod.POST)
	public String modificaSocioPost(final Model model, @ModelAttribute("sociData") SociData socio,
			@RequestParam("to[]") List<Integer> idAteco, BindingResult bindingResult, final HttpServletRequest request,
			final HttpServletResponse response) {

		try {
			sociValidator.validate(socio, bindingResult);
			if(bindingResult.hasErrors()) {
				model.addAttribute("sociData", socio);
				return "modificaSocio";
			}
			if (!(CollectionUtils.isEmpty(idAteco))) {
				socio.setIdAteco(idAteco);
			}
			sociFacade.modificaSocio(socio);
			model.addAttribute("confirmMsg",
					messageSource.getMessage("modifica.socio", null, LocaleContextHolder.getLocale()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setModelPage(model, socio, request.getSession());

		List<StateObjectData> atecoSelected = atecoFacede.getAtecoFromSocio(socio.getIdSoci());

		model.addAttribute("atecoSelected", atecoSelected);

		List<FinanziamentiTableData> finanziamentiList = finanziamentiFacade
				.getFinanziamentioListBySocio(socio.getIdSoci());
		model.addAttribute("finanziamentiList", finanziamentiList);

		return "modificaSocio";
	}

	private List<StateObjectData> createListAtecoSelected(SociData socio, List<StateObjectData> atecoList) {
		List<Integer> atecoSel = socio.getIdAteco();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		if (!CollectionUtils.isEmpty(atecoSel)) {
			for (Integer atecoIdSel : atecoSel) {
				for (StateObjectData atecoId : atecoList) {
					if (atecoId.getId() == (atecoIdSel.intValue())) {
						result.add(atecoId);
					}
				}
			}
		}
		return result;
	}
}
