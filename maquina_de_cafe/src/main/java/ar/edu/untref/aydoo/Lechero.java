package ar.edu.untref.aydoo;

public class Lechero {

	public Vaso prepararEnEsteVaso(Vaso vaso) {
		Vaso vasoActual = vaso;
		vasoActual.agregarContenido("leche");
		return vasoActual;
	}

}
