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
	
	@Test
	public void ponerLeche(){
		Vaso miVaso = new Vaso();
		Lechero miLechero = new Lechero();
		miLechero.prepararEnEsteVaso(miVaso);
		Assert.assertEquals(1, miVaso.getContenido().size());
		Assert.assertEquals("leche", miVaso.getContenido().get(0));
	}
	
	@Test
	public void ponerNAzucar(){
		Vaso miVaso1 = new Vaso();
		Vaso miVaso2 = new Vaso();
		Azucarero miAzucarero1 = new Azucarero();
		miAzucarero1.ponerNEnEsteVaso(miVaso1, 1);
		Assert.assertEquals(1, miVaso1.getContenido().size());
		Assert.assertEquals("azucar", miVaso1.getContenido().get(0));
		Azucarero miAzucarero2 = new Azucarero();
		miAzucarero2.ponerNEnEsteVaso(miVaso2, 3);
		Assert.assertEquals(3, miVaso2.getContenido().size());
		Assert.assertEquals("azucar", miVaso2.getContenido().get(0));
		Assert.assertEquals("azucar", miVaso2.getContenido().get(1));
		Assert.assertEquals("azucar", miVaso2.getContenido().get(2));
	}
}
