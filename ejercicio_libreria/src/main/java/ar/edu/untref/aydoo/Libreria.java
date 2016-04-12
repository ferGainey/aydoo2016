package ar.edu.untref.aydoo;

import java.util.Iterator;

public class Libreria {

	private static Libreria instance;

	private Libreria(){
	}

	public static Libreria getInstance(){
		if(instance == null){
			instance = new Libreria();
		}
		return instance;
	}

	public double calcularMontoACobrar(Mes mes, Cliente cliente) {
		double monto=0.0;
		Iterator<Compra> iterator = cliente.getRegistroDeCompras().iterator();
		while(iterator.hasNext()){
			Compra compraActual = iterator.next();
			if(compraActual.getMes()==mes){
				monto=monto+compraActual.getMonto();
			}
		}
		Iterator<Suscripcion> iteratorSuscripcion = cliente.getRegistroDeSuscripciones().iterator();
		while(iteratorSuscripcion.hasNext()){
			Suscripcion suscripcionActual = iteratorSuscripcion.next();
			if(suscripcionActual.getEsAnual()==false){
				monto = monto + ((suscripcionActual.getProducto().getPrecio()) * suscripcionActual.getProducto().getPeriodicidad());
			}
			else{
				monto = monto + (((suscripcionActual.getProducto().getPrecio()) * suscripcionActual.getProducto().getPeriodicidad()) * 0.80);
			}
		}
		return monto;
	}

	public String getDireccionDeUnCliente(Cliente cliente){
		return cliente.getDireccion();
	}

	public String getNombreDeUnCliente(Cliente cliente){
		return cliente.getNombre();
	}
}
