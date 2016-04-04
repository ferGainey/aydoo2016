package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;


public class IntegrationTest 
{
	private Boleta miBoleta;
	private Candidato pepe;
	private Candidato jose;
	private Candidato fernando;
	private Candidato javier;
	private Candidato matias;
	private Candidato cosme;
	private Candidato jorge;
	private Partido frenteNorte;
	private Partido frenteSur;
	private Partido frenteUnido;
	private JuntaElectoral juntaElectoral;
	private MesaDeVotacion mesaDeVotacion1;
	private MesaDeVotacion mesaDeVotacion2;
	private MesaDeVotacion mesaDeVotacion3;
	private Provincia buenosAires;
	private Provincia jujuy;
	private Provincia chubut;
	private Urna urnaDeMesa1;
	private Urna urnaDeMesa2;
	private CentroDeComputoProvincial centroDeComputoDeBuenosAires;
	private CentroDeComputoProvincial centroDeComputoDeChubut;
	private CentroDeComputoNacional centroDeComputoNacional;
	
	@Before
	public void inicializar()
	{
		this.frenteNorte = new Partido("Frente Norte");
		this.frenteSur = new Partido("Frente Sur");
		this.frenteUnido = new Partido("Frente Unido");
		this.pepe = new Candidato("Pepe", frenteNorte);
		this.jose = new Candidato("Jose", frenteNorte);
		this.fernando = new Candidato("Fernando", frenteNorte);
		this.javier = new Candidato("Javier", frenteSur);
		this.matias = new Candidato("Matias",frenteUnido);
		this.cosme = new Candidato("Cosme", frenteUnido);
		this.jorge = new Candidato("Jorge", frenteSur);
		this.centroDeComputoNacional = new CentroDeComputoNacional();
		this.juntaElectoral = new JuntaElectoral();
		this.juntaElectoral.agregarCandidatoAprobado(this.pepe);
		this.juntaElectoral.agregarCandidatoAprobado(this.jose);
		this.juntaElectoral.agregarCandidatoAprobado(this.fernando);
		this.juntaElectoral.agregarCandidatoAprobado(this.javier);
		this.juntaElectoral.agregarCandidatoAprobado(this.matias);
		this.juntaElectoral.agregarCandidatoAprobado(this.cosme);
		this.miBoleta = new Boleta(this.juntaElectoral);
		this.buenosAires = new Provincia("Buenos Aires");
		this.jujuy = new Provincia("Jujuy");
		this.chubut = new Provincia("Chubut");
		this.urnaDeMesa1 = new Urna();
		this.mesaDeVotacion1 = new MesaDeVotacion(buenosAires, urnaDeMesa1);
		this.centroDeComputoDeBuenosAires = new CentroDeComputoProvincial(this.centroDeComputoNacional);
		this.centroDeComputoDeChubut = new CentroDeComputoProvincial(this.centroDeComputoNacional);
		this.buenosAires.setCentroDeComputo(centroDeComputoDeBuenosAires);
		this.chubut.setCentroDeComputo(centroDeComputoDeChubut);
		this.urnaDeMesa2 = new Urna();
		this.mesaDeVotacion2 = new MesaDeVotacion(chubut, urnaDeMesa2);
	}
	
    @Test
    public void cargarBoleta()
    {
        this.miBoleta.setCandidato(pepe);
        Assert.assertEquals(pepe, this.miBoleta.getCandidato());
    }
    
    @Test
    public void obtenerNombreCandidato()
    {
    	Assert.assertEquals("Pepe", this.pepe.getNombre());
    }
    
    @Test
    public void obtenerPartidoDelCandidato()
    {
    	Assert.assertEquals(frenteNorte, this.pepe.getPartido());
    }
    
    @Test
    public void obtenerNombreDelPartido()
    {
    	Assert.assertEquals("Frente Sur", this.frenteSur.getNombre());
    }
    
    @Test
    public void elPartidoTieneALosCandidatosQueSePusieronQuePertenecenAEl()
    {
    	Assert.assertEquals(true, this.frenteNorte.getCandidatos().contains(fernando));
    	Assert.assertEquals(true, this.frenteNorte.getCandidatos().contains(pepe));
    	Assert.assertEquals(true, this.frenteNorte.getCandidatos().contains(jose));
    }
    
