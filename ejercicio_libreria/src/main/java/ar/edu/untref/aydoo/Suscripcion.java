package ar.edu.untref.aydoo;

public class Suscripcion {

	private ProductoSuscriptible producto;
	private boolean esAnual;
	private Mes mes;

	public Suscripcion(ProductoSuscriptible producto){
		this.producto = producto;
	}

	/*
	 * @post: indica para que producto es la suscripcion
	 */
	public ProductoSuscriptible getProducto(){
		return this.producto;
	}

	public void setEsAnual(boolean esAnual) {
		this.esAnual = esAnual;
	}
	
	public boolean getEsAnual(){
		return this.esAnual;
	}

	public Mes getMes() {
		return this.mes;
	}
	
	public void setMes(Mes mes){
		this.mes = mes;
	}
}
