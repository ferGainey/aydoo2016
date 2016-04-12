package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	public ArticuloDeLibreria(String nombre) {
		super(nombre);
	}

	/*
	 * @pre: el producto ya tiene un precio establecido
	 * @post: devuelve el precio con IVA
	 */
	@Override
	public double getPrecio(){
		return (this.precio) * 1.21;
	}

}
