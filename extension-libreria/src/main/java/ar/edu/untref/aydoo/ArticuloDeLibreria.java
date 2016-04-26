package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto{

	public ArticuloDeLibreria(double precio) {
		super(precio);
	}

	@Override
	public double getPrecio(){
		return (super.getPrecio()*1.21);
	}

}
