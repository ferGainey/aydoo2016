package ar.edu.untref.aydoo;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LibroTest {

	@Test
	public void ponerNombreAlLibro(){
		Libro miLibro = new Libro("El arte de la guerra");
		Assert.assertEquals("El arte de la guerra", miLibro.getNombre());
	}

	@Test
	public void ponerPrecioAlLibro(){
		Libro miLibro = new Libro("El arte de la guerra");
		miLibro.setPrecio(25.55);
		Assert.assertEquals(25.55, miLibro.getPrecio());
	}

	@Test(expected = Exception.class)  
	public void ponerPrecioNegativoAlLibroLanzaException(){
		Libro miLibro = new Libro("El arte de la guerra");
		miLibro.setPrecio(-25.55);
	}
}
