package ar.edu.untref.aydoo;


public abstract class Producto {

	private String nombre;
	protected double precio;

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
		if(precio>=0){
			this.precio = precio;
		}
		else{
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
	}


	public double getPrecio(){
		return this.precio;
	}
}
