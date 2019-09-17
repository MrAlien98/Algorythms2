package modelo;

public class Nodo {

	private int valor;
	private Nodo siguiente;
	private Nodo anterior;
	
	public Nodo(int valor) {
		this.valor=valor;
		siguiente=null;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor=valor;
	}
	
	public void setSiguiente(Nodo siguiente) {
		this.siguiente=siguiente;
	}
	
	public Nodo getSiguiente() {
		return siguiente;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
}
