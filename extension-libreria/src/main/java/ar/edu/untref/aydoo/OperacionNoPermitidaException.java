package ar.edu.untref.aydoo;

@SuppressWarnings("serial")
public class OperacionNoPermitidaException extends RuntimeException {

	public OperacionNoPermitidaException(String message){
		super(message);
	}
}
