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

	public String[] getPalabraSeparada() {
		return palabraSeparada;
	}

	public String getTipoDeFormato() {
		return tipoDeFormato;
	}

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

	public String getOrden(){
		return this.orden;
	}

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

	public String getEscrituraEnArchivo(){
		return this.escrituraEnArchivo;
	}

}
