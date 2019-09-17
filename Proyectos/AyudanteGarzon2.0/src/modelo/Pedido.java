package modelo;

import java.util.ArrayList;

public class Pedido {

	private ArrayList<String> pedido;
	
	public Pedido() {
		setPedido(new ArrayList<>());
	}

	public ArrayList<String> getPedido() {
		return pedido;
	}

	public void setPedido(ArrayList<String> pedido) {
		this.pedido = pedido;
	}
	
	
	
}
