package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CompraTest {

	private Compra miCompra;
	private Mes abril;
	
	@Before
	public void inicializar(){
		this.abril = new Mes("Abril");
		this.miCompra = new Compra(abril, 205);
	}
	
	@Test
	public void obtenerMesDeLaCompra(){
		Assert.assertEquals(abril, this.miCompra.getMes());
	}
}
