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
}
