package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	public ArticuloDeLibreria(String nombre) {
		super(nombre);
	}
	
	/*
	 * @pre: el producto ya tiene un precio establecido
	 */
	public double getPrecioConIva(){
		return (this.getPrecio()+(this.getPrecio()*0.21));
	}

}
