package ar.edu.untref.aydoo;

public abstract class Producto {

	private String nombre;
	private double precio;

	public Producto(String nombre){
		this.setNombre(nombre);
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public double getPrecio(){
		return this.precio;
	}
}
