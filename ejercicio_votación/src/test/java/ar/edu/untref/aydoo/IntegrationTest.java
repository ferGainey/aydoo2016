package ar.edu.untref.aydoo;

import org.junit.Test;
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
}











