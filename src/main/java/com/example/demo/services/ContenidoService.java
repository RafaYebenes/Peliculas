package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IContenidoService;
import com.example.demo.model.Contenido;
import com.example.demo.repository.ContenidoRepository;

@Service
public class ContenidoService implements IContenidoService {

	@Autowired
	ContenidoRepository cRepo;

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public List<Contenido> getAll() {
		return cRepo.findAll();
	}

	@Override
	public void save(Contenido contenido) {
		contenido.setFechaSubida(new Date());
		cRepo.save(contenido);

	}

	@Override
	public Contenido getById(String id) {
		return cRepo.findById(id).get();
	}

	@Override
	public List<Contenido> getPeliculas() {

		List<Contenido> peliculas = new ArrayList<Contenido>();

		for (Contenido c : cRepo.findAll()) {
			if (c.isEsPelicula()) {
				peliculas.add(c);
			}
		}

		return peliculas;
	}

	@Override
	public List<Contenido> getSeries() {

		List<Contenido> series = new ArrayList<Contenido>();

		for (Contenido c : cRepo.findAll()) {
			if (c.isEsSerie()) {
				series.add(c);
			}
		}

		return series;
	}

	@Override
	public List<Contenido> findByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(toLikeRegex(name)));

		return mongoOperations.find(query, Contenido.class);
	}

	private String toLikeRegex(String source) {
		return source.replaceAll("\\*", ".*");
	}

	@Override
	public List<Contenido> findPeliculasByName(String name) {
		// TODO Auto-generated method stub
		return cRepo.findByName(name).stream().filter(m -> m.isEsPelicula()).collect(Collectors.toList());
	}

	@Override
	public List<Contenido> findSeriesByName(String name) {
		// TODO Auto-generated method stub
		return cRepo.findByName(name).stream().filter(m -> m.isEsSerie()).collect(Collectors.toList());
	}

	@Override
	public List<Contenido> findByGenero(String genero) {

		return cRepo.findByGenero(genero);
	}

	@Override
	public List<Contenido> findByQuery(Contenido c) {

		List<Contenido> contenido = cRepo.findAll();
		if (c.getGenero() != null && !c.getGenero().equals("todos")) {
			contenido = contenido.stream().filter(m -> m.getGenero().equals(c.getGenero())).collect(Collectors.toList());
		}
		if (c.getPuntuacion() > 0.0) {
			contenido = contenido.stream().filter(m -> m.getPuntuacion() == c.getPuntuacion()).collect(Collectors.toList());
		}

		return contenido;
	}

	@Override
	public void delete(String id) {
		if(cRepo.existsById(id)) {
			cRepo.deleteById(id);
		}
		
	}


}
