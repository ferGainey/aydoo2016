package ar.edu.untref.aydoo;

public abstract class ProductoSuscribible extends Producto{
	
	private String periodicidad;

	public ProductoSuscribible(double precio) {
		super(precio);
	}

	/*
	 * @post: se le indica la periodicidad que la revista tiene por mes. E
	 */
	public void setPeriodicidad(String periodicidad) {
			this.periodicidad = periodicidad;
	}

	/*
	 * @pre: se le indico una periodicidad al producto
	 * @post: devuelve la periodicidad con la que sale la revista. 
	 */
	public String getPeriodicidad() {
		return this.periodicidad;
	}
}
