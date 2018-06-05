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
import com.jwt.model.Provider;
import com.jwt.service.ProviderService;

@Controller

public class ProviderController {

	private static final Logger logger = Logger.getLogger(ProviderController.class);

	public ProviderController() {
		System.out.println("ProviderController()");
	}

	@Autowired
	private ProviderService providerService;

	@RequestMapping(value = "/providerlist")
	public ModelAndView listProvider(ModelAndView model) throws IOException {
		List<Provider> listProvider = providerService.getAllProvider();
		model.addObject("listProvider", listProvider);
		model.setViewName("ProviderList");//Il faut avoir une page jsp de nom ProviderList
		return model;
	}
	
	

	@RequestMapping(value = "/newProvider", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Provider provider = new Provider();
		model.addObject("provider", provider);
		model.setViewName("ProviderForm");
		return model;
	}

	@RequestMapping(value = "/saveProvider", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Provider provider) {
		if (provider.getId() == 0) {
			providerService.addProvider(provider);
		} else {
			providerService.updateProvider(provider);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteProvider", method = RequestMethod.GET)
	public ModelAndView deleteProvider(HttpServletRequest request) {
		int providerId = Integer.parseInt(request.getParameter("id"));
		providerService.deleteProvider(providerId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editProvider", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int providerId = Integer.parseInt(request.getParameter("id"));
		Provider provider = providerService.getProvider(providerId);
		ModelAndView model = new ModelAndView("ProviderForm");
		model.addObject("provider", provider);

		return model;
	}

}