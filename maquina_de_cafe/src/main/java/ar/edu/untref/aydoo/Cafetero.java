package ar.edu.untref.aydoo;

public class Cafetero {

	public Vaso prepararEnEsteVaso(Vaso vaso) {
		Vaso vasoActual = vaso;
		vasoActual.agregarContenido("cafe");
		return vasoActual;
	}

}
