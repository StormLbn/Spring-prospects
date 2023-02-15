package com.example.prospects.vue;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.prospects.model.Client;

@Component
public class Display {

	public void dispayClientsList(List<Client> clients) {
		System.out.println("===== LISTE DES CLIENTS =====");
		for (Client client : clients) {
			System.out.println(client);
		}
	}
}
