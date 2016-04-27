package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Libreria {

	List<Cliente> listaDeClientes = new LinkedList<Cliente>();
	List<Compra> listaDeCompras = new LinkedList<Compra>();
	List<Suscripcion> listaDeSuscripciones = new LinkedList<Suscripcion>();
	List<AlquilerDeLibro> listaDeAlquilerDeLibros = new LinkedList<AlquilerDeLibro>();

	public void addCliente(Cliente nuevoCliente) {
		listaDeClientes.add(nuevoCliente);
	}

	public void nuevaCompra(Compra compra) {
		listaDeCompras.add(compra);
	}

	public void nuevoAlquilerDeLibro(AlquilerDeLibro alquiler){
		listaDeAlquilerDeLibros.add(alquiler);
	}

	public double calcularMontoACobrar(String mes, Cliente miCliente) {
		double montoACobrar = 0;
		double montoDescuento = 0;
		montoACobrar = recorrerCompras(mes, miCliente, montoACobrar);
		//empieza a recorrer las Suscripciones (la logica del codigo original no me permitio extraer el metodo para simplificar la visual)
		Iterator<Suscripcion> itSuscripciones = listaDeSuscripciones.iterator();
		while(itSuscripciones.hasNext()){
			Suscripcion suscripcionARegistrar = itSuscripciones.next();
			if (suscripcionARegistrar.getMes() == mes && suscripcionARegistrar.getMiCliente() == miCliente){
				if (suscripcionARegistrar.getTiempoDeSuscripcion() == "anual"){
					montoDescuento = (suscripcionARegistrar.getNuevoProducto().getPrecio() * suscripcionARegistrar.getCantidadDeEjemplaresPorMes())*0.2;
				}
				montoACobrar += suscripcionARegistrar.getNuevoProducto().getPrecio() * suscripcionARegistrar.getCantidadDeEjemplaresPorMes();
			}
		}
		//termina de recorrer las suscripciones
		montoACobrar = recorrerAlquileres(mes, miCliente, montoACobrar);
		return montoACobrar - montoDescuento;
	}

	private double recorrerAlquileres(String mes, Cliente miCliente, double montoACobrar) {
		Iterator<AlquilerDeLibro> alquilerIterator = this.listaDeAlquilerDeLibros.iterator();
		while(alquilerIterator.hasNext()){
			AlquilerDeLibro alquilerARegistrar = alquilerIterator.next();
			if(alquilerARegistrar.getCliente() == miCliente){
				Iterator<String> keySetIterator = alquilerARegistrar.getDineroAPagarEnDeterminadoMes().keySet().iterator();
				while(keySetIterator.hasNext()){
					String mesActual = keySetIterator.next();
					if(mesActual.equals(mes)){
						montoACobrar += alquilerARegistrar.getDineroAPagarEnDeterminadoMes().get(mesActual);
					}
				}

			}
		}
		return montoACobrar;
	}

	private double recorrerCompras(String mes, Cliente miCliente, double montoACobrar) {
		Iterator<Compra> it = listaDeCompras.iterator();
		while(it.hasNext()){
			Compra compraARegistrar = it.next();
			if (compraARegistrar.getMes() == mes && compraARegistrar.getMiCliente() == miCliente){
				montoACobrar += compraARegistrar.getNuevoProducto().getPrecio() * compraARegistrar.getCantidad();
			}
		}
		return montoACobrar;
	}

	public void nuevaSuscripcion(Suscripcion nuevaSuscripcion) {
		listaDeSuscripciones.add(nuevaSuscripcion);
	}

}
