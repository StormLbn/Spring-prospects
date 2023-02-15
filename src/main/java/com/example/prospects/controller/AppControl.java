package com.example.prospects.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.prospects.form.ClientForm;
import com.example.prospects.model.Client;
import com.example.prospects.services.Services;
import com.example.prospects.vue.Display;

//// Déclaration de la classe comme étant un bean
//@Component

// Déclaration de la classe comme étant un controlleur
@Controller
public class AppControl {
	
	// Injection des dépendances via les beans
	@Autowired
	private Services services;
//	@Autowired
//	private Display disp;
	
	// Injections via application.properties
	@Value("${error.message}")
	private String errorMessage;
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = {"/clientList"}, method = RequestMethod.GET)
	public String clientList(Model model) {
		// Injection des données dans la page HTML
		model.addAttribute("clients", services.getData());
		
		return "clientList";
	}

	@RequestMapping(value = {"/addClient"}, method = RequestMethod.GET)
	public String showAddClientPage(Model model) {
		
		// Création d'un objet formulaire et injection dans la page HTML
		ClientForm clientForm = new ClientForm();
		model.addAttribute("clientForm", clientForm);
		
		return "addClient";
	}
	
	@RequestMapping(value = {"/addClient"}, method = RequestMethod.POST)
	public String saveClient(Model model, //
			@ModelAttribute("clientForm") ClientForm clientForm) {
		
		Client client = new Client();
		client.setName(clientForm.getName());
		client.setSiret(clientForm.getSiret());
		client.setAddress(clientForm.getAddress());
		client.setPostcode(clientForm.getPostcode());
		client.setCity(clientForm.getCity());
		
		if (client.getName().length() > 0 && client.getSiret().length() > 0 && client.getAddress().length() > 0 && client.getPostcode().length() > 0 && client.getCity().length() > 0) {
//			clients.add(client);
			if (services.addClient(client) != null) {
				return "redirect:/clientList";
			}
		}
		
		model.addAttribute("errorMessage", errorMessage);
		return "addClient";
	}

//	public void run() {
//		choiceMenu();
//	}
//	
//	public void showMenu() {
//		System.out.println("\n=== MENU PRINCIPAL ===");
//		System.out.println("1- Ajouter un client");
//		System.out.println("2- Modifier un client");
//		System.out.println("3- Retirer un client");
//		System.out.println("0- Quitter");
//	}
//	
//	public void choiceMenu() {
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			disp.dispayClientsList(services.getData());
//			showMenu();
//			System.out.println("Votre choix :");
//			String choice = scanner.nextLine();
//			getChoice(choice);
//		}
//	}
//
//	public void getChoice(String choice) {
//
//		switch (choice) {
//		case "1":
//			if (services.addC> 0 != null) {
//				System.out.println("Client ajouté");
//			} else {
//				System.out.println("Erreur");
//			}
//			break;
//		case "2":
//			services.editClient();
//			break;
//		case "3":
//			if (services.removeClient()) {
//				System.out.println("Client supprimé");
//			} else {
//				System.out.println("Erreur");
//			}
//			break;
//		case "0":
//			System.out.println("Au revoir !");
//			System.exit(0);
//		default:
//			System.out.println("Erreur de saisie, réessayez !");
//		}
//	}
}
