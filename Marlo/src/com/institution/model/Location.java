package com.institution.model;

/*
 * @autor: Lina Marcela Colorado Vivas
 * Ingeniera de sistemas
 * Conexion
 */

public class Location {
	private int id;
	private String city;
	private String name;
	

	
	public Location(int id, String city, String name) {
		this.id = id;
		this.city = city;
		this.name = name;
	}
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