    @Test
    public void laJuntaElectoralTieneLaListaCorrectaDeLosCandidatosAprobados()
    {
    	Assert.assertEquals(true, this.juntaElectoral.getCandidatosAprobados().contains(cosme));
    	Assert.assertEquals(true, this.juntaElectoral.getCandidatosAprobados().contains(pepe));
    	Assert.assertEquals(true, this.juntaElectoral.getCandidatosAprobados().contains(jose));
    	Assert.assertEquals(true, this.juntaElectoral.getCandidatosAprobados().contains(fernando));
    	Assert.assertEquals(true, this.juntaElectoral.getCandidatosAprobados().contains(javier));
    	Assert.assertEquals(true, this.juntaElectoral.getCandidatosAprobados().contains(matias));
    }
    
    @Test
    public void laJuntaElectoralNoTieneEnSuListaCandidatosNoAprobados()
    {
    	Assert.assertEquals(false, this.juntaElectoral.getCandidatosAprobados().contains(jorge));
    }
    
    @Test
    public void seEliminaCorrectamenteUnCandidatoDeLaListaDeAprobados()
    {
    	this.juntaElectoral.eliminarCandidatoAprobado(pepe);
    	Assert.assertEquals(false, this.juntaElectoral.getCandidatosAprobados().contains(pepe));
    }
    
    @Test
    public void obtenerProvinciaDeLaMesaDeVotacion()
    {
    	Assert.assertEquals(buenosAires, this.mesaDeVotacion1.getProvincia());
    }
    
    @Test
    public void obtenerUrnaDeLaMesa1()
    {
    	Assert.assertEquals(urnaDeMesa1, this.mesaDeVotacion1.getUrna());
    }
    
    @Test
    public void emitirVoto()
    {
    	this.miBoleta.setCandidato(fernando);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	Assert.assertEquals(true, this.mesaDeVotacion1.getUrna().getVotos().contains(miBoleta));
    }
    
    //se siguieron las recomendaciones que estan comentadas sobre los metodos en cuestion
    @Test
    public void sePuedeVotarEnBlanco()
    {
    	Partido enBlanco = new Partido("Voto en blanco");
    	Candidato votoEnBlanco = new Candidato("En Blanco", enBlanco);
    	this.juntaElectoral.agregarCandidatoAprobado(votoEnBlanco);
    	this.miBoleta.setCandidato(votoEnBlanco);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	Assert.assertEquals(true, this.mesaDeVotacion1.getUrna().getVotos().contains(miBoleta));
    	Assert.assertEquals(votoEnBlanco, this.miBoleta.getCandidato());
    }
    
    @Test
    public void seObtieneElCentroDeComputoDeUnaDeterminadaProvincia()
    {
    	Assert.assertEquals(centroDeComputoDeBuenosAires, this.buenosAires.getCentroDeComputoProvincial());
    	Assert.assertEquals(centroDeComputoDeChubut, this.chubut.getCentroDeComputoProvincial());
    }
    
    @Test
    public void seCierraMesaDeVotacionYElCentroDeComputoProvincialRecibeLaUrna()
    {
    	Boleta miBoleta2 = new Boleta(this.juntaElectoral);
    	Boleta miBoleta3 = new Boleta(this.juntaElectoral);
    	this.miBoleta.setCandidato(fernando);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	miBoleta2.setCandidato(fernando);
    	this.mesaDeVotacion2.emitirVoto(miBoleta);
    	miBoleta3.setCandidato(pepe);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	this.mesaDeVotacion1.cerrarMesa();
    	this.mesaDeVotacion2.cerrarMesa();
    	Assert.assertEquals(true, this.centroDeComputoDeBuenosAires.getUrnasDeLaProvincia().contains(urnaDeMesa1));
    	Assert.assertEquals(true, this.centroDeComputoDeChubut.getUrnasDeLaProvincia().contains(urnaDeMesa2));
    }
    
    @Test
    public void seCierraMesaDeVotacionYElCentroDeComputoNacionalRecibeLaUrna()
    {
    	Boleta miBoleta2 = new Boleta(this.juntaElectoral);
    	Boleta miBoleta3 = new Boleta(this.juntaElectoral);
    	this.miBoleta.setCandidato(fernando);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	miBoleta2.setCandidato(fernando);
    	this.mesaDeVotacion2.emitirVoto(miBoleta2);
    	miBoleta3.setCandidato(pepe);
    	this.mesaDeVotacion1.emitirVoto(miBoleta3);
    	this.mesaDeVotacion1.cerrarMesa();
    	this.mesaDeVotacion2.cerrarMesa();
    	Assert.assertEquals(true, this.centroDeComputoNacional.getCentrosDeComputoProvinciales().get(0).getUrnasDeLaProvincia().contains(urnaDeMesa1));
    	Assert.assertEquals(true, this.centroDeComputoNacional.getCentrosDeComputoProvinciales().get(1).getUrnasDeLaProvincia().contains(urnaDeMesa2));
    }
    
