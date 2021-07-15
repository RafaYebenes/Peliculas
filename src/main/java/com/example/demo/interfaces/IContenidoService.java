package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Contenido;

public interface IContenidoService {

	public List<Contenido> getAll();
	public void save(Contenido contenido);
	public Contenido getById(String id);
	public List<Contenido> getPeliculas();
	public List<Contenido> getSeries();
	public List<Contenido> findByName(String name);
	public List<Contenido> findPeliculasByName(String name);
	public List<Contenido> findSeriesByName(String name);
	public List<Contenido> findByGenero(String genero);
	public List<Contenido> findByQuery(Contenido c);
	public void delete(String id);
}
