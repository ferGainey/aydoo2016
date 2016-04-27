package ar.edu.untref.aydoo;

import java.util.HashMap;

public class AlquilerDeLibro {

	private Cliente cliente;
	private Libro libro;
	private String mes;
	private String[] meses;
	private HashMap<String, Double> dineroAPagarEnDeterminadoMes;

	public AlquilerDeLibro(Cliente cliente, Libro libro, String mes){
		this.cliente = cliente;
		this.libro = libro;
		this.mes = mes.toLowerCase(); //el mes se pasa a minuscula para usarlo luego en la comparacion
		/*
		 * se agregan 14 meses (2 repetidos) para simplificar el algoritmo, ya que si no habría que estar, viendo que hacer si el
		 * prestamo se saca en diciembre por ejemplo, ya que deberiamos de alguna forma volver a la posicion
		 * cero, lo que le agregaria bastante complejidad a la lectura del codigo. De este forma se contempla
		 * el peor de los casos que es que se pida un prestamo por tres meses en diciembre
		 */
		this.meses = new String[12]; 
		this.meses[0] = "enero";
		this.meses[1] = "febrero";
		this.meses[2] = "marzo";
		this.meses[3] = "abril";
		this.meses[4] = "mayo";
		this.meses[5] = "junio";
		this.meses[6] = "julio";
		this.meses[7] = "agosto";
		this.meses[8] = "septiembre";
		this.meses[9] = "octubre";
		this.meses[10] = "noviembre";
		this.meses[11] = "diciembre";
		this.dineroAPagarEnDeterminadoMes = new HashMap<String, Double>();
	}

	/*
	 *@pre: el alquiler empieza en un mes y termina en ese mes.
	 *@param: la cantidad minima de dias es 3 y maxima 25 
	 */
	public void alquilarDiario(int cantidadDeDias){
		if(cantidadDeDias >= 3 && cantidadDeDias <=25){
			double cantidadAPagar = cantidadDeDias * 10; //el alquiler cuesta $10
			this.dineroAPagarEnDeterminadoMes.put(this.mes, cantidadAPagar);
		}
		else{
			throw new CantidadIncorrectaException("La cantidad minima de dias de alquiler es 3 y la maxima 25");
		}
	}

	/*
	 * @param: la cantidad minima de meses es 1 y la maxima 3
	 */
	public void alquilarMensual(int cantidadDeMeses){
		if(1 <= cantidadDeMeses && 3 >= cantidadDeMeses){
			double cantidadAPagar = 200;
			int posicionDelMes = -1;
			for(int i = 0; i < this.meses.length; i++){
				if(this.mes.equals(this.meses[i])){
					posicionDelMes = i;
					i = this.meses.length;
				}
			}
			for(int i = 0; i < cantidadDeMeses; i++){
				if((posicionDelMes + i) >= 12){
					throw new OperacionNoPermitidaException("Los prestamos mensuales no pueden pasar del mes de diciembre"); //esto es para que no se mezclen los meses de distintos anios
				}
				String mesActual = this.meses[posicionDelMes + i];
				this.dineroAPagarEnDeterminadoMes.put(mesActual, cantidadAPagar);
			}
		}
		else{
			throw new CantidadIncorrectaException("La cantidad minima de meses de alquiler es 1 y la maxima 3");
		}
	}

	/*
	 * @post: se acredita todo el pago junto en el mes que se efectua el alquiler para este caso
	 * @param: se indica si el alquiler es por uno o dos cuatrimestres. Las opciones permitidas son 1 o 2
	 */
	public void alquilarCuatrimestral(int cantidadDeCuatrimestres){
		if(cantidadDeCuatrimestres >=1 && cantidadDeCuatrimestres <=2){
			double cantidadAPagar = (200 * (4 * cantidadDeCuatrimestres) * 0.9);
			this.dineroAPagarEnDeterminadoMes.put(this.mes, cantidadAPagar);
		}
		else{
			throw new CantidadIncorrectaException("La cantidad minima de cuatrimestres de alquiler es 1 y la maxima 2");
		}
	}

	public HashMap<String, Double> getDineroAPagarEnDeterminadoMes(){
		return this.dineroAPagarEnDeterminadoMes;
	}

	public Cliente getCliente(){
		return this.cliente;
	}

	public Libro getLibro(){
		return this.libro;
	}
	
}
