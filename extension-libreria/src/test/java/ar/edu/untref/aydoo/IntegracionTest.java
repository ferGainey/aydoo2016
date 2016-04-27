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
		barcelona = new Revista(20);
		barcelona.setPeriodicidad("quincenal");
		elGrafico = new Revista(30);
		elGrafico.setPeriodicidad("mensual");
		hobbit = new Libro(50);
		lapicera = new ArticuloDeLibreria(5);
		pagina12 = new Periodico(12);
		pagina12.setPeriodicidad("diaria");
		clarin = new Periodico(13);
		clarin.setPeriodicidad("diaria");

		juan = new Cliente("Juan");
		maria = new Cliente("Maria");

		miLibreria = new Libreria();
		miLibreria.addCliente(juan);
		miLibreria.addCliente(maria);
	}

	@Test
	public void calculandoMontoDeMesSinCompras(){
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "marzo"));

		double montoACobrar = miLibreria.calcularMontoACobrar("diciembre", juan);

		Assert.assertEquals(0, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoACobrarConUnArticuloDeLibreria(){
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "marzo"));

		double montoACobrar = miLibreria.calcularMontoACobrar("marzo", juan);

		Assert.assertEquals(12.1, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoDeMariaComprandoUnEjemplar(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));

		double montoACobrar =  miLibreria.calcularMontoACobrar("enero", maria);

		Assert.assertEquals(12, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoACobrarConSuscripcionesYProductos(){
		miLibreria.nuevaCompra(new Compra(juan, hobbit, 1, "agosto"));
		miLibreria.nuevaSuscripcion(new Suscripcion(juan, barcelona, "agosto"));

		double montoACobrar = miLibreria.calcularMontoACobrar("agosto", juan);

		Assert.assertEquals(90, montoACobrar,0.01);
	}

	@Test
	public void calculandoMontoACobrarConSuscripcionDiaria(){
		miLibreria.nuevaSuscripcion(new Suscripcion(juan, clarin, "agosto"));

		double montoACobrar = miLibreria.calcularMontoACobrar("agosto", juan);

		Assert.assertEquals(390, montoACobrar,0.01);
	}

	@Test
	public void probandoCalcularMontoACobrarDeJuanCaso1(){
		miLibreria.nuevaCompra(new Compra(juan, hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, elGrafico, 1, "agosto"));

		double montoACobrarEnAgosto = miLibreria.calcularMontoACobrar("agosto", juan);

		Assert.assertEquals(92.1, montoACobrarEnAgosto,0.01);
	}

	@Test
	public void probandoCalcularMontoACobrarMariaCaso2(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));
		miLibreria.nuevaSuscripcion(new Suscripcion(maria, barcelona,"enero", "anual"));

		double montoACobrar = miLibreria.calcularMontoACobrar("enero", maria);

		Assert.assertEquals(44, montoACobrar,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarDeJuanCaso1MasElAlquilerDeUnLibroPorDias(){
		miLibreria.nuevaCompra(new Compra(juan, hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, elGrafico, 1, "agosto"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(juan, harryPotter, "agosto");
		miAlquiler.alquilarDiario(10);//serian $100
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		
		double montoACobrarEnAgosto = miLibreria.calcularMontoACobrar("agosto", juan);

		Assert.assertEquals(192.1, montoACobrarEnAgosto,0.01);
	}

	@Test
	public void probandoCalcularMontoACobrarMariaCaso2MasElAlquilerDeVariosLibrosPorDias(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));
		miLibreria.nuevaSuscripcion(new Suscripcion(maria, barcelona,"enero", "anual"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(maria, harryPotter, "enero");
		miAlquiler.alquilarDiario(10);//serian $100
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		Libro harryPotter2 = new Libro(250);
		AlquilerDeLibro miAlquiler2 = new AlquilerDeLibro(maria, harryPotter2, "enero");
		miAlquiler2.alquilarDiario(20);//serian $200
		miLibreria.nuevoAlquilerDeLibro(miAlquiler2);
		
		double montoACobrar = miLibreria.calcularMontoACobrar("enero", maria);

		Assert.assertEquals(344, montoACobrar,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarMariaCaso2MasElAlquilerDeVariosLibrosPorDiasPeroUnoEsEnOtroMes(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));
		miLibreria.nuevaSuscripcion(new Suscripcion(maria, barcelona,"enero", "anual"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(maria, harryPotter, "enero");
		miAlquiler.alquilarDiario(10);//serian $100
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		Libro harryPotter2 = new Libro(250);
		AlquilerDeLibro miAlquiler2 = new AlquilerDeLibro(maria, harryPotter2, "febrero");
		miAlquiler2.alquilarDiario(20);//serian $200, que no se sumarian porque son de febrero y no de enero
		miLibreria.nuevoAlquilerDeLibro(miAlquiler2);
		
		double montoACobrar = miLibreria.calcularMontoACobrar("enero", maria);

		Assert.assertEquals(144, montoACobrar,0.01);
	}
	

	@Test
	public void probandoCalcularMontoACobrarDeJuanCaso1MasElAlquilerDeUnLibroPorMeses(){
		miLibreria.nuevaCompra(new Compra(juan, hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, elGrafico, 1, "agosto"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(juan, harryPotter, "agosto");
		miAlquiler.alquilarMensual(2);//serian $400, pero $200 serian del mes de agosto, y $200 de septiembre
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		
		double montoACobrarEnAgosto = miLibreria.calcularMontoACobrar("agosto", juan);
		double montoACobrarEnSeptiembre = miLibreria.calcularMontoACobrar("septiembre", juan);

		Assert.assertEquals(292.1, montoACobrarEnAgosto,0.01);
		Assert.assertEquals(200, montoACobrarEnSeptiembre, 0.01);
	}

	@Test
	public void probandoCalcularMontoACobrarMariaMasElAlquilerDeVariosLibrosPorMeses(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));
		miLibreria.nuevaCompra(new Compra(maria, hobbit, 1, "marzo"));
		miLibreria.nuevaSuscripcion(new Suscripcion(maria, barcelona,"enero", "anual"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(maria, harryPotter, "enero");
		miAlquiler.alquilarMensual(1);//serian $200
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		Libro harryPotter2 = new Libro(250);
		AlquilerDeLibro miAlquiler2 = new AlquilerDeLibro(maria, harryPotter2, "enero");
		miAlquiler2.alquilarMensual(3);//serian $600, pero $200 serian de enero, $200 de febrero y $200 de marzo
		miLibreria.nuevoAlquilerDeLibro(miAlquiler2);
		
		double montoACobrarEnero = miLibreria.calcularMontoACobrar("enero", maria);
		double montoACobrarFebrero = miLibreria.calcularMontoACobrar("febrero", maria);
		double montoACobrarMarzo = miLibreria.calcularMontoACobrar("marzo", maria);

		Assert.assertEquals(444, montoACobrarEnero,0.01);
		Assert.assertEquals(200, montoACobrarFebrero,0.01);
		Assert.assertEquals(250, montoACobrarMarzo,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarDeJuanCaso1MasElAlquilerDeUnLibroPorCuatrimestre(){
		miLibreria.nuevaCompra(new Compra(juan, hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(juan, elGrafico, 1, "agosto"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(juan, harryPotter, "agosto");
		miAlquiler.alquilarCuatrimestral(1);;//serian $800 - 80(del descuento) = $720 que se cobran todo junto
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		
		double montoACobrarEnAgosto = miLibreria.calcularMontoACobrar("agosto", juan);

		Assert.assertEquals(812.1, montoACobrarEnAgosto,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarMariaCaso2MasElAlquilerDeVariosLibrosPorCuatrimestre(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));
		miLibreria.nuevaSuscripcion(new Suscripcion(maria, barcelona,"enero", "anual"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(maria, harryPotter, "enero");
		miAlquiler.alquilarCuatrimestral(2);;//serian $1600 - 160 = 1440
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		Libro harryPotter2 = new Libro(250);
		AlquilerDeLibro miAlquiler2 = new AlquilerDeLibro(maria, harryPotter2, "enero");
		miAlquiler2.alquilarCuatrimestral(1);;//serian $800 - 80 = 720
		miLibreria.nuevoAlquilerDeLibro(miAlquiler2);
		
		double montoACobrar = miLibreria.calcularMontoACobrar("enero", maria);

		Assert.assertEquals(2204, montoACobrar,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarMariaCaso2MasElAlquilerDeVariosLibrosPorDistintoCuatrimestre(){
		miLibreria.nuevaCompra(new Compra(maria, pagina12, 1, "enero"));
		miLibreria.nuevaSuscripcion(new Suscripcion(maria, barcelona,"enero", "anual"));
		Libro harryPotter = new Libro(150);
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(maria, harryPotter, "enero");
		miAlquiler.alquilarCuatrimestral(2);;//serian $1600 - 160 = 1440
		miLibreria.nuevoAlquilerDeLibro(miAlquiler);
		Libro harryPotter2 = new Libro(250);
		AlquilerDeLibro miAlquiler2 = new AlquilerDeLibro(maria, harryPotter2, "julio");
		miAlquiler2.alquilarCuatrimestral(1);;//serian $800 - 80 = 720
		miLibreria.nuevoAlquilerDeLibro(miAlquiler2);
		
		double montoACobrarEnero = miLibreria.calcularMontoACobrar("enero", maria);
		double montoACobrarJulio = miLibreria.calcularMontoACobrar("julio", maria);

		Assert.assertEquals(1484, montoACobrarEnero,0.01);
		Assert.assertEquals(720, montoACobrarJulio,0.01);
	}
}
