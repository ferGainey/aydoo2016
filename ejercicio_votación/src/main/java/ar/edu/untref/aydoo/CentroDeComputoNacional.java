package ar.edu.untref.aydoo;

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
}
