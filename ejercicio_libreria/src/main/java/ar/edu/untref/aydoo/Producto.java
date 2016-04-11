package ar.edu.untref.aydoo;

public abstract class Producto {

	private String nombre;
	private float precio;

	public Producto(String nombre){
		this.setNombre(nombre);
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public void setPrecio(float precio){
		this.precio = precio;
	}
	
	public float getPrecio(){
		return this.precio;
	}
}
