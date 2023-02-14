package com.example.prospects.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.prospects.model.Client;
import com.example.prospects.services.Services;
import com.example.prospects.vue.Display;

@Component
public class AppControl {
	@Autowired
	private Services services;
	@Autowired
	private Display disp;

	public void run() {
		choiceMenu();
	}
	
	public void showMenu() {
		System.out.println("\n=== MENU PRINCIPAL ===");
		System.out.println("1- Voir les clients");
		System.out.println("2- Ajouter un client");
		System.out.println("3- Retirer un client");
		System.out.println("0- Quitter");
	}
	
	public void choiceMenu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			showMenu();
			System.out.println("Votre choix :");
			String choice = scanner.nextLine();
			getChoice(choice);
		}
	}

	public void getChoice(String choice) {

		switch (choice) {
		case "1":
			disp.dispayClientsList(services.getData());
			break;
		case "2":
			if (services.addClient()) {
				System.out.println("Client ajouté");
			} else {
				System.out.println("Erreur");
			}
			break;
		case "3":
			Client client = services.removeClient();
			if (client != null) {
				System.out.println("Suppression du client n°" + client.getId() + " (" + client.getName() + ")");
			}
			break;
		case "0":
			System.out.println("Au revoir !");
			System.exit(0);
		default:
			System.out.println("Erreur de saisie, réessayez !");
		}
	}
}
