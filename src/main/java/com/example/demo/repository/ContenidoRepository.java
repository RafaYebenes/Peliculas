package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Contenido;

public interface ContenidoRepository extends MongoRepository<Contenido, String>{

	    public List<Contenido> findByName(String name);
	    public List<Contenido> findByGenero(String genero);
	
}
