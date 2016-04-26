package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

	@Test
	public void unProductoSeCreaConUnPrecio(){
		Producto miProducto = new Producto(15);
		Assert.assertEquals(15, miProducto.getPrecio(), 0.01);
	}

	@Test
	public void aUnProductoSeLePuedeCambiarElPrecio(){
		Producto miProducto = new Producto(15);
		miProducto.setPrecio(58);
		Assert.assertEquals(58, miProducto.getPrecio(), 0.01);
	}

	@Test (expected = CantidadNegativaException.class)
	public void noSePuedeCrearUnProductoConPrecioNegativo(){
		@SuppressWarnings("unused")
		Producto miProducto = new Producto(-15);
	}

	@Test (expected = CantidadNegativaException.class)
	public void noSePuedeSetearAUnProductoUnPrecioNegativo(){
		Producto miProducto = new Producto(55);
		miProducto.setPrecio(-10);
	}
}
