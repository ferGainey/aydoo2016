package ar.edu.untref.aydoo;

public class Producto {

	private double precioDeVenta;

	/*
	 * @pre: el precio no puede ser negativo
	 */
	public Producto(double precio){
		if(precio < 0){
			throw new CantidadNegativaException("El precio no puede ser negativo");
		}
		else{
			this.precioDeVenta = precio;
		}
	}

	public double getPrecio() {
		return precioDeVenta;
	}

	/*
	 * @pre: el precio no puede ser negativo
	 */
	public void setPrecio(double precio) {
		if(precio < 0){
			throw new CantidadNegativaException("El precio no puede ser negativo");
		}
		else{
			this.precioDeVenta = precio;
		}
	}

}
