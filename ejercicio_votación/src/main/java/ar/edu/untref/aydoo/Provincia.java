package ar.edu.untref.aydoo;

public class Provincia {

	private String nombre;
	private CentroDeComputoProvincial centroDeComputoProvincial;
	
	public Provincia(String nombre)
	{
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCentroDeComputo(CentroDeComputoProvincial centroDeComputo)
	{
		this.centroDeComputoProvincial = centroDeComputo;
	}
	
	public CentroDeComputoProvincial getCentroDeComputoProvincial()
	{
		return this.centroDeComputoProvincial;
	}
}
