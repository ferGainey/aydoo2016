package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {

	private Libreria miLibreria;
	private Cliente juan;
	private Cliente maria;
	private Revista barcelona;
	private Revista elGrafico;
	private Libro hobbit;
	private ArticuloDeLibreria lapicera;
	private Periodico pagina12;
	private Periodico clarin;

	@Before
	public void initialize(){
		barcelona = new Revista(20,"quincenal");
		elGrafico = new Revista(30, "mensual");
		hobbit = new Libro(50,"unica");
		lapicera = new ArticuloDeLibreria(5,"unica");
		pagina12 = new Periodico(12,"diaria");
		clarin = new Periodico(13,"diaria");

		juan = new Cliente("Juan");
		maria = new Cliente("Maria");

		miLibreria = new Libreria();
		miLibreria.addCliente(juan);
		miLibreria.addCliente(maria);
	}

	@Test
	public void calculandoMontoDeMesSinCompras(){
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "marzo"));

		double montoACobrar = miLibreria.CalcularMontoACrobar("diciembre", juan);

		Assert.assertEquals(0, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoACobrarConUnArticuloDeLibreria(){
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "marzo"));

		double montoACobrar = miLibreria.CalcularMontoACrobar("marzo", juan);

		Assert.assertEquals(12.1, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoDeMariaComprandoUnEjemplar(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));

		double montoACobrar =  miLibreria.CalcularMontoACrobar("enero", maria);

		Assert.assertEquals(12, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoACobrarConSuscripcionesYProductos(){
		miLibreria.nuevaCompra(new Compra(juan, hobbit, 1, "agosto"));
		miLibreria.nuevaSuscripcion(new Suscripcion(juan, barcelona, "agosto"));

		double montoACobrar = miLibreria.CalcularMontoACrobar("agosto", juan);

		Assert.assertEquals(90, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoACobrarConSuscripcionDiaria(){
		miLibreria.nuevaSuscripcion(new Suscripcion(juan, clarin, "agosto"));

		double montoACobrar = miLibreria.CalcularMontoACrobar("agosto", juan);

		Assert.assertEquals(390, montoACobrar,0.01);
	}

	@Test
	public void probandoCalcularMontoACobrarDeJuanCaso1(){
		miLibreria.nuevaCompra(new Compra(juan, hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, elGrafico, 1, "agosto"));

		double montoACobrarEnAgosto = miLibreria.CalcularMontoACrobar("agosto", juan);

		Assert.assertEquals(92.1, montoACobrarEnAgosto,0.01);
	}

	@Test
	public void probandoCalcularMontoACobrarMariaCaso2(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));
		miLibreria.nuevaSuscripcion(new Suscripcion(maria, barcelona,"enero", "anual"));

		double montoACobrar = miLibreria.CalcularMontoACrobar("enero", maria);

		Assert.assertEquals(44, montoACobrar,0.01);
	}

}
