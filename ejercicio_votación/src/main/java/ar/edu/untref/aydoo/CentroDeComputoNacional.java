package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CentroDeComputoNacional {

	private List<Urna> urnasDeLaNacion = new LinkedList<Urna>();
	private List<CentroDeComputoProvincial> centrosDeComputoProvinciales = new LinkedList<CentroDeComputoProvincial>();
	
	public void agregarUrna(Urna urna)
	{
		this.urnasDeLaNacion.add(urna);
	}
	
	public List<Urna> getUrnasDeLaNacion()
	{
		return this.urnasDeLaNacion;
	}
	
	public void agregarCentroDeComputoProvincial(CentroDeComputoProvincial centroDeComputoProvinvial)
	{
		this.centrosDeComputoProvinciales.add(centroDeComputoProvinvial);
	}
	
	public List<CentroDeComputoProvincial> getCentrosDeComputoProvinciales()
	{
		return this.centrosDeComputoProvinciales;
	}
	
	public Candidato getGanador()
	{
		HashMap<Candidato, Integer> votacion = new HashMap<Candidato, Integer>();
		Iterator<CentroDeComputoProvincial> iterator = this.getCentrosDeComputoProvinciales().iterator();
		while(iterator.hasNext())
		{
			CentroDeComputoProvincial centroActual = iterator.next();
			for(int i=0; i<centroActual.getUrnasDeLaProvincia().size();i++)
			{
				Urna urnaActual = centroActual.getUrnasDeLaProvincia().get(i);
				for(int j=0;j<urnaActual.getVotos().size();j++)
				{
					Boleta boletaActual = urnaActual.getVotos().get(j);
					if(votacion.containsKey(boletaActual.getCandidato()))
					{
						Integer cantDeVotos = votacion.get(boletaActual.getCandidato());
						cantDeVotos++;
					}
					else{
						votacion.put(boletaActual.getCandidato(), 0);
					}
				}
			}
		}
		Candidato ganador = null;
		for (Candidato key : votacion.keySet()) {
		    if(ganador==null)
		    	{
		    		ganador=key;
		    	} else{
		    		if(votacion.get(key)>votacion.get(ganador))
		    		{
		    			ganador=key;
		    		}
		    	}
			}
		return ganador;
	}
}
