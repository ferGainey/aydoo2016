package ar.edu.untref.aydoo;

public class MesaDeVotacion {

	private Provincia provincia;
	
	public MesaDeVotacion(Provincia provincia)
	{
		this.setProvincia(provincia);
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
