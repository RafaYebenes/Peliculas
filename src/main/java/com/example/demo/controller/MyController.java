package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Contenido;
import com.example.demo.model.Enlace;
import com.example.demo.model.Usuario;
import com.example.demo.services.ContenidoService;
import com.example.demo.services.EnlaceService;
import com.example.demo.services.GeneroService;
import com.example.demo.services.UsuarioService;

@Controller
public class MyController {

	@Autowired
	UsuarioService uService;

	@Autowired
	ContenidoService cService;

	@Autowired
	EnlaceService eService;

	@Autowired
	GeneroService gService;

	Usuario user = new Usuario();

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/usuario/registro")
	public String registroPage(Model model) {

		model.addAttribute("usuario", new Usuario());
		return "registro";
	}

	@RequestMapping("/usuario/registrar")
	public String registrar(Usuario usuario, Model model) {

		usuario.setRol("user");
		uService.addUsuario(usuario);

		return "index";
	}

	@RequestMapping("/usuario/login")
	public String loginPage(Model model) {

		model.addAttribute("usuario", new Usuario());
		return "login";
	}

	@RequestMapping("/usuario/logOut")
	public String logOut(Model model) {

		this.user = new Usuario();
		return index();

	}

	@RequestMapping("/usuario/log")
	public String log(Usuario usuario, Model model) {

		if (uService.login(usuario)) {
			this.user = uService.getUserByName(usuario.getUsername());
			return getMain(model);
		} else {
			model.addAttribute("mensaje", "Usuario incorrecto");
			return loginPage(model);
		}
	}

	@RequestMapping("/contenido/addVista")
	public String addVista(Model model) {

		model.addAttribute("genero", gService.getAll());
		model.addAttribute("contenido", new Contenido());

		return "addContenido";
	}

	@RequestMapping("/contenido/editVista/{id}")
	public String editVista(Model model, @PathVariable("id") String id) {

		model.addAttribute("genero", gService.getAll());
		model.addAttribute("contenido", cService.getById(id));

		return "editContenido";
	}

	@RequestMapping("/contenido/delete/{id}")
	public String delete(Model model, @PathVariable("id") String id) {

		cService.delete(id);

		return getMainParametros(model, cService.getAll());
	}

	@RequestMapping("/contenido/edit")
	public String editContenido(Contenido contenido, Model model) {

		cService.save(contenido);

		return getMain(model);
	}

	@RequestMapping("/contenido/add")
	public String addContenido(Contenido contenido, Model model) {

		contenido.setCaratula("https://blocs.xtec.cat/quevolsllegir/files/2016/04/Sense-t%c3%adtol.png");

		cService.save(contenido);

		return getMain(model);
	}

	@RequestMapping("/main")
	public String getMain(Model model) {
		model.addAttribute("genero", gService.getAll());
		model.addAttribute("usuario", this.user);
		model.addAttribute("contenido", cService.getAll());
		model.addAttribute("busqueda", new Contenido());
		return "main";
	}

	public String getMainParametros(Model model, List<Contenido> cont) {
		model.addAttribute("genero", gService.getAll());
		model.addAttribute("usuario", this.user);
		model.addAttribute("contenido", cont);
		model.addAttribute("busqueda", new Contenido());
		return "main";
	}

	@RequestMapping("/contenido/peliculas")
	public String getPeliculas(Model model) {

		return getMainParametros(model, cService.getPeliculas());
	}

	@RequestMapping("/contenido/series")
	public String getSeries(Model model) {

		return getMainParametros(model, cService.getSeries());
	}

	public String getPeliculasBusqueda(Model model, List<Contenido> peliculas) {

		if (peliculas == null) {
			peliculas = cService.getPeliculas();
		}
		return getMainParametros(model, peliculas);
	}

	public String getSeriesBusqueda(Model model, List<Contenido> series) {

		if (series.size() > 1) {
			series = cService.getSeries();
		}

		return getMainParametros(model, series);
	}

	@RequestMapping("/contenido/{id}")
	public String getContenido(@PathVariable("id") String id, Model model) {

		Contenido c = cService.getById(id);

		c.setEnlaces(eService.getEnlacesByIdPelicula(id));
		model.addAttribute("usuario", this.user);
		model.addAttribute("contenido", c);

		return "viewContenido";
	}

	@RequestMapping("/contenido/enlaces/{id}")
	public String getEnlacesPage(@PathVariable("id") String id, Model model) {

		Enlace enlace = new Enlace();

		enlace.setIdPelicula(id);
		model.addAttribute("enlace", enlace);

		return "enlaces";
	}

	@RequestMapping("/contenido/enlaces/add")
	public String addEnlace(Enlace enlace, Model model) {

		eService.save(enlace);

		return getContenido(enlace.getIdPelicula(), model);
	}

	@RequestMapping("/contenido/buscar")
	public String busqueda(Model model, Contenido busqueda) {
		return getMainParametros(model, cService.findByName(busqueda.getName()));
	}

	@RequestMapping("/contenido/buscar/series")
	public String busquedaSeries(Model model, Contenido busqueda) {
		return getSeriesBusqueda(model, cService.findByName(busqueda.getName()).stream().filter(p -> p.isEsSerie())
				.collect(Collectors.toList()));
	}

	@RequestMapping("/contenido/buscar/peliculas")
	public String busquedaPeliculas(Model model, Contenido busqueda) {
		return getPeliculasBusqueda(model, cService.findByName(busqueda.getName()).stream()
				.filter(p -> p.isEsPelicula()).collect(Collectors.toList()));
	}

	@RequestMapping("/contenido/filtrar")
	public String filtrar(Model model, Contenido contenido) {

		return getMainParametros(model, cService.findByQuery(contenido));
	}

	@RequestMapping("/usuario/perfil")
	public String getPerfil(Model model) {

		model.addAttribute("usuario", this.user);

		return "perfil";
	}

	@RequestMapping("/usuario/editarVista")
	public String editarUsuarioVista(Model model) {
		model.addAttribute("usuario", this.user);
		return "editUsuario";
	}

	@RequestMapping("/usuario/editar")
	public String editarUsuario(Model model, Usuario usuario) {
				
		uService.addUsuario(checkUsuario(usuario));
		model.addAttribute("usuario", this.user);

		return "perfil";
	}
	
	
	public Usuario checkUsuario(Usuario usuario) {
		
			if(usuario.getId() == null)
			usuario.setId(this.user.getId());	
				
			if(usuario.getUsername() == null)
			usuario.setUsername(this.user.getUsername());
			
			if(usuario.getEmail() == null)
			usuario.setEmail(this.user.getEmail());
			
			if(usuario.getPassword() == null)
			usuario.setPassword(this.user.getPassword());
			
			if(usuario.getRol() == null)
			usuario.setRol(this.user.getRol());
			
			return usuario;
	}
}
