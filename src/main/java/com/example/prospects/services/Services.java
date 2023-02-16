package com.example.prospects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.prospects.model.Client;
import com.example.prospects.repository.ClientsRepo;

//Déclaration de la classe comme étant un bean
@Component
public class Services {
	// Injection des dépendances via les beans
	@Autowired
	private ClientsRepo clientsRepo;

	/**
	 * Récupération de toutes les données de la table en BDD
	 * @return liste d'objets Client
	 */
	public List<Client> getData() {
		return clientsRepo.findAll();
	}
	
	/**
	 * Récupération d'un client en BDD avec son ID
	 * @param id : entier non nul
	 * @return Client trouvé ou null
	 */
	public Client getClientById(int id) {
		// On stocke le résultat de la requête dans un optionnel
		Optional<Client> result = clientsRepo.findById(id);
		// On crée une instance de Client nulle
		Client client = null;
		// On vérifie si le client a été trouvé
		if (result.isPresent()) {
			// On récumère le Client dans l'optionnel
			client = result.get();
		}
		// On retourne le client OU null s'il n'a pas été trouvé
		return client;
	}

	/**
	 * Enregistrement d'un client (nouveau ou modifié) dans la BDD
	 * @param client : Client à enregistrer
	 * @return le client enregistré
	 */
	public Client saveClient(Client client) {
		return clientsRepo.save(client);
	}
	
	/**
	 * Suppression d'un client dans la BDD avec son ID
	 * @param id : entier non nul
	 */
	public void removeClientById(int id) {
			clientsRepo.deleteById(id);
	}
}
