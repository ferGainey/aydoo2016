package ar.edu.untref.aydoo;

public class MesaDeVotacion {

	private Provincia provincia;
	private Urna urna;
	
	public MesaDeVotacion(Provincia provincia, Urna urna)
	{
		this.setProvincia(provincia);
		this.setUrna(urna);
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Urna getUrna() {
		return urna;
	}

	public void setUrna(Urna urna) {
		this.urna = urna;
	}
}
