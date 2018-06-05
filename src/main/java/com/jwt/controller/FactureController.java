package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jwt.model.Facture;
import com.jwt.service.FactureService;

@Controller

public class FactureController {

	private static final Logger logger = Logger.getLogger(FactureController.class);

	public FactureController() {
		System.out.println("FactureController()");
	}

	@Autowired
	private FactureService factureService;

	@RequestMapping(value = "/factureslist")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Facture> listFacture = factureService.getAllFactures();
		model.addObject("listFacture", listFacture);
		model.setViewName("FacturesList");
		return model;
	}
	

	@RequestMapping(value = "/newFacture", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Facture facture = new Facture();
		model.addObject("facture", facture);
		model.setViewName("FactureForm");
		return model;
	}

	@RequestMapping(value = "/saveFacture", method = RequestMethod.POST)
	public ModelAndView saveFacture(@ModelAttribute Facture facture) {
		if (facture.getNumFacture() == 0) { 
			factureService.addFacture(facture);
		} else {
			factureService.updateFacture(facture);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteFacture", method = RequestMethod.GET)
	public ModelAndView deleteFacture(HttpServletRequest request) {
		int numFacture = Integer.parseInt(request.getParameter("numFacture"));
		factureService.deleteFacture(numFacture);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editFacture", method = RequestMethod.GET)
	public ModelAndView editFacture(HttpServletRequest request) {
		int numFacture = Integer.parseInt(request.getParameter("numFacture"));
		Facture facture = factureService.getFacture(numFacture);
		ModelAndView model = new ModelAndView("FactureForm");
		model.addObject("facture", facture);

		return model;
	}

}