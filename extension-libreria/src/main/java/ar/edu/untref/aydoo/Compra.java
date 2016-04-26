package ar.edu.untref.aydoo;

public class Compra {

	private Cliente miCliente;
	private Producto nuevoProducto;
	private int cantidad;
	private String mes;

	/*
	 * @pre: la cantidad no puede ser negativa
	 */
	public Compra(Cliente unCliente, Producto unProducto,int cantidad, String mes){
		if(cantidad < 0){
			throw new CantidadNegativaException("La cantidad no puede ser negativa");
		}
		else{
			this.setMiCliente(unCliente);
			this.setNuevoProducto(unProducto);
			this.setCantidad(cantidad);
			this.setMes(mes);
		}
	}

	public String getMes() {
		return mes;
	}

	private void setMes(String mes) {
		this.mes = mes;
	}

	public int getCantidad() {
		return cantidad;
	}

	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getNuevoProducto() {
		return nuevoProducto;
	}

	private void setNuevoProducto(Producto nuevoProducto) {
		this.nuevoProducto = nuevoProducto;
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	private void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}

}
