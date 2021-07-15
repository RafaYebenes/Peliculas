package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IGeneroService;
import com.example.demo.model.Genero;
import com.example.demo.repository.GeneroRepository;

@Service
public class GeneroService implements IGeneroService {

	@Autowired
	GeneroRepository gRepo;
	
	@Override
	public List<Genero> getAll() {
		return gRepo.findAll();
	}

	@Override
	public void save(Genero genero) {
		 gRepo.save(genero);

	}

	@Override
	public Genero findById(String id) {
		return gRepo.findById(id).get();
	}

}
