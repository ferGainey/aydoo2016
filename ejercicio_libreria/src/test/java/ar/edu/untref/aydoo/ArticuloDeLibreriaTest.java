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
	
	@Test(expected = Exception.class)  
	public void ponerPrecioNegativoAlArticuloDeLibreriaLanzaException(){
		ArticuloDeLibreria miArticuloDeLibreria = new ArticuloDeLibreria("Plasticola");
		miArticuloDeLibreria.setPrecio(-10.00);
	}
	
	@Test
	public void seCalculaElPrecioConIvaDelProducto(){
		ArticuloDeLibreria miArticuloDeLibreria = new ArticuloDeLibreria("Plasticola");
		miArticuloDeLibreria.setPrecio(5.00);
		double valorEsperado = 5.0 + (5.0 * 0.21);
		Assert.assertEquals(valorEsperado, miArticuloDeLibreria.getPrecioConIva());
	}
}
