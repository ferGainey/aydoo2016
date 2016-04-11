package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

	private String nombre;
	private String direccion;
	List<Suscripcion> suscripciones = new LinkedList<Suscripcion>();
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void suscribirseEnUnMes(Mes mes, Suscripcion suscripcion) {
		suscripcion.setMes(mes);
		this.suscripciones.add(suscripcion);
	}

	public void suscribirseAnualmente(Suscripcion suscripcion) {
		suscripcion.setEsAnual(true);
		this.suscripciones.add(suscripcion);
	}

	public void comprar(Producto producto) {
		
	}

}
