package ar.edu.untref.aydoo;

public class Partido {

	private String nombre;

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
}
