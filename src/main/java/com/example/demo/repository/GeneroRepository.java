package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Genero;

public interface GeneroRepository extends MongoRepository<Genero, String> {

}
