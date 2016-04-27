package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.HashMap;

import org.junit.Assert;

public class AlquilerDeLibroTest {

	@Test
	public void unAlquilerSeCreaConUnLibro(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "abril");
		Assert.assertEquals(martinFierro, miAlquiler.getLibro());
	}

	@Test
	public void unAlquilerSeCreaConUnCliente(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "abril");
		Assert.assertEquals(lucas, miAlquiler.getCliente());
	}

	@Test
	public void sePuedeAlquilarUnLibroPorDias(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "abril");
		miAlquiler.alquilarDiario(5);
		HashMap<String, Double> dineroAPagarEnDeterminadoMes = miAlquiler.getDineroAPagarEnDeterminadoMes();
		double pagoEnAbril = dineroAPagarEnDeterminadoMes.get("abril");
		Assert.assertEquals(50, pagoEnAbril, 0.01); //ya que el alquiler cuesta 10 por dia, al ser 2 dias cuesta 20
	}

	@Test
	public void sePuedeAlquilarUnLibroPorMeses(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "mayo");
		miAlquiler.alquilarMensual(3);
		HashMap<String, Double> dineroAPagarEnDeterminadoMes = miAlquiler.getDineroAPagarEnDeterminadoMes();
		double pagoEnMayo = dineroAPagarEnDeterminadoMes.get("mayo");
		double pagoEnJunio = dineroAPagarEnDeterminadoMes.get("junio");
		double pagoEnJulio = dineroAPagarEnDeterminadoMes.get("julio");
		Assert.assertEquals(200, pagoEnMayo, 0.01); //ya que el alquiler cuesta 10 por dia, al ser 2 dias cuesta 20
		Assert.assertEquals(200, pagoEnJunio, 0.01);
		Assert.assertEquals(200, pagoEnJulio, 0.01);
	}

	@Test
	public void sePuedeAlquilarUnLibroPorCuatrimestre(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "agosto");
		miAlquiler.alquilarCuatrimestral(1);//recordar que el pago se hace todo en el mes que se alquila el libro en este caso
		HashMap<String, Double> dineroAPagarEnDeterminadoMes = miAlquiler.getDineroAPagarEnDeterminadoMes();
		double pagoEnAgosto = dineroAPagarEnDeterminadoMes.get("agosto");
		Assert.assertEquals(720, pagoEnAgosto, 0.01);//recordar que hay un %10 de descuento, y que son 4 meses los que se cobran
	}

	@Test (expected = CantidadIncorrectaException.class)
	public void noPuedoAlquilarUnLibroFueraDelRangoDeDiasEnAlquilerDiario(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "abril");
		miAlquiler.alquilarDiario(2);
	}

	@Test (expected = CantidadIncorrectaException.class)
	public void noPuedoAlquilarUnLibroFueraDelRangoDeMesesEnAlquilerMensual(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "abril");
		miAlquiler.alquilarMensual(10);
	}

	@Test (expected = CantidadIncorrectaException.class)
	public void noPuedoAlquilarUnLibroFueraDelRangoDeCuatrimestresEnAlquilerCuatrimestral(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "marzo");
		miAlquiler.alquilarCuatrimestral(-5);
	}
	
	@Test (expected = OperacionNoPermitidaException.class)
	public void unAlquilerMensualNoPuedePasarDeUnAnioAOtro(){
		Libro martinFierro = new Libro(150);
		Cliente lucas = new Cliente("Lucas");
		AlquilerDeLibro miAlquiler = new AlquilerDeLibro(lucas, martinFierro, "diciembre");
		miAlquiler.alquilarMensual(3);
	}
}
