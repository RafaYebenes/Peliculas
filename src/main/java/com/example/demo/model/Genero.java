package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class Genero {

	@Id
	private String id;
	private String name;
	
	public Genero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genero(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
