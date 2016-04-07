package ar.edu.untref.aydoo;


public class Boleta 
{

	private JuntaElectoral juntaElectoral;
	private Candidato miCandidato;

	public Boleta(JuntaElectoral juntaElectoralActual)
	{
		this.juntaElectoral = juntaElectoralActual;
	}

	//si se quiere agregar la funcionalidad de voto en blanco se agrega un candidato
	//llamado votoEnBlanco, que debe ser creado con un nombre que sea "En blanco"
	public void setCandidato(Candidato candidato) 
	{
		if(this.juntaElectoral.getCandidatosAprobados().contains(candidato))
		{
			this.miCandidato = candidato;
		} else{
			System.out.println("El candidato no existe");
		}
	}

	public Candidato getCandidato() 
	{
		return this.miCandidato;
	}

}
