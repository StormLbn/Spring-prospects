package com.example.prospects.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

// Permet de lier la classe à une table MySQL du même nom
@Entity
public class Client {
	// Indique que ce paramètre est obligatoire car sert pour l'identification
	@Id
	// Permet de gérérer automatiquement l'ID (à coupler avec Auto_increment)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// Nommer les paramètres en camelCase ; chaque majuscule sera transformée en underscore+minuscule lors des requêtes par JpaRepository
	private String name;
	private String siret;
	private String address;
	private String postCode;	// Deviendra post_code en BDD
	private String city;
	
	// L'interface JpaRepository a besoin d'un constructeur vide pour fonctionner
	public Client() {}
	
	public Client(int id, String name, String siret, String address, String postcode, String city) {
		this.id = id;
		this.name = name;
		this.siret = siret;
		this.address = address;
		this.postCode = postcode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Client n°" + id + " : " + name + ", N° Siret : " + siret + ", Adresse : " + address + ", " + postCode
				+ " " + city;
	}

	// Attention de respecter la même casse pour les getters/setters que pour les paramètres !
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postcode) {
		this.postCode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
