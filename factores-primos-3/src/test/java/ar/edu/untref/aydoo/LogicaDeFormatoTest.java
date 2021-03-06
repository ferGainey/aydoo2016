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
	
	/*como no pone nunca que va a querer escribir en algun formato (con la palabra --format)
	 *entonces corre por defecto el formato pretty
	 */
	@Test
	public void interpretarQueNoSeRecibioParametro(){
		LogicaDeFormato miLogica = new LogicaDeFormato("");
		miLogica.interpretarFormato();
		Assert.assertEquals("pretty", miLogica.getTipoDeFormato());
	}
	
	//por defecto el orden de escritura es ascendente
	@Test
	public void interpretarOrdenDeEscrituraPorDefecto(){
		LogicaDeFormato miLogica = new LogicaDeFormato("");
		miLogica.interpretarOrden();
		Assert.assertEquals("asc", miLogica.getOrden());
	}

	@Test
	public void interpretarOrdenDeEscrituraAscendente(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--sort:asc");
		miLogica.interpretarOrden();
		Assert.assertEquals("asc", miLogica.getOrden());
	}
	
	@Test
	public void interpretarOrdenDeEscrituraDescendente(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--sort:des");
		miLogica.interpretarOrden();
		Assert.assertEquals("des", miLogica.getOrden());
	}
	
	/*el campo escrituraEnArchivo indica el nombre del archivo si se indica de que la salida es por archivo, y si no
	 * indica "no" que significa que no es por archivo. Y por defecto es por consola. 
	 */
	@Test
	public void porDefectoLaEscrituraEsEnConsola(){
		LogicaDeFormato miLogica = new LogicaDeFormato("");
		miLogica.interpretarTipoDeEscritura();
		Assert.assertEquals("no", miLogica.getEscrituraEnArchivo());
	}
	
	//cuando el se indica como output un archivo
	@Test
	public void interpretarNombreDeArchivo(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--output-file=salida.txt");
		miLogica.interpretarTipoDeEscritura();
		Assert.assertEquals("salida.txt", miLogica.getEscrituraEnArchivo());
	}
	
	@Test
	public void interpretarRutaYNombreDeArchivo(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--output-file=/home/fernando/salida.txt");
		miLogica.interpretarTipoDeEscritura();
		Assert.assertEquals("/home/fernando/salida.txt", miLogica.getEscrituraEnArchivo());
	}
	
	@Test
	public void interpretarFormatoOrdenYNombreDeArchivoALaVez(){
		LogicaDeFormato miLogica = new LogicaDeFormato("--format=quiet --sort:des --output-file=salida.txt");
		miLogica.interpretarFormato();
		miLogica.interpretarOrden();
		miLogica.interpretarTipoDeEscritura();
		Assert.assertEquals("quiet", miLogica.getTipoDeFormato());
		Assert.assertEquals("des", miLogica.getOrden());
		Assert.assertEquals("salida.txt", miLogica.getEscrituraEnArchivo());
	}
	
	@Test
	public void interpretarFormatoOrdenYNombreDeArchivoALaVezDesordenados(){
		LogicaDeFormato miLogica = new LogicaDeFormato(" --output-file=salida.txt --sort:des --format=quiet");
		miLogica.interpretarFormato();
		miLogica.interpretarOrden();
		miLogica.interpretarTipoDeEscritura();
		Assert.assertEquals("quiet", miLogica.getTipoDeFormato());
		Assert.assertEquals("des", miLogica.getOrden());
		Assert.assertEquals("salida.txt", miLogica.getEscrituraEnArchivo());
	}
}
