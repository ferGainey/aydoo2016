package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SuscripcionTest {
	private Periodico pagina12;
	private Cliente juan;
	private Suscripcion nuevaSuscripcion;

	@Before
	public void initialize(){
		juan = new Cliente("Juan");
		pagina12 = new Periodico(12);
		pagina12.setPeriodicidad("diaria");
		nuevaSuscripcion = new Suscripcion(juan, pagina12, "agosto");
	}

	@Test
	public void verCantidadDeVecesACombrarSiPeriodicidadEsDiaria(){
		pagina12 = new Periodico(12);
		pagina12.setPeriodicidad("diaria");
		nuevaSuscripcion = new Suscripcion(juan, pagina12, "agosto");

		int cantidadDeVeces = nuevaSuscripcion.getCantidadDeEjemplaresPorMes();

		Assert.assertEquals(30, cantidadDeVeces);
	}

	@Test
	public void cantidadDeVecesACobrarSiEsMensual(){
		pagina12 = new Periodico(12);
		pagina12.setPeriodicidad("mensual");
		nuevaSuscripcion = new Suscripcion(juan, pagina12, "agosto");

		int cantidadDeVeces = nuevaSuscripcion.getCantidadDeEjemplaresPorMes();

		Assert.assertEquals(1, cantidadDeVeces);
	}
	@Test
	public void cantidadDeVecesACobrarSiEsQuincenal(){
		pagina12 = new Periodico(12);
		pagina12.setPeriodicidad("quincenal");
		nuevaSuscripcion = new Suscripcion(juan, pagina12, "agosto");

		int cantidadDeVeces = nuevaSuscripcion.getCantidadDeEjemplaresPorMes();

		Assert.assertEquals(2, cantidadDeVeces);
	}

}
