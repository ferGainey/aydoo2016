package ar.edu.untref.aydoo;

import org.junit.Test;
import java.util.ArrayList;
import org.junit.Assert;

public class CalculadorDeFactoresPrimosTest 
{

	private CalculadorDeFactoresPrimos miCalculador = new CalculadorDeFactoresPrimos();
	
	@Test
	public void descomposicionDelTres()
	{
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,3);
		this.miCalculador.resolver(3);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}
	
	
	@Test
	public void descomposicionDelUno()
	{
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,1);
		this.miCalculador.resolver(1);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}
/*
	@Test
	public void descomposicionDelQuince()
	{
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,3);
		esperado.add(1,5);
		this.miCalculador.resolver(15);
		ArrayList<Integer> resultado = this.miCalculador.getListaDeDivisoresPrimos();
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void descomposicionDelCien()
	{
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
	public void descomposicionDelMilSetecientosNueve()
	{
		Program program = new Program();
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0,1709);
		program.resolver(1709);
		ArrayList<Integer> result = program.listaDivisoresPrimos;
		Assert.assertEquals(esperado, result);
	}

	@Test
	public void invertirListaDeVariosElementos(){
		Program program = new Program();
		ArrayList<Integer> listaNoOrdenada = new ArrayList<Integer>();
		listaNoOrdenada.add(0, 1);listaNoOrdenada.add(1, 2);listaNoOrdenada.add(2, 3);
		listaNoOrdenada.add(3, 4);listaNoOrdenada.add(4, 5);
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0, 5);esperado.add(1, 4);esperado.add(2, 3);esperado.add(3, 2);
		esperado.add(4, 1);
		ArrayList<Integer> listaObtenida = program.invertirLista(listaNoOrdenada);
		Assert.assertEquals(esperado, listaObtenida);  	
	}

	@Test
	public void invertirListaDeUnElemento(){
		Program program = new Program();
		ArrayList<Integer> listaNoOrdenada = new ArrayList<Integer>();
		listaNoOrdenada.add(0, 1);
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		esperado.add(0, 1);
		ArrayList<Integer> listaObtenida = program.invertirLista(listaNoOrdenada);
		Assert.assertEquals(esperado, listaObtenida);  	
	}

	@Test
	public void leerFormatoPretty(){
		Program program = new Program();
		program.setFormato("--format=pretty");
		program.leer();
		Assert.assertEquals(1, program.getTipoDeFormato());
	}

	@Test
	public void leerFormatoPrettyConMayusculasYMinusculas(){
		Program program = new Program();
		program.setFormato("--format=PRetTY");
		program.leer();
		Assert.assertEquals(1, program.getTipoDeFormato());
	}

	// como no pone nunca que va a querer escribir en algun formato (con la palabra --format)
	// entonces corre por defecto el formato pretty
	@Test
	public void leerAlgoQueNoPoneFormat(){
		Program program = new Program();
		program.setFormato("cualquier cosa");
		program.leer();
		Assert.assertEquals(1, program.getTipoDeFormato());
	}

	@Test
	public void leerFormatoQuiet(){
		Program program = new Program();
		program.setFormato("--format=quiet");
		program.leer();
		Assert.assertEquals(2, program.getTipoDeFormato());
	}

	@Test
	public void pruebaSepararPalabra(){
		Program program = new Program();
		program.setFormato("--format=quiet");
		String [] palabraSeparada = program.separarPalabra(program.getFormato());
		String palabra1 = palabraSeparada[0];
		String palabra2 = palabraSeparada[1];
		Assert.assertEquals("--format", palabra1);
		Assert.assertEquals("quiet", palabra2);
		Assert.assertEquals(2, palabraSeparada.length);
	}


	@Test
	public void leerFormatoQuietConMayusculasYMinusculas(){
		Program program = new Program();
		program.setFormato("--format=qUIeT");
		program.leer();
		Assert.assertEquals(2, program.getTipoDeFormato());
	}


	@Test
	public void leerFormatoInexistente(){
		Program program = new Program();
		program.setFormato("--format=yerbas");
		program.leer();
		Assert.assertEquals(3, program.getTipoDeFormato());
	}
	*/
}
