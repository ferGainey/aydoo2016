package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {
	
	private HacedorDeCafeConLeche miHacedorDeCafeConLeche;
	private Azucarero miAzucarero;
	
	public MaquinaExpendedoraDeBebidas(){
		this.miHacedorDeCafeConLeche=new HacedorDeCafeConLeche();
		this.miAzucarero = new Azucarero();
	}
	
	public Vaso hacerCafeConLecheConNDeAzucar(Vaso vaso, int cantidadDeAzucar){
		Vaso vasoActual = vaso;
		vasoActual = this.miHacedorDeCafeConLeche.prepararEnEsteVaso(vasoActual);
		vasoActual = this.miAzucarero.ponerNEnEsteVaso(vasoActual, cantidadDeAzucar);
		return vasoActual;
	}
}
