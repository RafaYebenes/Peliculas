package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	public boolean existsByUsername(String username);
	public boolean existsByPassword(String password);
	public Usuario getUserByUsername(String name);
}
