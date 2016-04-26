package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class RevistaTest {

	@Test
	public void unaRevistaSeCreaConUnPrecio(){
		ProductoSuscribible elGrafico = new Revista(45);
		Assert.assertEquals(45, elGrafico.getPrecio(), 0.1);
	}

	@Test
	public void aUnaRevistaSeLePoneUnaPeriodicidad(){
		ProductoSuscribible elGrafico = new Revista(45);
		elGrafico.setPeriodicidad("quincenal");
		Assert.assertEquals("quincenal", elGrafico.getPeriodicidad());
	}

}
