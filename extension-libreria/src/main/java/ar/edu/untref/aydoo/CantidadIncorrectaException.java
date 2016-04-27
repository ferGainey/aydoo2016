package ar.edu.untref.aydoo;

@SuppressWarnings("serial")
public class CantidadIncorrectaException extends RuntimeException {

	public CantidadIncorrectaException(String mensaje) {
		super(mensaje);
	}
}
