package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Program 
{
	private int numero;
	private String formato;
	private int tipoDeFormato;
	ArrayList<Integer> listaDivisoresPrimos = new ArrayList<Integer>();

	public static final void main(String arg[])
	{	Program program = new Program();
	program.run(arg);
	}

	public void run(String[] arg){
		int numeroRecibido = Integer.parseInt(arg[0]);
		this.numero = numeroRecibido;
		if(arg[1]!=null){this.setFormato((String) arg[1]);}
		this.resolver(numero);
		this.leer();
		this.escribir(tipoDeFormato);
	}

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

	private void resolver(int numero){

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

	// El parametro que se recibe es el numero correspondiente al tipo de 
	//formato con el que se va a escribir
	//Formato #1 es pretty. Formato #2 es quiet Formato #3 formato invalido
	private void escribir(int tipo){
		switch(tipo){

		case 1:
			System.out.print("Factores Primos " + this.numero + ": ");
			Iterator<Integer> iterador = listaDivisoresPrimos.iterator();
			while(iterador.hasNext()){
				Integer numeroAEscribir = iterador.next();
				System.out.print(numeroAEscribir);
				System.out.print(" ");
				if(!(iterador.hasNext())){
					System.out.print("\n\n");	
				}
			}
			break;

		case 2:
			ArrayList<Integer> listaDivisoresPrimosInvertidos = this.invertirLista(listaDivisoresPrimos);
			Iterator<Integer> iterador2 = listaDivisoresPrimosInvertidos.iterator();
			while(iterador2.hasNext()){
				Integer numeroAEscribir = iterador2.next();
				System.out.print(numeroAEscribir);
				System.out.print("\n");
				if(!(iterador2.hasNext())){
					System.out.print("\n\n");	
				}
			}
			break;

		case 3:
			System.out.print("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
			break;
		default: 
			break;
		}
	}

	private void leer(){
		String[] palabraRecibida = this.separarPalabra(this.getFormato());
		if((palabraRecibida.length)!=2){
			this.tipoDeFormato=1;
			return;
		}
		String palabraFormat=palabraRecibida[0];
		String palabraTipoDeFormato=palabraRecibida[1];
		if(!(palabraFormat.equals("--format"))){
			this.tipoDeFormato=1;
			return;
		}
		String formatoActual = palabraTipoDeFormato.toLowerCase();

		if(formatoActual.equals("pretty")){this.tipoDeFormato=1;}
		if(formatoActual.equals("quiet")){this.tipoDeFormato=2;}
		if(!(formatoActual.equals("pretty")) && !(formatoActual.equals("quiet"))){this.tipoDeFormato=3;}
	}

	private String[] separarPalabra(String palabra) {
		String palabraRecibida = palabra;
		String delimitador= "=";
		String[] palabrasSeparadas = palabraRecibida.split(delimitador);
		return palabrasSeparadas;
	}

	private ArrayList<Integer> invertirLista(ArrayList<Integer> lista){
		Iterator<Integer> iterador = lista.iterator();
		int tamanioLista = lista.size();
		Integer[] listaInvertida = new Integer[tamanioLista];
		for(int i = 0; i<tamanioLista; i++){
			listaInvertida[(tamanioLista-1)-i]=iterador.next();
		}
		ArrayList<Integer> listaADevolver = new ArrayList<Integer>(Arrays.asList(listaInvertida));
		return listaADevolver;
	}

	private int getTipoDeFormato(){
		return this.tipoDeFormato;
	}

	private void setFormato(String formato){
		this.formato=formato;
	}

	private String getFormato(){
		return this.formato;
	}
}
