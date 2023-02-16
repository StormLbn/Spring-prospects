package com.example.prospects.services;
//
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
import com.example.prospects.model.Client;
import com.example.prospects.repository.ClientsRepo;

@Service
public class Services {

	@Autowired
	private ClientsRepo cr;
	
	public List<Client> getAllClients() {
		return cr.findAll();
	}
	
	public Client addClient(Client client) {
		return cr.save(client);
	}

	public void deleteClientById(int id) {
		this.cr.deleteById(id);
	}
	
	public void saveClient(Client client) {
		this.cr.save(client);
	}

	public Client getClientById(int id) {
		
        Optional < Client > optional = cr.findById(id);
        Client client = null;
        if (optional.isPresent()) {
            client = optional.get();
        } else {
            throw new RuntimeException(" Le client n° :: " + id + " n'a pas été trouvé");
        }
        return client;
	}
	
}

