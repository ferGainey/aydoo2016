package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CompraTest {

	private Compra miCompraDeArticuloDeLibreria;
	private Compra miCompraDeLibro;
	private Compra miCompraDeProductoSuscriptible;
	private ProductoSuscriptible turismo;
	private Mes abril;
	private Producto cuaderno;
	private Producto harryPotter;

	@Before
	public void inicializar(){
		this.abril = new Mes("Abril");
		this.cuaderno = new ArticuloDeLibreria("Cuaderno");
		this.cuaderno.setPrecio(17.50);
		this.harryPotter = new Libro("Harry Potter");
		this.harryPotter.setPrecio(100.0);
		this.turismo = new Revista("Turismo");
		this.turismo.setPrecio(15.55);
		this.miCompraDeArticuloDeLibreria = new Compra(abril, this.cuaderno);
		this.miCompraDeLibro = new Compra(abril, this.harryPotter);
		this.miCompraDeProductoSuscriptible = new Compra(abril, this.turismo);
	}

	@Test
	public void obtenerMesDeLaCompra(){
		Assert.assertEquals(abril, this.miCompraDeArticuloDeLibreria.getMes());
	}

	//se le aplica IVA
	@Test
	public void obtenerMontoDeLaCompraDeProductoDeLibreria(){
		Assert.assertEquals(21.175, this.miCompraDeArticuloDeLibreria.getMonto());
	}

	@Test
	public void obtenerProductoDeLaCompra(){
		Assert.assertEquals(this.cuaderno, this.miCompraDeArticuloDeLibreria.getProducto());
	}

	@Test
	public void obtenerMontoDeLaCompraDeUnLibro(){
		Assert.assertEquals(100.0, this.miCompraDeLibro.getMonto());
	}

	@Test
	public void obtenerMontoDeUnProductoSuscriptible(){
		Assert.assertEquals(15.55, this.miCompraDeProductoSuscriptible.getMonto());
	}

}
