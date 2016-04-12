package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class RevistaTest {

	private Revista miRevista;

	@Before
	public void inicializar(){
		this.miRevista = new Revista("Viajes");
		this.miRevista.setPrecio(15.99);
	}

	@Test
	public void ponerNombreaALaRevista(){
		Assert.assertEquals("Viajes", this.miRevista.getNombre());
	}

	@Test
	public void ponerPrecioALaRevista(){
		Assert.assertEquals(15.99, this.miRevista.getPrecio());
	}

	@Test
	public void ponerPeriodicidadALaRevista(){
		this.miRevista.setPeriodicidad(5);
		Assert.assertEquals(5, this.miRevista.getPeriodicidad());
	}

	@Test(expected = Exception.class)  
	public void ponerPrecioNegativoALaRevistaLanzaException(){
		this.miRevista.setPrecio(-999.99);
	}

	@Test(expected = Exception.class)
	public void ponerPeriodicidadNegativaALaRevista(){
		this.miRevista.setPeriodicidad(-5);
	}

	@Test(expected = Exception.class)
	public void ponerPeriodicidadMayorATreintaALaRevista(){
		this.miRevista.setPeriodicidad(50);
	}
}
