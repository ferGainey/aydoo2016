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
	private Partido frenteNorte;
	private Partido frenteSur;
	private Partido frenteUnido;
	private JuntaElectoral juntaElectoral;
	
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
		this.juntaElectoral = new JuntaElectoral();
		this.juntaElectoral.agregarCandidatoAprobado(this.pepe);
		this.juntaElectoral.agregarCandidatoAprobado(this.jose);
		this.juntaElectoral.agregarCandidatoAprobado(this.fernando);
		this.juntaElectoral.agregarCandidatoAprobado(this.javier);
		this.juntaElectoral.agregarCandidatoAprobado(this.matias);
		this.juntaElectoral.agregarCandidatoAprobado(this.cosme);
		this.miBoleta = new Boleta(this.juntaElectoral);
		
		
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
}
