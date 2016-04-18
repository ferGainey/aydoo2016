package ar.edu.untref.aydoo;

public class Program 
{
	private CalculadorDeFactoresPrimos miCalculador;
	private LogicaDeFormato miLogicaDeFormato;

	public static final void main(String arg[])
	{	Program program = new Program();
	program.run(arg);
	}

	public void run(String[] arg){
		int numeroRecibido = Integer.parseInt(arg[0]);
		String mensajeRecibido = "";
		for(int i = 0; i < arg.length; i++){
			mensajeRecibido += arg[i];
			mensajeRecibido += " ";
		}
		this.miLogicaDeFormato = new LogicaDeFormato(mensajeRecibido);
		this.miLogicaDeFormato.interpretarFormato();
		this.miLogicaDeFormato.interpretarOrden();
		this.miLogicaDeFormato.interpretarTipoDeEscritura();
		this.miCalculador = new CalculadorDeFactoresPrimos();
		this.miCalculador.resolver(numeroRecibido);
		Impresora miImpresora = new Impresora(this.miLogicaDeFormato.getTipoDeFormato(), this.miLogicaDeFormato.getOrden(), this.miLogicaDeFormato.getEscrituraEnArchivo(), this.miCalculador.getListaDeDivisoresPrimos());
		miImpresora.imprimir(numeroRecibido);
	}


}
