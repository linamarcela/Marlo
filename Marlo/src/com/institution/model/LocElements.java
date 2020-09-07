package com.institution.model;

/*
 * @autor: Lina Marcela Colorado Vivas
 * Ingeniera de sistemas
 * Conexion
 */

public class LocElements {
	private int id;
	private String name;	
	

	
	public LocElements(int id, String name) {
		this.id = id;
		this.name = name;
	}
	//getters y setters
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
}
