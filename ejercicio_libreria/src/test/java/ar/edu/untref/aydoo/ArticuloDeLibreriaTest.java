package ar.edu.untref.aydoo;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")

public class ArticuloDeLibreriaTest {

	@Test
	public void ponerNombreAlArticuloDeLibreria(){
		ArticuloDeLibreria miArticuloDeLibreria = new ArticuloDeLibreria("Plasticola");
		Assert.assertEquals("Plasticola", miArticuloDeLibreria.getNombre());
	}
	
	@Test
	public void ponerPrecioAlArticuloDeLibreria(){
		ArticuloDeLibreria miArticuloDeLibreria = new ArticuloDeLibreria("Plasticola");
		miArticuloDeLibreria.setPrecio(12.00);
		Assert.assertEquals(12.00, miArticuloDeLibreria.getPrecio());
	}
}
