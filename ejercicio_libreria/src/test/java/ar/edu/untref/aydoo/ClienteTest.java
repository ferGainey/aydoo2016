package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ClienteTest {

	Cliente miCliente;
	Suscripcion suscripcionARevistaViva;
	ProductoSuscriptible revistaViva;

	@Before
	public void inicializar(){
		this.miCliente = new Cliente("Pablo", "Calle Falsa 123, Springfield");
		this.revistaViva = new Revista("VIVA");
		this.suscripcionARevistaViva = new Suscripcion(this.revistaViva);
	}

	@Test
	public void unClienteSeCreaConUnNombre(){
		Assert.assertEquals("Pablo", this.miCliente.getNombre());
	}

	@Test
	public void unClienteSeCreaConUnaDireccion(){
		Assert.assertEquals("Calle Falsa 123, Springfield", this.miCliente.getDireccion());
	}
	
	@Test
	public void unClienteSeSuscribeParaUnDeterminadoMes(){
		Mes octubre = new Mes("Octubre");
		this.miCliente.suscribirseEnUnMes(octubre, this.suscripcionARevistaViva);
		Assert.assertEquals(true, this.miCliente.suscripciones.contains(this.suscripcionARevistaViva));
		Assert.assertEquals(octubre, this.suscripcionARevistaViva.getMes());
	}
	
	@Test
	public void unClienteSeHaceUnaSuscripcionAnual(){
		this.miCliente.suscribirseAnualmente(this.suscripcionARevistaViva);
		Assert.assertEquals(true, this.miCliente.suscripciones.contains(this.suscripcionARevistaViva));
		Assert.assertEquals(true, this.suscripcionARevistaViva.getEsAnual());
	}
}
