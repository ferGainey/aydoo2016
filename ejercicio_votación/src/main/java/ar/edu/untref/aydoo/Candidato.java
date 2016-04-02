package ar.edu.untref.aydoo;

public class Candidato {

	private String nombre;
	private Partido partido;
	
	public Candidato(String nombre, Partido partido)
	{
		this.setNombre(nombre);
		this.setPartido(partido);
	}

	private void setPartido(Partido partido) {
		this.partido = partido;
		
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
