package com.example.prospects.vue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.prospects.model.Client;

@Component
public class Display {

	public void dispayClientsList(List<Client> list) {
		System.out.println("===== LISTE DES CLIENTS =====");
		for (Client client : list) {
			System.out.println(client);
		}
	}
}
