package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ClienteTest {
	
	Cliente fernando;
	
	@Before
	public void inicializar(){
		this.fernando = new Cliente("Fernando");
	}
	
	@Test
	public void elClienteSeCreaConUnNombre(){
		Assert.assertEquals("Fernando", this.fernando.getNombreCliente());
	}

	@Test
	public void alClienteSeLePuedeAgregarUnaDireccion(){
		this.fernando.setDireccion("9 de Julio 3500");
		Assert.assertEquals("9 de Julio 3500", this.fernando.getDireccion());
	}
}
