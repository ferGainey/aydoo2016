package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicoTest {

	@Test
	public void unPeriodicoSeCreaConUnPrecio(){
		ProductoSuscribible laNacion = new Periodico(25);
		Assert.assertEquals(25, laNacion.getPrecio(), 0.1);
	}

	@Test
	public void aUnPeriodicoSeLePoneUnaPeriodicidad(){
		ProductoSuscribible laNacion = new Periodico(22);
		laNacion.setPeriodicidad("diario");
		Assert.assertEquals("diario", laNacion.getPeriodicidad());
	}

}
