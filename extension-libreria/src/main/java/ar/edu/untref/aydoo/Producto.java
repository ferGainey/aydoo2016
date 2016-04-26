package ar.edu.untref.aydoo;

public class Producto {
	private double precioDeVenta;
	private String periodicidad;
	public Producto(double precio, String nuevaPeriodicidad){
		this.precioDeVenta = precio;
		this.periodicidad = nuevaPeriodicidad;
	}
	public double getPrecio() {
		return precioDeVenta;
	}
	public void setPrecio(double precio) {
		this.precioDeVenta = precio;
	}
	public String getPeriodicidad(){
		return this.periodicidad;
	}
}
