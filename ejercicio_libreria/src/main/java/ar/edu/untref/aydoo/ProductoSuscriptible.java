package ar.edu.untref.aydoo;

public abstract class ProductoSuscriptible extends Producto {

	private int periodicidad;

	public ProductoSuscriptible(String nombre) {
		super(nombre);
	}

	/*
	 * @post: se le indica la periodicidad que la revista tiene por mes. El numero indica
	 * la cantidad de veces que sale la revista en un mes.
	 */
	public void setPeriodicidad(int periodicidad) {
		if(periodicidad<=30 && periodicidad>=0){
			this.periodicidad = periodicidad;
		}
		else{
			throw new IllegalArgumentException("La periodicidad no puede ser menor a 0 o mayor a 30");
		}
	}

	/*
	 * @pre: se le indico una periodicidad al producto
	 * @post: devuelve la periodicidad con la que sale la revista. El numero indica la 
	 * cantidad de veces que sale la revista en un mes
	 */
	public int getPeriodicidad() {
		return this.periodicidad;
	}

}
