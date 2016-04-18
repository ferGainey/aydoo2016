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
	
	@Test
	public void interpretarFormatoPrettyConMayusculasYMinusculas(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--format=prETtY");
		miLogica.interpretarFormato();
		Assert.assertEquals("pretty", miLogica.getTipoDeFormato());
	}
	
	@Test
	public void interpretarFormatoNoAceptado(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--format=yerba");
		miLogica.interpretarFormato();
		Assert.assertEquals("formato no aceptado", miLogica.getTipoDeFormato());
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
	public void leerFormatoInexistente(){
		Program program = new Program();
		program.setFormato("--format=yerbas");
		program.leer();
		Assert.assertEquals(3, program.getTipoDeFormato());
	}
	 */
}
