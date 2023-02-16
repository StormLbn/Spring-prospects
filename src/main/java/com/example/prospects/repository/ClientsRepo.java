package com.example.prospects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prospects.model.Client;

// Classe de type "Repository" pour communiquer avec la BDD grâce à l'interface JpaRepository
@Repository
public interface ClientsRepo extends JpaRepository<Client, Integer> {

}
