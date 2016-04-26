package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloDeLibreriaTest {
	@Test 
    public void CargandoUnArticuloDeLibreriaYPidiendoPrecioQueInluyeIva() {
		Producto miProducto = new ArticuloDeLibreria(10,"unica");
		Assert.assertEquals(12.1, miProducto.getPrecio(),00.1);
	}
}
