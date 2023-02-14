package com.example.prospects.model;

public class Client {
	private int id;
	private String name;
	private String siret;
	private String address;
	private String postcode;
	private String city;
	
	public Client() {}
	
	public Client(int id, String name, String siret, String address, String postcode, String city) {
		this.id = id;
		this.name = name;
		this.siret = siret;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Client n°" + id + " : " + name + ", N° Siret : " + siret + ", Adresse : " + address + ", " + postcode
				+ " " + city;
	}

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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
