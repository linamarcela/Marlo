package com.institution.model;

/*
 * @autor: Lina Marcela Colorado Vivas
 * Ingeniera de sistemas
 * Conexion
 */

public class Institucion {
	private int id;
	private String acronym;
	private String nam;
	private String web;
	private String insti;
	
	public Institucion(int id, String acronym, String nam, String web, String insti) {
		this.id = id;
		this.acronym = acronym;
		this.nam = nam;
		this.web = web;
		this.insti = insti;
		
	}
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getNam() {
		return nam;
	}
	public void setnam(String nam) {
		this.nam = nam;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getInsti() {
		return insti;
	}
	public void setInsti(String insti) {
		this.insti = insti;
	}
	
}
