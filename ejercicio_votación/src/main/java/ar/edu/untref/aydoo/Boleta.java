package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Boleta 
{

	private JuntaElectoral juntaElectoral;
	private Candidato miCandidato;
	
	public Boleta(JuntaElectoral juntaElectoralActual)
	{
		this.juntaElectoral = juntaElectoralActual;
	}

	public void setCandidato(Candidato candidato) 
	{
		this.miCandidato = candidato;
	}

	public Candidato getCandidato() 
	{
		return this.miCandidato;
	}
	
}
