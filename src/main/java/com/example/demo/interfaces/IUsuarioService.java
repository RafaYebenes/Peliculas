package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Usuario;

public interface IUsuarioService {

	public List<Usuario> getAll();
	public void addUsuario(Usuario user);
	public void deleteUsuario(String id);
	public Usuario getUserById(String id);
	public boolean login(Usuario user);
	public Usuario getUserByName(String name);
}
