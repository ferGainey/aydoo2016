package ar.edu.untref.aydoo;

import org.junit.Test;

import org.junit.Assert;

public class LogicaDeFormatoTest {

	@Test
	public void interpretarFormatoQuiet(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--format=quiet");
		miLogica.interpretarFormato();
		Assert.assertEquals("quiet", miLogica.getTipoDeFormato());
	}
	
	@Test
	public void interpretarFormatoQuietConMayusculasYMinusculas(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--format=QuIEt");
		miLogica.interpretarFormato();
		Assert.assertEquals("quiet", miLogica.getTipoDeFormato());
	}
	
	@Test
	public void interpretarFormatoPretty(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--format=pretty");
		miLogica.interpretarFormato();
		Assert.assertEquals("pretty", miLogica.getTipoDeFormato());
	}
	/*


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
	public void leerFormatoInexistente(){
		Program program = new Program();
		program.setFormato("--format=yerbas");
		program.leer();
		Assert.assertEquals(3, program.getTipoDeFormato());
	}
	 */
}
