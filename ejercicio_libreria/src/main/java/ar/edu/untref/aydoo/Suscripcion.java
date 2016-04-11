package ar.edu.untref.aydoo;

public class Suscripcion {

	private ProductoSuscriptible producto;

	public Suscripcion(ProductoSuscriptible producto){
		this.producto = producto;
	}

	/*
	 * @post: indica para que producto es la suscripcion
	 */
	public ProductoSuscriptible getProducto(){
		return this.producto;
	}
}
