package ar.edu.untref.aydoo;

public class Candidato {

	private String nombre;
	private Partido miPartido;
	//para agregar voto en blanco se crea un candidato llamado votoEnBlanco, con un
	//nombre que sea: "En blanco"
	public Candidato(String nombre, Partido partido)
	{
		this.setNombre(nombre);
		this.setPartido(partido);
	}

	public void setPartido(Partido partido) {
		if(this.miPartido==null)
		{
			this.miPartido = partido;
			partido.agregarCandidato(this);
		} 
		else{
			this.miPartido.eliminarCandidato(this);
			this.miPartido = partido;
			partido.agregarCandidato(this);
		}
		
		
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() 
	{
		return this.nombre;
	}
	
	public Partido getPartido()
	{
		return this.miPartido;
	}
}
