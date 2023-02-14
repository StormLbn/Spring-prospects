package com.example.prospects.services;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.prospects.model.Client;
import com.example.prospects.repository.Data;

@Component
public class Services {
	@Autowired
	private Data data;
	
	public ArrayList<Client> getData() {
		return data.getData();
	}
	
	public boolean addClient() {
		Client client = new Client();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nom du client :");
		client.setName(scanner.nextLine());
		System.out.println("N° Siret :");
		client.setSiret(scanner.nextLine());
		System.out.println("Adresse :");
		client.setAddress(scanner.nextLine());
		System.out.println("Code postal :");
		client.setPostcode(scanner.nextLine());
		System.out.println("Ville :");
		client.setCity(scanner.nextLine());
		return data.addData(client);
	}
	
	public Client removeClient() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("ID du client à supprimer :");
			String input = scanner.nextLine();
			try {
				int id = Integer.parseInt(input);
				return data.removeData(id - 1);
			} catch (Exception e) {
				System.out.println("Merci d'entrer un ID valide");
			}
		}
	}
}
