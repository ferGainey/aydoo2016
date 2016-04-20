package ar.edu.untref.aydoo;

import org.junit.Test;
import java.util.ArrayList;
import org.junit.Assert;

public class CalculadorDeFactoresPrimosTest{

	private CalculadorDeFactoresPrimos miCalculador = new CalculadorDeFactoresPrimos();

	@Test
	public void descomposicionDelTres(){
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,3);
		this.miCalculador.resolver(3);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void descomposicionDelUno(){
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,1);
		this.miCalculador.resolver(1);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void descomposicionDelQuince(){
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,3);
		esperado.add(1,5);
		this.miCalculador.resolver(15);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void descomposicionDelCien(){
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,2);
		esperado.add(1,2);
		esperado.add(2,5);
		esperado.add(3,5);
		this.miCalculador.resolver(100);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void descomposicionDelMilSetecientosNueve(){
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,1709);
		this.miCalculador.resolver(1709);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}

	@Test(expected = EntradaIncorrectaException.class) 
	public void ingresoDelCeroLanzaExcepcion(){
		this.miCalculador.resolver(0);
	}
	
	@Test(expected = EntradaIncorrectaException.class) 
	public void ingresoDeUnNumeroNegativoLanzaExcepcion(){
		this.miCalculador.resolver(-15);
	}
}