    @Test
    public void candidatoConMasVotoANivelNacional()
    {
    	Boleta miBoleta2 = new Boleta(this.juntaElectoral);
    	Boleta miBoleta3 = new Boleta(this.juntaElectoral);
    	this.miBoleta.setCandidato(fernando);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	miBoleta2.setCandidato(fernando);
    	this.mesaDeVotacion2.emitirVoto(miBoleta2);
    	miBoleta3.setCandidato(pepe);
    	this.mesaDeVotacion1.emitirVoto(miBoleta3);
    	this.mesaDeVotacion1.cerrarMesa();
    	this.mesaDeVotacion2.cerrarMesa();
    	Assert.assertEquals(fernando, this.centroDeComputoNacional.getGanador());
    }
    
    @Test
    public void candidatoConMasVotoANivelNacional2()
    {
    	Boleta miBoleta2 = new Boleta(this.juntaElectoral);
    	Boleta miBoleta3 = new Boleta(this.juntaElectoral);
    	Boleta miBoleta4 = new Boleta(this.juntaElectoral);
    	Boleta miBoleta5 = new Boleta(this.juntaElectoral);
    	miBoleta4.setCandidato(pepe);
    	miBoleta5.setCandidato(pepe);
    	this.miBoleta.setCandidato(fernando);
    	this.mesaDeVotacion1.emitirVoto(miBoleta4);
    	this.mesaDeVotacion1.emitirVoto(miBoleta5);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	miBoleta2.setCandidato(fernando);
    	this.mesaDeVotacion2.emitirVoto(miBoleta2);
    	miBoleta3.setCandidato(pepe);
    	this.mesaDeVotacion1.emitirVoto(miBoleta3);
    	this.mesaDeVotacion1.cerrarMesa();
    	this.mesaDeVotacion2.cerrarMesa();
    	Assert.assertEquals(pepe, this.centroDeComputoNacional.getGanador());
    }
    
    @Test
    public void partidoConMasVotosANivelProvincia()
    {
    	this.miBoleta.setCandidato(fernando);
    	Boleta miBoleta2 = new Boleta(this.juntaElectoral);
    	miBoleta2.setCandidato(pepe);
    	Boleta miBoleta3 = new Boleta(this.juntaElectoral);
    	miBoleta3.setCandidato(matias);
    	Urna urnaDeMesa4 = new Urna();
    	MesaDeVotacion mesaDeVotacion4 = new MesaDeVotacion(buenosAires, urnaDeMesa4);
    	
    	this.mesaDeVotacion1.emitirVoto(miBoleta3);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	this.mesaDeVotacion2.emitirVoto(miBoleta2);//es de chubut esta mesa
    	this.mesaDeVotacion1.emitirVoto(miBoleta3);
        mesaDeVotacion4.emitirVoto(miBoleta);
        mesaDeVotacion4.emitirVoto(miBoleta);
        mesaDeVotacion4.emitirVoto(miBoleta3);
        mesaDeVotacion4.emitirVoto(miBoleta);
        this.mesaDeVotacion2.emitirVoto(miBoleta3);
        this.mesaDeVotacion2.emitirVoto(miBoleta3);
    	
    	this.mesaDeVotacion1.cerrarMesa();
    	this.mesaDeVotacion2.cerrarMesa();
    	mesaDeVotacion4.cerrarMesa();
    	Assert.assertEquals(frenteNorte, this.centroDeComputoDeBuenosAires.getPartidoGanador());
    	Assert.assertEquals(frenteUnido, this.centroDeComputoDeChubut.getPartidoGanador());
    }
    
    @Test
    public void alEmitirVariosVotosAlMismoCandidatoEnLaUrnaEstanLasNBoletas()
    {
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	this.mesaDeVotacion1.emitirVoto(miBoleta);
    	List<Boleta> boletas = this.mesaDeVotacion1.getUrna().getVotos();
    	for(int i=0; i<boletas.size(); i++)
    	{
    		Assert.assertEquals(miBoleta, boletas.get(i));
    	}
    }
}











