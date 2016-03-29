package ar.edu.untref.aydoo;

public class HacedorDeCafeConLeche {

	private Lechero miLechero;
	private Cafetero miCafetero;
	
	public HacedorDeCafeConLeche(){
		this.miLechero = new Lechero();
		this.miCafetero = new Cafetero();
	}
	
	public Vaso prepararEnEsteVaso(Vaso vaso) {
		Vaso vasoActual = vaso;
		vasoActual = this.miCafetero.prepararEnEsteVaso(vasoActual);
		vasoActual = this.miLechero.prepararEnEsteVaso(vasoActual);
		return vasoActual;
	}

	
		
	
}
