package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IEnlacesService;
import com.example.demo.model.Enlace;
import com.example.demo.repository.EnlaceRepository;

@Service
public class EnlaceService implements IEnlacesService{
	
	@Autowired
	EnlaceRepository eRepo;
	
	@Override
	public List<Enlace> getAll() {
		return eRepo.findAll();
	}

	@Override
	public void save(Enlace enlace) {
		eRepo.save(enlace);
	}

	@Override
	public List<Enlace> getEnlacesByIdPelicula(String idPelicula) {
		return eRepo.getEnlacesByIdPelicula(idPelicula);
	}

}
