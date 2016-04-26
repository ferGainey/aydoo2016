package ar.edu.untref.aydoo;

public class Suscripcion {
	private Cliente miCliente;
	private Producto nuevoProducto;
	private String periodicidad; 
	private String mes;
	private String tiempoDeSuscripcion;
	
	public Suscripcion(Cliente nuevoCliente, Producto nuevoProducto, String mes){
		this.setMiCliente(nuevoCliente);
		this.setNuevoProducto(nuevoProducto);
		this.setPeriodicidad(nuevoProducto.getPeriodicidad());
		this.setMes(mes);
	}
	public Suscripcion(Cliente nuevoCliente, Producto nuevoProducto, String mes, String tiempoDeSuscripcion){
		this.setMiCliente(nuevoCliente);
		this.setNuevoProducto(nuevoProducto);
		this.setPeriodicidad(nuevoProducto.getPeriodicidad());
		this.setMes(mes);
		this.setTiempoDeSuscripcion(tiempoDeSuscripcion);
	}
	public Cliente getMiCliente() {
		return miCliente;
	}
	private void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}
	public Producto getNuevoProducto() {
		return nuevoProducto;
	}
	private void setNuevoProducto(Producto nuevoProducto) {
		this.nuevoProducto = nuevoProducto;
	}
	private void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public String getMes() {
		return mes;
	}
	private void setMes(String mes) {
		this.mes = mes;
	}
	public int getCantidadDeEjemplaresPorMes() {
		int cantidadDeEjemplares = 0;
		switch (this.periodicidad){
			case "diaria":
				cantidadDeEjemplares = 30;
				break;
			case "quincenal":
				cantidadDeEjemplares = 2;
				break;
			case "mensual":
				cantidadDeEjemplares = 1;
				break;
		}
		return cantidadDeEjemplares;
	}
	public String getTiempoDeSuscripcion() {
		return tiempoDeSuscripcion;
	}
	private void setTiempoDeSuscripcion(String tiempoDeSuscripcion) {
		this.tiempoDeSuscripcion = tiempoDeSuscripcion;
	}
}
