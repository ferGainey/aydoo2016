package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

public class Program 
{
	private int numero;
	ArrayList<Integer> listaDivisoresPrimos = new ArrayList<Integer>();
	
    public static final void main(String arg[])
    {	Program program = new Program();
    	program.run(arg);
    	
    }
    
    public void run(String[] arg){
    	int numeroRecibido = Integer.parseInt(arg[0]);
    	this.numero = numeroRecibido;
        //System.out.println(numero);
    	this.resolver(numero);
    	this.escribir();
    }
    
    public boolean esPrimo(int numero){
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
    
    	public void resolver(int numero){
    		
    		int numeroActual = numero;
    		int divisorCandidato = 2;
    		
    		while(esPrimo(numeroActual)==false){
    			if(numeroActual % divisorCandidato == 0){
    				numeroActual = numeroActual/divisorCandidato;
    				listaDivisoresPrimos.add(divisorCandidato);
    				//System.out.print(divisorCandidato + " ; ");
    			}
    			else{
    				divisorCandidato++;
    				while(esPrimo(divisorCandidato)==false){
    					divisorCandidato++;
    				}
    			}
    		}
    		listaDivisoresPrimos.add(numeroActual);
    		//System.out.print(numeroActual + " ");
    	}
    	
    	public void escribir(){
    		System.out.print("\nFactores Primos " + this.numero + ":  ");
    		Iterator<Integer> iterador = listaDivisoresPrimos.iterator();
    		while(iterador.hasNext()){
    			Integer numeroAEscribir = iterador.next();
    			System.out.print(numeroAEscribir);
    			if(iterador.hasNext()){
    				System.out.print(" ; ");
    			}else{
    				System.out.print("\n\n");
    			}
    		}
    	}
}
