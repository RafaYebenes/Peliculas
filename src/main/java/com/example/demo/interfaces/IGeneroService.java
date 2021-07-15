package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Genero;

public interface IGeneroService {

	public List<Genero> getAll();
	public void save(Genero genero);
	public Genero findById(String id);
	
}
