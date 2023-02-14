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
		System.out.println("1- Ajouter un client");
		System.out.println("2- Modifier un client");
		System.out.println("3- Retirer un client");
		System.out.println("0- Quitter");
	}
	
	public void choiceMenu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			disp.dispayClientsList(services.getData());
			showMenu();
			System.out.println("Votre choix :");
			String choice = scanner.nextLine();
			getChoice(choice);
		}
	}

	public void getChoice(String choice) {

		switch (choice) {
		case "1":
			if (services.addClient()) {
				System.out.println("Client ajouté");
			} else {
				System.out.println("Erreur");
			}
			break;
		case "2":
			services.editClient();
			break;
		case "3":
			if (services.removeClient()) {
				System.out.println("Client supprimé");
			} else {
				System.out.println("Erreur");
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
