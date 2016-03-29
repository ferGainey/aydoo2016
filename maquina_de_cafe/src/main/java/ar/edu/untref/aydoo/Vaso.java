package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Vaso {
	
	private List<String> contenido;
	
	public Vaso(){
		this.contenido=new LinkedList<String>();
	}
	
	public void agregarContenido(String ingrediente){
		this.contenido.add(ingrediente);
	}
	
	public void imprimirContenido(){
		Iterator<String> iterador = this.contenido.iterator();
		while(iterador.hasNext()){
			System.out.println(iterador.next());
		}
	}
		
	public List<String> getContenido(){
		return this.contenido;
	}

}
