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
		this.juan = new Cliente("Juan", "Moreno 890");
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

	@Test
	public void laLibreriaCalculaElMontoACobrarParaUnClienteEnUnDeterminadoMesConUnProductoConSUscripcionAnual(){
		Mes enero = new Mes("Enero");
		Compra compraEjemplarPagina12 = new Compra(enero, this.pagina12);
		Suscripcion suscripcionBarcelona = new Suscripcion(this.barcelona);
		this.maria.efectuarCompra(compraEjemplarPagina12);
		this.maria.suscribirseAnualmente(suscripcionBarcelona);
		Assert.assertEquals(44.0, this.miLibreria.calcularMontoACobrar(enero,this.maria));
	}

	@Test
	public void laLibreriaCalculaElMontoACobrarParaUnClienteEnUnDeterminadoMesTeniendoComprasEnDistintosMeses(){
		Mes agosto = new Mes("Agosto");
		Mes marzo = new Mes("Marzo");
		Compra compraHobbit = new Compra(agosto, this.elHobbit);
		Compra primerLapicera = new Compra(agosto, this.lapicera);
		Compra segundaLapicera = new Compra(agosto, this.lapicera);
		Compra elGraficoSinSuscripcion = new Compra(agosto, this.elGrafico);
		Compra compraClarinSinSuscripcion = new Compra(marzo, this.clarin);
		Compra compraHobbitEnMarzo = new Compra(marzo, this.elHobbit);
		this.juan.efectuarCompra(compraHobbit);
		this.juan.efectuarCompra(primerLapicera);
		this.juan.efectuarCompra(segundaLapicera);
		this.juan.efectuarCompra(elGraficoSinSuscripcion);
		this.juan.efectuarCompra(compraHobbitEnMarzo);
		this.juan.efectuarCompra(compraClarinSinSuscripcion);
		Assert.assertEquals(63.0, this.miLibreria.calcularMontoACobrar(marzo,this.juan));
	}

	@Test
	public void laLibreriaCalculaElMontoACobrarParaUnClienteEnUnDeterminadoMesTeniendoComprasEnDistintosMesesYTieneUnaSuscripcion(){
		Mes agosto = new Mes("Agosto");
		Mes marzo = new Mes("Marzo");
		Compra compraHobbit = new Compra(agosto, this.elHobbit);
		Compra primerLapicera = new Compra(agosto, this.lapicera);
		Compra segundaLapicera = new Compra(agosto, this.lapicera);
		Compra elGraficoSinSuscripcion = new Compra(agosto, this.elGrafico);
		Compra compraClarinSinSuscripcion = new Compra(marzo, this.clarin);
		Compra compraHobbitEnMarzo = new Compra(marzo, this.elHobbit);
		Suscripcion suscripcionAPagina12 = new Suscripcion(this.pagina12);
		this.maria.suscribirseAnualmente(suscripcionAPagina12);
		this.maria.efectuarCompra(compraHobbit);
		this.maria.efectuarCompra(primerLapicera);
		this.maria.efectuarCompra(segundaLapicera);
		this.maria.efectuarCompra(elGraficoSinSuscripcion);
		this.maria.efectuarCompra(compraHobbitEnMarzo); //en marzo
		this.maria.efectuarCompra(compraClarinSinSuscripcion);//en marzo
		Assert.assertEquals(351.0, this.miLibreria.calcularMontoACobrar(marzo,this.maria));
	}

	@Test
	public void laLibreriaCalculaElMontoACobrarParaUnClienteEnUnDeterminadoMesTeniendoComprasEnDistintosMesesYVariasSuscripciones(){
		Mes agosto = new Mes("Agosto");
		Mes marzo = new Mes("Marzo");
		Compra compraHobbit = new Compra(agosto, this.elHobbit);
		Compra compraClarinSinSuscripcionEnAgosto = new Compra(agosto, this.clarin);
		Compra primerLapicera = new Compra(agosto, this.lapicera);
		Compra segundaLapicera = new Compra(agosto, this.lapicera);
		Compra compraClarinSinSuscripcionEnMarzo = new Compra(marzo, this.clarin);
		Compra compraHobbitEnMarzo = new Compra(marzo, this.elHobbit);
		Suscripcion suscripcionAPagina12 = new Suscripcion(this.pagina12);
		Suscripcion suscripcionAElGrafico = new Suscripcion(this.elGrafico);
		Suscripcion suscripcionABarcelona = new Suscripcion(this.barcelona);
		this.maria.suscribirseAnualmente(suscripcionAPagina12);
		this.maria.suscribirseAnualmente(suscripcionAElGrafico);
		this.maria.suscribirseAnualmente(suscripcionABarcelona);
		this.maria.efectuarCompra(compraClarinSinSuscripcionEnAgosto);//agosto
		this.maria.efectuarCompra(compraHobbit);//agosto
		this.maria.efectuarCompra(primerLapicera);//agosto
		this.maria.efectuarCompra(segundaLapicera);//agosto
		this.maria.efectuarCompra(compraHobbitEnMarzo); //en marzo
		this.maria.efectuarCompra(compraClarinSinSuscripcionEnMarzo);//en marzo
		Assert.assertEquals(419.1, this.miLibreria.calcularMontoACobrar(agosto,this.maria));
	}

	@Test
	public void laLibreriaPuedeObtenerElNombreDeUnCliente(){
		Assert.assertEquals("Juan", this.miLibreria.getNombreDeUnCliente(this.juan));
	}

	@Test
	public void laLibreriaPuedeObtenerLaDireccionDeUnCliente(){
		Assert.assertEquals("Moreno 890", this.miLibreria.getDireccionDeUnCliente(this.juan));
	}
}
