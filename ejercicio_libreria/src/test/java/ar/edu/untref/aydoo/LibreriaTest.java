package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LibreriaTest {

	private Libreria miLibreria;
	private Cliente matias;
	private Cliente german;
	private Cliente federico;
	private Cliente luis;
	private Cliente mariano;
	private ProductoSuscriptible barcelona;
	private ProductoSuscriptible elGrafico;
	private Producto elHobbit;
	private ArticuloDeLibreria lapicera;
	private ProductoSuscriptible pagina12;
	
	@Before
	public void inicializar(){
		this.miLibreria = new Libreria();
		this.matias = new Cliente("Matias", "Libertador 120");
		this.german = new Cliente("German", "Rivadavia 451");
		this.federico = new Cliente("Federico", "San Martin 670");
		this.luis = new Cliente("Luis", "Moreno 890");
		this.mariano = new Cliente("Mariano", "9 de Julio 604");
		this.miLibreria.agregarCliente(matias);
		this.miLibreria.agregarCliente(german);
		this.miLibreria.agregarCliente(federico);
		this.miLibreria.agregarCliente(luis);
		this.barcelona = new Revista("Barcelona");
		this.barcelona.setPeriodicidad(2);
		this.barcelona.setPrecio(20.0);
		this.elGrafico = new Revista("El Grafico");
		this.elGrafico.setPeriodicidad(1);
		this.elGrafico.setPrecio(30.0);
		this.elHobbit = new Libro("El Hobbit");
		this.elHobbit.setPrecio(50.0);
		this.lapicera = new ArticuloDeLibreria("Lapicera");
		this.lapicera.setPrecio(5.0);
		this.pagina12 = new Periodico("Pagina 12");
		this.pagina12.setPeriodicidad(30);
		this.pagina12.setPrecio(12.0);
	}
	
	@Test
	public void laLibreriaTieneUnRegistroDeLosClientesQueAgrego(){
		Assert.assertEquals(true, this.miLibreria.getRegistroDeClientes().contains(matias));
		Assert.assertEquals(true, this.miLibreria.getRegistroDeClientes().contains(german));
		Assert.assertEquals(true, this.miLibreria.getRegistroDeClientes().contains(federico));
		Assert.assertEquals(true, this.miLibreria.getRegistroDeClientes().contains(luis));
		Assert.assertEquals(false, this.miLibreria.getRegistroDeClientes().contains(mariano));
	}
	
	@Test
	public void laLibreriaCalculaElMontoACobrarParaUnClienteEnUnDeterminadoMes(){
		
	}
}
