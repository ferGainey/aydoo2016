package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class LibroTest {

	@Test
	public void unLibroSeCreaConUnPrecio(){
		Libro harryPotter = new Libro(250);
		Assert.assertEquals(250, harryPotter.getPrecio(), 0.01);
	}

}
