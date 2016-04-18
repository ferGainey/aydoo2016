package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Impresora {

	private String formato;
	private String orden;
	private String nombreDeArchivo;
	private ArrayList<Integer> listaDivisoresPrimos;

	public Impresora(String formato, String orden, String nombreDeArchivo, ArrayList<Integer> listaDivisoresPrimos){
		this.formato = formato;
		this.orden = orden;
		this.nombreDeArchivo = nombreDeArchivo;
		this.listaDivisoresPrimos = listaDivisoresPrimos;
	}

	public ArrayList<Integer> getListaDivisoresPrimos(){
		return this.listaDivisoresPrimos;
	}

	public void imprimir(int numero){
		String impresion = "";
		if(this.formato.equals("pretty")){
			impresion += ("Factores Primos "); 
			impresion += Integer.toString(numero);
			impresion += ": ";
			this.aplicarOrden();
			Iterator<Integer> iterador = this.listaDivisoresPrimos.iterator();
			while(iterador.hasNext()){
				Integer numeroAEscribir = iterador.next();
				impresion += Integer.toString(numeroAEscribir);
				impresion += " ";
				if(!(iterador.hasNext())){
					impresion += "\n\n";	
				}
			}
			this.escribir(impresion);
			return;
		}

		if(this.formato.equals("quiet")){
			this.aplicarOrden();
			Iterator<Integer> iterador2 = this.listaDivisoresPrimos.iterator();
			while(iterador2.hasNext()){
				Integer numeroAEscribir = iterador2.next();
				impresion += Integer.toString(numeroAEscribir);
				impresion += "\n";
				if(!(iterador2.hasNext())){
					impresion += "\n\n";	
				}
			}
			this.escribir(impresion);
			return;
		}

		if(this.equals("formato no aceptado")){
			impresion += "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
			this.escribir(impresion);
			return;
		}
	}

	private void escribir(String impresion) {
		if(this.nombreDeArchivo.equals("no")){
			System.out.print(impresion);
		}
		else{
			this.escrituraEnArchivo(impresion);
		}

	}

	private void escrituraEnArchivo(String impresion) {
		File f;
		f = new File(this.nombreDeArchivo);
		//Escritura
		try{
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);  
			wr.write(impresion);//escribimos en el archivo
			//ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
			//de no hacerlo no se escribirá nada en el archivo
			wr.close();
			bw.close();
		}catch(IOException e){};

	}



	private void aplicarOrden() {
		if(this.orden.equals("des")){
			this.listaDivisoresPrimos = this.invertirLista(this.listaDivisoresPrimos);
			return;
		}
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


}
