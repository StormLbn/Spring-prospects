package com.example.prospects.controller;

//import java.util.List;
//import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.prospects.form.ClientForm;
import com.example.prospects.model.Client;
//import com.example.prospects.repository.ClientsRepo;
import com.example.prospects.services.Services;

@Controller
public class AppControl {

	@Autowired
	private Services sr;

	@Value("${welcome.message}")
	private String message;
	
	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("message", message);

		return "index";
	}

	@RequestMapping(value = { "/clientList" }, method = RequestMethod.GET)
	public String clientList(Model model) {

		model.addAttribute("clients", sr.getAllClients());

		return "clientList";
	}

	@RequestMapping(value = { "/addClient" }, method = RequestMethod.GET)
	public String showAddClientPage(Model model) {

		ClientForm clientForm = new ClientForm();
		model.addAttribute("clientForm", clientForm);

		return "addClient";
	}

	@RequestMapping(value = { "/addClient" }, method = RequestMethod.POST)
	public String savePerson(Model model, //
			@ModelAttribute("clientForm") ClientForm clientForm) {
		Client newClient = new Client();
		newClient.setName(clientForm.getName());
		newClient.setSiret(clientForm.getSiret());
		newClient.setAddress(clientForm.getAddress());
		newClient.setPostcode(clientForm.getPostcode());
		newClient.setCity(clientForm.getCity());
		if (newClient.getName().length() > 0 && newClient.getSiret().length() > 0 && newClient.getAddress().length() > 0
				&& newClient.getPostcode().length() > 0 && newClient.getCity().length() > 0) {
			sr.addClient(newClient);
			return "redirect:/clientList";
		}
		model.addAttribute("errorMessage", errorMessage);
		return "addClient";
	}
	
	@RequestMapping(value = { "/saveClient" }, method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client) {
		// save employee to database
		sr.saveClient(client);
		return "redirect:/clientList";
	}
	
	 @RequestMapping(value = {"/formUpdateClient/{id}"}, method = RequestMethod.GET)
	    public String formUpdateClient(@PathVariable(value = "id") int id, Model model) {

	        // get employee from the service
	        Client client = sr.getClientById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("client", client);
	        return "formUpdateClient";
	    }
	
	@RequestMapping(value = { "/deleteClient/{id}" }, method = RequestMethod.GET)
	public String deleteClient(@PathVariable(value = "id") int id) {

		// call delete employee method
		this.sr.deleteClientById(id);
		return "redirect:/clientList";
	}
}
