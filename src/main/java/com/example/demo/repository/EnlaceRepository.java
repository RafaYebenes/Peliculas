package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Enlace;

public interface EnlaceRepository extends MongoRepository<Enlace, String>{

	public List<Enlace> getEnlacesByIdPelicula(String idPelicula);
}
