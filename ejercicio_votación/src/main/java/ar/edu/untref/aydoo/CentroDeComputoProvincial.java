package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class CentroDeComputoProvincial {

	private List<Urna> urnasDeLaProvincia = new LinkedList<Urna>();
	
	public void agregarUrna(Urna urna)
	{
		this.urnasDeLaProvincia.add(urna);
	}
	
	public List<Urna> getUrnasDeLaProvincia()
	{
		return this.urnasDeLaProvincia;
	}
}
