package ar.edu.untref.aydoo;

public class Compra {

	private Mes mes;
	private double monto;
	
	public Compra(Mes mes, double monto){
		this.setMes(mes);
		this.setMonto(monto);
	}
	
	public Mes getMes() {
		return mes;
	}
	private void setMes(Mes mes) {
		this.mes = mes;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
}
