package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class JuntaElectoral 
{
	private List<Candidato> candidatosAprobados = new LinkedList<Candidato>();	
	
	public void agregarCandidatoAprobado(Candidato candidato) 
	{
		this.candidatosAprobados.add(candidato);
	}
	
	public void eliminarCandidatoAprobado(Candidato candidato)
	{
		this.candidatosAprobados.remove(candidato);
	}
	
	//votoEnBlanco si se agrega va a ser un candidato que represente el voto en blanco
	public List<Candidato> getCandidatosAprobados()
	{
		return this.candidatosAprobados;
	}
}
