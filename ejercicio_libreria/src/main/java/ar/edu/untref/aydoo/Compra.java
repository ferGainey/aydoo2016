package ar.edu.untref.aydoo;

public class Compra {

	private Mes mes;
	private Producto producto;
	//private ProductoSuscriptible productoSuscriptible;

	public Compra(Mes mes, Producto producto){
		this.setMes(mes);
		this.producto = producto;
	}
/*
	public Compra(Mes mes, ProductoSuscriptible productoSuscriptible){
		this.setMes(mes);
		this.productoSuscriptible = productoSuscriptible;
	}
*/
	public Mes getMes() {
		return mes;
	}

	private void setMes(Mes mes) {
		this.mes = mes;
	}

	public double getMonto() {
			return this.producto.getPrecio();
	}

	public Producto getProducto(){
			return this.producto;
	}

	/*
	private boolean esProductoSuscriptible(){
		if(productoSuscriptible!=null){
			return true;
		}
		else{
			return false;
		}
	}
	*/
}
