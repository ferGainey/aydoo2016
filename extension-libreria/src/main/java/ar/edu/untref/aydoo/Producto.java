package ar.edu.untref.aydoo;

public class Producto {

	private double precioDeVenta;

	public Producto(double precio){
		this.precioDeVenta = precio;
	}

	public double getPrecio() {
		return precioDeVenta;
	}

	public void setPrecio(double precio) {
		this.precioDeVenta = precio;
	}

}
