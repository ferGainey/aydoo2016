package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class CalculadorDeFactoresPrimos {

	private ArrayList<Integer> listaDivisoresPrimos = new ArrayList<Integer>();

	public void resolver(int numero){
		int numeroActual = numero;
		int divisorCandidato = 2;
		while(esPrimo(numeroActual)==false){
			if(numeroActual % divisorCandidato == 0){
				numeroActual = numeroActual/divisorCandidato;
				listaDivisoresPrimos.add(divisorCandidato);
			}
			else{
				divisorCandidato++;
				while(esPrimo(divisorCandidato)==false){
					divisorCandidato++;
				}
			}
		}
		listaDivisoresPrimos.add(numeroActual);
	}

	//se aplican una serie de algoritmos para reducir comparaciones
	private boolean esPrimo(int numero){
		if(numero == 1 || numero == 2|| numero==3){
			return true;
		} else{
			if(numero % 2 == 0){
				return false;
			} else {
				double maximoAprox = Math.round(Math.sqrt(numero));
				int maximo = (int) maximoAprox;
				for(int i=3; i<=maximo; i++){
					if(numero % i == 0){
						return false;
					}
					i++;
				}
				return true;
			}
		}
	}

	/*
	 * @pre: se necesita haber aplicado el metodo resolver para tener una lista
	 * de factores primos
	 * @post: devuelve la lista de factores primos
	 */
	public ArrayList<Integer> getListaDeDivisoresPrimos(){
		return this.listaDivisoresPrimos;
	}
}
