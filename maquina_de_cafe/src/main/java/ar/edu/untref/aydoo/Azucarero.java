package ar.edu.untref.aydoo;

public class Azucarero {

	public Vaso ponerNEnEsteVaso(Vaso vaso, int cantidadDeAzucar) {
		Vaso vasoActual = vaso;
		for(int i=0; i<cantidadDeAzucar; i++){
			vasoActual.agregarContenido("azucar");
		}
		return vasoActual;
	}

}
