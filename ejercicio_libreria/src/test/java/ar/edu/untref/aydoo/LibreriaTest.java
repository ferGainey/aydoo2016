package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LibreriaTest {

	private Libreria miLibreria = Libreria.getInstance();
	private Cliente juan;
	private Cliente maria;
	private ProductoSuscriptible barcelona;
	private ProductoSuscriptible elGrafico;
	private Producto elHobbit;
	private ArticuloDeLibreria lapicera;
	private ProductoSuscriptible pagina12;
	private ProductoSuscriptible clarin;
	
	@Before
	public void inicializar(){
		this.juan = new Cliente("Luis", "Moreno 890");
		this.maria = new Cliente("Maria", "9 de Julio 604");
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
		this.clarin = new Periodico("Clarin");
		this.clarin.setPeriodicidad(30);
		this.clarin.setPrecio(13.0);
	}
	
	@Test
	public void laLibreriaCalculaElMontoACobrarParaUnClienteEnUnDeterminadoMes(){
		Mes agosto = new Mes("Agosto");
		Compra compraHobbit = new Compra(agosto, this.elHobbit);
		Compra primerLapicera = new Compra(agosto, this.lapicera);
		Compra segundaLapicera = new Compra(agosto, this.lapicera);
		Compra elGraficoSinSuscripcion = new Compra(agosto, this.elGrafico);
		this.juan.efectuarCompra(compraHobbit);
		this.juan.efectuarCompra(primerLapicera);
		this.juan.efectuarCompra(segundaLapicera);
		this.juan.efectuarCompra(elGraficoSinSuscripcion);
		Assert.assertEquals(92.1, this.miLibreria.calcularMontoACobrar(agosto,this.juan));
	}
	
}
