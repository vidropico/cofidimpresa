package it.cofidimpresa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.facades.impl.DefaultAtecoFacade;

@Controller
public class AtecoController {
	private static final Logger logger = Logger.getLogger(AtecoController.class);

	@Resource(name = "atecoFacade")
	public DefaultAtecoFacade atecoFacade;

	@RequestMapping(value = "**/removeAteco/{idSocio}/{idAteco}", method = RequestMethod.GET)
	public @ResponseBody String removeAteco(@PathVariable("idSocio") Integer idSocio, @PathVariable("idAteco") Integer idAteco,
			final HttpServletRequest request, final HttpServletResponse response, final Model model) {
		atecoFacade.removeAteco(idSocio, idAteco);
		List<StateObjectData> atecoSelected = atecoFacade.getAtecoFromSocio(idSocio);
		model.addAttribute("atecoSelected", atecoSelected);
		return "OK";

	}
}
