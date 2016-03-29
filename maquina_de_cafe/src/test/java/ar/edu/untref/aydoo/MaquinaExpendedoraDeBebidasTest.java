package ar.edu.untref.aydoo;

import org.junit.Test;

import junit.framework.Assert;

public class MaquinaExpendedoraDeBebidasTest {

	@Test
	public void ponerCafe(){
		Vaso miVaso = new Vaso();
		Cafetero miCafetero = new Cafetero();
		miCafetero.prepararEnEsteVaso(miVaso);
		Assert.assertEquals(1, miVaso.getContenido().size());
		Assert.assertEquals("cafe", miVaso.getContenido().get(0));
		
	}
}
