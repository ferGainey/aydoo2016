package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CentroDeComputoProvincial {

	private List<Urna> urnasDeLaProvincia = new LinkedList<Urna>();
	
	public CentroDeComputoProvincial(CentroDeComputoNacional centroDeComputoNacional)
	{
		centroDeComputoNacional.agregarCentroDeComputoProvincial(this);
	}
	
	public void agregarUrna(Urna urna)
	{
		this.urnasDeLaProvincia.add(urna);
	}
	
	public List<Urna> getUrnasDeLaProvincia()
	{
		return this.urnasDeLaProvincia;
	}
	
	public Partido getPartidoGanador()
	{
		HashMap<Partido, Integer> votacion = new HashMap<Partido, Integer>();
		Iterator<Urna> iterator = this.urnasDeLaProvincia.iterator();
		while(iterator.hasNext())
		{
			Urna urnaActual = iterator.next();
			for(int i=0; i<urnaActual.getVotos().size();i++)
			{
				Boleta boletaActual=urnaActual.getVotos().get(i);
				if(votacion.containsKey(boletaActual.getCandidato().getPartido()))
				{
					Integer cantDeVotos = votacion.get(boletaActual.getCandidato().getPartido());
					cantDeVotos++;
					votacion.put(boletaActual.getCandidato().getPartido(), cantDeVotos);
				}
				else{
					votacion.put(boletaActual.getCandidato().getPartido(), 0);
				}
			}
		}
	
		Partido ganador = null;
		for (Partido key : votacion.keySet()) {
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
