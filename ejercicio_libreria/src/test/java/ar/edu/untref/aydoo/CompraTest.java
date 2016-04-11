package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CompraTest {

	private Compra miCompra;
	private Mes abril;
	private Producto cuaderno;
	
	@Before
	public void inicializar(){
		this.abril = new Mes("Abril");
		this.cuaderno = new ArticuloDeLibreria("Cuaderno");
		this.cuaderno.setPrecio(17.50);
		this.miCompra = new Compra(abril, this.cuaderno);
	}
	
	@Test
	public void obtenerMesDeLaCompra(){
		Assert.assertEquals(abril, this.miCompra.getMes());
	}
	
	@Test
	public void obtenerMontoDeLaCompra(){
		Assert.assertEquals(17.50, this.miCompra.getMonto());
	}
	
	@Test
	public void obtenerProductoDeLaCompra(){
		Assert.assertEquals(this.cuaderno, this.miCompra.getProducto());
	}
}
