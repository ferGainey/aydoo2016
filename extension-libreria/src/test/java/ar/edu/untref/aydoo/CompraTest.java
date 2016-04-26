package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class CompraTest {

	@Test
	public void unaCompraSeCreaConUnMes(){
		Cliente mariano = new Cliente("Mariano");
		Producto lapiz = new ArticuloDeLibreria(15.0);
		Compra miCompra = new Compra(mariano,lapiz, 1, "abril");
		Assert.assertEquals(miCompra.getMes(), "abril");
	}

	@Test
	public void unaCompraSeCreaConUnaCantidad(){
		Cliente mariano = new Cliente("Mariano");
		Producto lapiz = new ArticuloDeLibreria(15.0);
		Compra miCompra = new Compra(mariano,lapiz, 3, "abril");
		Assert.assertEquals(miCompra.getCantidad(), 3);
	}

	@Test (expected = CantidadNegativaException.class)
	public void noSePuedeIngresarUnaCantidadNegativaDeProductos(){
		Cliente mariano = new Cliente("Mariano");
		Producto lapiz = new ArticuloDeLibreria(15.0);
		@SuppressWarnings("unused")
		Compra miCompra = new Compra(mariano,lapiz, -5, "abril");
	}

	@Test
	public void puedoObtenerQueProductoEstaEnLaCompra(){
		Cliente mariano = new Cliente("Mariano");
		Producto lapiz = new ArticuloDeLibreria(15.0);
		Compra miCompra = new Compra(mariano,lapiz, 2, "abril");
		Assert.assertEquals(miCompra.getNuevoProducto(), lapiz);
	}
}
