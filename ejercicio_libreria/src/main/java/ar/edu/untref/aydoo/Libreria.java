package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Libreria {

	private List<Cliente> registroDeClientes = new LinkedList<Cliente>();
	
	public void agregarCliente(Cliente cliente){
		this.registroDeClientes.add(cliente);
	}
	
	public List<Cliente> getRegistroDeClientes(){
		return this.registroDeClientes;
	}
}
