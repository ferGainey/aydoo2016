package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SuscripcionTest {

	Suscripcion suscripcionAElGrafico;
	ProductoSuscriptible elGrafico = new Revista("El Grafico");

	@Before
	public void inicializar(){
		this.suscripcionAElGrafico = new Suscripcion(this.elGrafico);
	}

	@Test
	public void ponerRevistaDeLaSuscripcion(){
		Assert.assertEquals(this.elGrafico, this.suscripcionAElGrafico.getProducto());
	}

	@Test
	public void ponerLaSuscripcionParaQueSeaAnual(){
		this.suscripcionAElGrafico.setEsAnual(true);
		Assert.assertEquals(true, this.suscripcionAElGrafico.getEsAnual());
		Assert.assertEquals(null, this.suscripcionAElGrafico.getMes());
	}

	@Test
	public void ponerLaSuscripcionParaUnDeterminadoTest(){
		Mes marzo = new Mes("Marzo");
		this.suscripcionAElGrafico.setMes(marzo);
		Assert.assertEquals(false, this.suscripcionAElGrafico.getEsAnual());
		Assert.assertEquals(marzo, this.suscripcionAElGrafico.getMes());
	}
}
