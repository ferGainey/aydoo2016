package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {

	private String nombre;
	private List<Candidato> candidatos = new LinkedList<Candidato>();

	//el partido enBlanco con nombre "Voto en blanco" es el que se recomienda poner
	//para representar al voto en blanco
	public Partido(String nombre)
	{
		this.setNombre(nombre);
	}

	private void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public List<Candidato> getCandidatos() 
	{
		return this.candidatos;
	}
	
	public void agregarCandidato(Candidato candidato)
	{
		this.candidatos.add(candidato);
	}
}
