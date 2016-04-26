package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SuscripcionTest {
	Periodico Pagina12;
	Cliente Juan;
	Suscripcion nuevaSuscripcion;
	
	@Before
	public void initialize(){
		Juan = new Cliente("Juan");
		Pagina12 = new Periodico(12,"diaria");
		nuevaSuscripcion = new Suscripcion(Juan, Pagina12, "agosto");
	}
	
	@Test
	public void verCantidadDeVecesACombrarSiPeriodicidadEsDiaria(){
		Pagina12 = new Periodico(12,"diaria");
		nuevaSuscripcion = new Suscripcion(Juan, Pagina12, "agosto");
		
		int cantidadDeVeces = nuevaSuscripcion.getCantidadDeEjemplaresPorMes();
		
		Assert.assertEquals(30, cantidadDeVeces);
	}
	
	@Test
	public void cantidadDeVecesACobrarSiEsMensual(){
		Pagina12 = new Periodico(12,"mensual");
		nuevaSuscripcion = new Suscripcion(Juan, Pagina12, "agosto");
		
		int cantidadDeVeces = nuevaSuscripcion.getCantidadDeEjemplaresPorMes();
		
		Assert.assertEquals(1, cantidadDeVeces);
	}
	@Test
	public void cantidadDeVecesACobrarSiEsQuincenal(){
		Pagina12 = new Periodico(12,"quincenal");
		nuevaSuscripcion = new Suscripcion(Juan, Pagina12, "agosto");
		
		int cantidadDeVeces = nuevaSuscripcion.getCantidadDeEjemplaresPorMes();
		
		Assert.assertEquals(2, cantidadDeVeces);
	}
}
