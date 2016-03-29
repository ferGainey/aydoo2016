package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {
	
	private HacedorDeCafeConLeche miHacedorDeCafeConLeche;
	private Azucarero miAzucarero;
	private Vaso vaso;
	
	public MaquinaExpendedoraDeBebidas(){
		this.miHacedorDeCafeConLeche=new HacedorDeCafeConLeche();
		this.miAzucarero = new Azucarero();
		this.vaso = new Vaso();
	}
	
	public Vaso hacerCafeConLecheConNDeAzucar(int cantidadDeAzucar){
		this.vaso = this.miHacedorDeCafeConLeche.prepararEnEsteVaso(this.vaso);
		this.vaso = this.miAzucarero.ponerNEnEsteVaso(this.vaso, cantidadDeAzucar);
		return vaso;
	}
}
