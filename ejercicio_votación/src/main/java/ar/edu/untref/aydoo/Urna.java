package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Urna 
{
	private List<Boleta> votos = new LinkedList<Boleta>();

	public void recibirVoto(Boleta boleta) 
	{
		this.votos.add(boleta);
	}

	public List<Boleta> getVotos()
	{
		return this.votos;
	}
}
