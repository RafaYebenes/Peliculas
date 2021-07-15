package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Enlace;

public interface IEnlacesService {

	public List<Enlace> getAll();
	public void save(Enlace enlace);
	public List<Enlace> getEnlacesByIdPelicula(String idPelicula);

}
