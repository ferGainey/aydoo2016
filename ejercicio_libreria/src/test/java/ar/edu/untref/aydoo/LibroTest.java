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
}
