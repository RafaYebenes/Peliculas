package com.example.demo.configuration;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Genero;
import com.example.demo.model.Usuario;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.services.UsuarioService;

@Component
public class AppRunner implements CommandLineRunner {

	protected Logger logger;
	
	@Autowired
	UsuarioRepository uRepo;
	
	@Autowired
	GeneroRepository gRepo;
	
	
	public AppRunner() {
		logger = Logger.getLogger(getClass().getName());
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("dataSource() invoked");
		
		
//		vrepo.deleteAll();
//		
//		Vuelos v = new Vuelos("Barcelona", 2, LocalDateTime.now(), "T", "T1");
//		vrepo.save( new Vuelos("Zaragoza", 1, LocalDateTime.now(), "T", "T2"));
//		vrepo.save( new Vuelos("Sevilla", 3, LocalDateTime.now(), "T", "T4"));
//		vrepo.save( new Vuelos("Paris", 2, LocalDateTime.now(), "T", "T3"));
//		vrepo.save( new Vuelos("Sevilla", 3, LocalDateTime.now(), "T", "T2"));
		
//		System.out.println("********************************************");
//		System.out.println("**********TODOS LOS VUELOS******************");
//		System.out.println("********************************************");
//		
//		for(Vuelos vuelo : vrepo.findAll()) {
//			System.out.println(vuelo);
//		}
//		
//		
//		System.out.println("********************************************");
//		System.out.println("**********VUELOS ORIGEN MADRID**************");
//		System.out.println("********************************************");
//		
//		for(Vuelos vuelo : vrepo.findByEstado("T")) {
//			System.out.println(vuelo);
//		}
//		
//		System.out.println("********************************************");
//		System.out.println("**********VUELOS POR ID*********************");
//		System.out.println("********************************************");
//		
//		//System.out.println(vrepo.findById("60d2d535433543330b4bb096").get());
		
	}

}

