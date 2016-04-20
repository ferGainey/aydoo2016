package ar.edu.untref.aydoo;

public class LogicaDeFormato {

	private String[] palabraSeparada;
	private String tipoDeFormato = "pretty";
	private String orden = "asc";
	private String escrituraEnArchivo = "no";

	public LogicaDeFormato(String palabraRecibida){
		this.palabraSeparada = this.separarPalabra(palabraRecibida);
	}

	private String[] separarPalabra(String palabra) {
		String palabraRecibida = palabra;
		String delimitador= " ";
		String[] palabrasSeparadas = palabraRecibida.split(delimitador);
		return palabrasSeparadas;
	}

	/*
	 * post: interpreta el tipo de formato que se recibe (que esta en palabraSeparada). Ve si es pretty, quiet
	 * o formato no aceptado. Por defecto es pretty
	 */
	public void interpretarFormato(){
		String[] palabras = this.getPalabraSeparada();
		for(int i = 0; i<palabras.length; i++){
			if(palabras[i].contains("--format")){
				String[] partesDeLaPalabra = palabras[i].split("=");
				String palabra1 = partesDeLaPalabra[0];
				String palabra2 = partesDeLaPalabra[1];
				if(palabra1.equals("--format") && palabra2.toLowerCase().equals("pretty")){
					this.setFormatoPretty();
					return;
				}
				else if(palabra1.equals("--format") && palabra2.toLowerCase().equals("quiet")){
					this.setFormatoQuiet();
					return;
				}

				else if(palabra1.equals("--format") && !(palabra2.toLowerCase().equals("pretty") || palabra2.toLowerCase().equals("quiet"))){
					this.setFormatoNoAceptado();
				}
			}
		}

	}

	private void setFormatoNoAceptado() {
		this.tipoDeFormato = "formato no aceptado";
	}

	private void setFormatoPretty() {
		this.tipoDeFormato = "pretty";
	}

	private void setFormatoQuiet() {
		this.tipoDeFormato = "quiet";
	}

	private String[] getPalabraSeparada() {
		return palabraSeparada;
	}

	/*
	 * @post: devuelve el tipo de formato: pretty o quiet
	 */
	public String getTipoDeFormato() {
		return tipoDeFormato;
	}

	/*
	 * @post: interpreta el tipo de orden que se ingreso si es asc o des. Si no se indica, por defecto es asc.
	 */
	public void interpretarOrden(){
		String[] palabras = this.getPalabraSeparada();
		for(int i = 0; i<palabras.length; i++){
			if(palabras[i].equals("--sort:asc")){
				this.setOrdenAscendente();
				return;
			}
			else if(palabras[i].equals("--sort:des")){
				this.setOrdenDescendente();
				return;
			}
		}
	}

	private void setOrdenDescendente() {
		this.orden = "des";
	}

	private void setOrdenAscendente() {
		this.orden = "asc";
	}
	
	/*
	 * @post: devuelve el tipo de orden: "asc" o "des". Por defecto esta puesto "asc" (ascendente)
	 */
	public String getOrden(){
		return this.orden;
	}

	/*
	 * @post: interpreta si se va a escribir en archivo o consola. En caso de que sea por archivo, toma el 
	 * nombre del archivo y se lo guarda en un atributo. Por defecto es por consola
	 */
	public void interpretarTipoDeEscritura(){
		String[] palabras = this.getPalabraSeparada();
		for(int i = 0; i<palabras.length; i++){
			if(palabras[i].contains("--output-file=")){
				String[] partesDeLaPalabra = palabras[i].split("=");
				String nombreDeArchivo = partesDeLaPalabra[1];
				this.setEscrituraEnArchivo(nombreDeArchivo);
				return;
			}
		}
	}
	
	private void setEscrituraEnArchivo(String nombreDeArchivo) {
		this.escrituraEnArchivo = nombreDeArchivo;
	}

	/*
	 * @pre: se ejecuto el metodo interpretarTipoDeEscritura
	 * @post:devuelve el nombre del archivo si se especifico que escriba en un archivo y "no" si no se pidio eso
	 */
	public String getEscrituraEnArchivo(){
		return this.escrituraEnArchivo;
	}

}
