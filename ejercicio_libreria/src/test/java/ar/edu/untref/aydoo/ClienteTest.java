package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ClienteTest {

	Cliente miCliente;
	
	@Before
	public void inicializar(){
		this.miCliente = new Cliente("Pablo", "Calle Falsa 123, Springfield");
	}
	
	@Test
	public void unClienteSeCreaConUnNombre(){
		Assert.assertEquals("Pablo", this.miCliente.getNombre());
	}
}
