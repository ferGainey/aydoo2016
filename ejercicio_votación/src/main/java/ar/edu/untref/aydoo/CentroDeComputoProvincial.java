package ar.edu.untref.aydoo;

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
		Iterator<Urna> iterator = this.urnasDeLaProvincia.iterator();
		while(iterator.hasNext())
		{
			Urna urnaActual = iterator.next();
			for(int i=0; i<urnaActual.getVotos().size();i++)
			{
				Boleta boletaActual=urnaActual.getVotos().get(i);
				
			}
			
		}
		return null;
	}
}
