package com.example.prospects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.prospects.model.Client;
import com.example.prospects.services.Services;

// Déclaration de la classe comme étant un controlleur
@Controller
public class AppControl {
	
	// Injection des dépendances via les beans
	@Autowired
	private Services services;
	
	// Injections de variables via application.properties
	@Value("${error.message}")
	private String errorMessage;
	
	// Fonction de mapping : lie un fichier .html à un ou plusieurs chemins, indiqués dans le paramètre value
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		// On retourne le nom du fichier .html à utiliser
		return "index";
	}
	
	// Affichage de la liste des clients ; autre syntaxe pour un mapping en GET
	@GetMapping("/clientList")
	public String clientList(Model model) {
		// Injection des données dans la page HTML : on crée une variable "clients" dans le HTML, dans laquelle on place les données renvoyées par le service
		model.addAttribute("clients", services.getData());
		return "clientList";
	}

	// Affichage du formulaire pour ajouter un client
	@RequestMapping(value = {"/addClient"}, method = RequestMethod.GET)
	public String showAddClientPage(Model model) {
		
		// Création d'un objet client vide et injection dans la page HTML pour qu'il puisse être utilisé dans le formulaire
		Client clientForm = new Client();
		model.addAttribute("clientForm", clientForm);
		
		return "clientForm";
	}

	// Affichage du formulaire pré-rempli pour modifier un client
	@RequestMapping(value = {"/updateClient/{id}"}, method = RequestMethod.GET)
	public String showUpdateClientPage(Model model, @PathVariable(value = "id") int id) {

		// On va chercher le client à modifier dans la base de données
		Client client = services.getClientById(id);
		// On injecte le client dans la page HTML pour qu'il soit affiché dans le formulaire
		model.addAttribute("clientForm", client);
		
		// On utilise le même fichier .html que pour la création d'un client (DRY)
		return "clientForm";
	}
	
	// Sauvegarde d'un client (nouveau ou modifier) ; mapping en POST : définit une action à effectuer
	@RequestMapping(value = {"/saveClient"}, method = RequestMethod.POST)
	public String saveClient(Model model, //
			// On définit l'objet avec lequel on a créé le formulaire et qui servira à récupérer les données
			@ModelAttribute("clientForm") Client client) {
		
		// On vérifie que tous les champs ont été remplis
		if (client.getName().length() > 0 && client.getSiret().length() > 0 && client.getAddress().length() > 0 && client.getPostCode().length() > 0 && client.getCity().length() > 0) {
			services.saveClient(client);
			// On utilise redirect pour appeler une autre fonction de mapping
			return "redirect:/clientList";
		}
		
		// Si au moins un champ est vide, on affiche un message d'erreur (celui de application.properties)
		model.addAttribute("errorMessage", errorMessage);
		// Et on reste sur le formulaire
		return "clientForm";
	}
	
	// Suppression d'un client
	@RequestMapping(value = {"/deleteClient/{id}"}, method = RequestMethod.GET)
	public String removeClient(@PathVariable(value = "id") int id) {
		// On appelle la fonction de suppression
		services.removeClientById(id);
		// On utilise redirect pour appeler une autre fonction de mapping
		return "redirect:/clientList";
	}
}
