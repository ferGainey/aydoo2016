package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class RevistaTest {

	private Revista miRevista;
	
	@Before
	public void inicializar(){
		this.miRevista = new Revista("Viajes");
	}
	
	@Test
	public void ponerNombreaALaRevista(){
		Assert.assertEquals("Viajes", this.miRevista.getNombre());
	}
}
