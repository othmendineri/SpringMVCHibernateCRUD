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
import com.jwt.model.Client;
import com.jwt.service.ClientService;

@Controller

public class ClientController {

	//private static final Logger logger = Logger.getLogger(ClientController.class);

	public ClientController() {
		System.out.println("ClientController()");
	}

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/clientlist")
	public ModelAndView listClient(ModelAndView model) throws IOException {
		List<Client> listClient = clientService.getAllClients();
		model.addObject("listClient", listClient);
		model.setViewName("ClientList");//Il faut avoir une page jsp avec nom ClientList
		return model;
	}
	
	

	@RequestMapping(value = "/newClient", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Client client = new Client();
		model.addObject("client", client);
		model.setViewName("ClientForm");
		return model;
	}

	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public ModelAndView saveClient(@ModelAttribute Client client) {
		if (client.getId() == 0) {
			clientService.addClient(client);
		} else {
			clientService.updateClient(client);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public ModelAndView deleteClient(HttpServletRequest request) {
		int clientId = Integer.parseInt(request.getParameter("id"));
		clientService.deleteClient(clientId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editClient", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int clientId = Integer.parseInt(request.getParameter("id"));
		Client client = clientService.getClient(clientId);
		ModelAndView model = new ModelAndView("ClientForm");
		model.addObject("client", client);

		return model;
	}

}