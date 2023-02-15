package com.example.prospects.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.prospects.model.Client;
import com.example.prospects.repository.ClientsRepo;
//import com.example.prospects.repository.Data;

//Déclaration de la classe comme étant un bean
@Component
public class Services {
//	@Autowired
//	private Data data;
	@Autowired
	private ClientsRepo clientsRepo;
	
	public List<Client> getData() {
		return clientsRepo.findAll();
//		return data.getData();
	}
//
//	public void editClient() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("ID du client à modifier :");
//		String input = scanner.nextLine();
////		ArrayList<Client> clientsList = data.getData();
//		List<Client> clientsList = clientsRepo.findAll();
//
//		try {
//			int id = Integer.parseInt(input);
//			for (Client client : clientsList) {
//				if (id == (client.getId())) {
//					System.out.println("Nom du client :");
//					client.setName(scanner.nextLine());
//					System.out.println("N° Siret :");
//					client.setSiret(scanner.nextLine());
//					System.out.println("Adresse :");
//					client.setAddress(scanner.nextLine());
//					System.out.println("Code postal :");
//					client.setPostcode(scanner.nextLine());
//					System.out.println("Ville :");
//					client.setCity(scanner.nextLine());
//					clientsRepo.save(client);
//				}
//			}
//			
//		} catch (Exception e) {
//			System.out.println("Merci d'entrer un ID valide");
//		}
//	}
//
	public Client addClient(Client client) {
//		Client client = new Client();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nom du client :");
//		client.setName(scanner.nextLine());
//		System.out.println("N° Siret :");
//		client.setSiret(scanner.nextLine());
//		System.out.println("Adresse :");
//		client.setAddress(scanner.nextLine());
//		System.out.println("Code postal :");
//		client.setPostcode(scanner.nextLine());
//		System.out.println("Ville :");
//		client.setCity(scanner.nextLine());
////		return data.addData(client);
		return clientsRepo.save(client);
	}
//	
//	public boolean removeClient() {
//		while (true) {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("ID du client à supprimer :");
//			String input = scanner.nextLine();
//			try {
//				int id = Integer.parseInt(input);
////				return data.removeData(id);
//				clientsRepo.deleteById(id);
//				return true;
//			} catch (Exception e) {
//				System.out.println("Merci d'entrer un ID valide");
//			}
//		}
//	}
}
