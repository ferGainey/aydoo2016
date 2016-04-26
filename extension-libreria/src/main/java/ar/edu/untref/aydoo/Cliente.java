package ar.edu.untref.aydoo;

public class Cliente {

	private String nombreCliente;
	private String direccion;
	public Cliente(String nombre) {
		this.nombreCliente = nombre;
	}
	public String getNombreCliente(){
		return nombreCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
