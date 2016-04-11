package ar.edu.untref.aydoo;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MesTest {

	@Test
	public void ponerNombreAlMes(){
		Mes mayo = new Mes("Mayo");
		Assert.assertEquals("Mayo", mayo.getNombre());
	}
}
