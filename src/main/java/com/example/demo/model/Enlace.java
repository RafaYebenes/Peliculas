package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class Enlace {
	@Id
	private String id;
	private String idPelicula;
	private String plataforma;
	private String link;
	
	public Enlace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enlace(String idPelicula, String plataforma, String link) {
		super();
		this.idPelicula = idPelicula;
		this.plataforma = plataforma;
		this.link = link;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(String idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
