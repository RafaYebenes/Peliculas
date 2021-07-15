package com.example.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Contenido {
	
	@Id
	private String id;
	private String name;
	private String fechaEstreno;
	private Date fechaSubida;
	private double puntuacion;
	private String caratula;
	private String descripcion;
	private boolean esPelicula;
	private boolean esSerie;
	private String genero;
	
	private List<Enlace> enlaces;

	public Contenido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contenido(String name, String fechaEstreno, Date fechaSubida, double puntuacion, String caratula,
			String descripcion, boolean esPelicula, boolean esSerie, String genero) {
		super();
		this.name = name;
		this.fechaEstreno = fechaEstreno;
		this.fechaSubida = fechaSubida;
		this.puntuacion = puntuacion;
		this.caratula = caratula;
		this.descripcion = descripcion;
		this.esPelicula = esPelicula;
		this.esSerie = esSerie;
		this.genero = genero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Date getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEsPelicula() {
		return esPelicula;
	}

	public void setEsPelicula(boolean esPelicula) {
		this.esPelicula = esPelicula;
	}

	public boolean isEsSerie() {
		return esSerie;
	}

	public void setEsSerie(boolean esSerie) {
		this.esSerie = esSerie;
	}

	public List<Enlace> getEnlaces() {
		return enlaces;
	}

	public void setEnlaces(List<Enlace> enlaces) {
		this.enlaces = enlaces;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
}
