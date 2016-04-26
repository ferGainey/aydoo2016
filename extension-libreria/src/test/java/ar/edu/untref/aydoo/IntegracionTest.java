package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {
	
	Libreria miLibreria;
	Cliente Juan;
	Cliente Maria;
	Revista Barcelona;
	Revista ElGrafico;
	Libro Hobbit;
	ArticuloDeLibreria Lapicera;
	Periodico Pagina12;
	Periodico Clarin;
	
	@Before
	public void initialize(){
		Barcelona = new Revista(20,"quincenal");
		ElGrafico = new Revista(30, "mensual");
		Hobbit = new Libro(50,"unica");
		Lapicera = new ArticuloDeLibreria(5,"unica");
		Pagina12 = new Periodico(12,"diaria");
		Clarin = new Periodico(13,"diaria");
		
		Juan = new Cliente("Juan");
		Maria = new Cliente("Maria");
		
		miLibreria = new Libreria();
		miLibreria.addCliente(Juan);
		miLibreria.addCliente(Maria);
	}
	
	@Test
	public void calculandoMontoDeMesSinCompras(){
		miLibreria.nuevaCompra(new Compra(Juan, Lapicera, 2, "marzo"));
		
		double montoACobrar = miLibreria.CalcularMontoACrobar("diciembre", Juan);
		
		Assert.assertEquals(0, montoACobrar,0.01);
	}
	
	@Test
	public void calculandoMontoACobrarConUnArticuloDeLibreria(){
		miLibreria.nuevaCompra(new Compra(Juan, Lapicera, 2, "marzo"));
		
		double montoACobrar = miLibreria.CalcularMontoACrobar("marzo", Juan);
		
		Assert.assertEquals(12.1, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoDeMariaComprandoUnEjemplar(){
		miLibreria.nuevaCompra(new Compra(Maria, Pagina12, 1, "enero"));
		
		double montoACobrar =  miLibreria.CalcularMontoACrobar("enero", Maria);
		
		Assert.assertEquals(12, montoACobrar,0.01);
	}
	
	@Test
	public void calculandoMontoACobrarConSuscripcionesYProductos(){
		miLibreria.nuevaCompra(new Compra(Juan, Hobbit, 1, "agosto"));
		miLibreria.nuevaSuscripcion(new Suscripcion(Juan, Barcelona, "agosto"));
		
		double montoACobrar = miLibreria.CalcularMontoACrobar("agosto", Juan);
		
		Assert.assertEquals(90, montoACobrar,0.01);
	}
	
	@Test
	public void calculandoMontoACobrarConSuscripcionDiaria(){
		miLibreria.nuevaSuscripcion(new Suscripcion(Juan, Clarin, "agosto"));
		
		double montoACobrar = miLibreria.CalcularMontoACrobar("agosto", Juan);
		
		Assert.assertEquals(390, montoACobrar,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarDeJuanCaso1(){
		miLibreria.nuevaCompra(new Compra(Juan, Hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(Juan, Lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(Juan, ElGrafico, 1, "agosto"));
		
		double montoACobrarEnAgosto = miLibreria.CalcularMontoACrobar("agosto", Juan);
		
		Assert.assertEquals(92.1, montoACobrarEnAgosto,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarMariaCaso2(){
		miLibreria.nuevaCompra(new Compra(Maria, Pagina12, 1, "enero"));
		miLibreria.nuevaSuscripcion(new Suscripcion(Maria, Barcelona,"enero", "anual"));
		
		double montoACobrar = miLibreria.CalcularMontoACrobar("enero", Maria);
		
		Assert.assertEquals(44, montoACobrar,0.01);
	}
	
}
