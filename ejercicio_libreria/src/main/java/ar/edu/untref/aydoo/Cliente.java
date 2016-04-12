package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

	private String nombre;
	private String direccion;
	private List<Suscripcion> suscripciones = new LinkedList<Suscripcion>();
	private List<Compra> registroDeCompras = new LinkedList<Compra>();

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
		if(suscripcion.getEsAnual() == false && suscripcion.getMes() == null){
			suscripcion.setMes(mes);
			this.suscripciones.add(suscripcion);
		}
		else{
			System.out.println("Esa suscripcion ya esta siendo usada");
		}
	}

	public void suscribirseAnualmente(Suscripcion suscripcion) {
		suscripcion.setEsAnual(true);
		this.suscripciones.add(suscripcion);
	}

	public void efectuarCompra(Compra compra) {
		this.registroDeCompras.add(compra);
	}

	public List<Compra> getRegistroDeCompras(){
		return this.registroDeCompras;
	}

	public List<Suscripcion> getRegistroDeSuscripciones(){
		return this.suscripciones;
	}
}
