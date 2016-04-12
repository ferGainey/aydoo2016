package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PeriodicoTest {

	private Periodico miPeriodico;

	@Before
	public void inicializar(){
		this.miPeriodico = new Periodico("La Nacion");
		this.miPeriodico.setPrecio(9.80);
	}

	@Test
	public void ponerNombreaALPeriodico(){
		Assert.assertEquals("La Nacion", this.miPeriodico.getNombre());
	}

	@Test
	public void ponerPrecioALPeriodico(){
		Assert.assertEquals(9.80, this.miPeriodico.getPrecio());
	}

	@Test(expected = Exception.class)
	public void ponerPrecioNegativoAlPeriodico(){
		this.miPeriodico.setPrecio(-5.0);
	}

	@Test
	public void ponerPeriodicidadAlPeriodico(){
		this.miPeriodico.setPeriodicidad(30);
		Assert.assertEquals(30, this.miPeriodico.getPeriodicidad());
	}

	@Test(expected = Exception.class)  
	public void ponerPrecioNegativoAlPeriodicoLanzaException(){
		this.miPeriodico.setPrecio(-1.5);
	}

	@Test(expected = Exception.class)
	public void ponerPeriodicidadNegativaAlPeriodico(){
		this.miPeriodico.setPeriodicidad(-5);
	}

	@Test(expected = Exception.class)
	public void ponerPeriodicidadMayorATreintaAlPeriodico(){
		this.miPeriodico.setPeriodicidad(50);
	}
}


