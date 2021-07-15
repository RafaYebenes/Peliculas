package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IUsuarioService;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	UsuarioRepository uRepo;

	@Override
	public List<Usuario> getAll() {
		return uRepo.findAll();
	}

	@Override
	public void addUsuario(Usuario user) {
		uRepo.save(user);
	}

	@Override
	public void deleteUsuario(String id) {
		if(uRepo.existsById(id))
		uRepo.deleteById(id);

	}

	@Override
	public Usuario getUserById(String id) {
		return uRepo.findById(id).get();
	}

	@Override
	public boolean login(Usuario user) {
		
		if(uRepo.existsByUsername(user.getUsername()) && uRepo.existsByPassword(user.getPassword()) ) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Usuario getUserByName(String name) {
		return uRepo.getUserByUsername(name);
	}

}
