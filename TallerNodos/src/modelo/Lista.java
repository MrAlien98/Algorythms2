package modelo;

public class Lista {

	private Nodo cabeza;
	private int size;
	
	public Lista() {
		cabeza=null;
		size=0;
		
		agregarOrdenado(2);
		agregarOrdenado(1);
		
	}
	
	public void agregarOrdenado(int obj) {
		Nodo nuevo = new Nodo(obj);
		Nodo actual = cabeza;
		if(cabeza==null) {
			cabeza=nuevo;
		}else if(obj<actual.getValor()) {
			nuevo.setSiguiente(cabeza);
			cabeza=nuevo;
		}else {
			while(actual.getValor()<nuevo.getValor() && actual.getSiguiente()!=null){
				actual = actual.getSiguiente();
			}if(actual.getSiguiente()==null) {
				actual.setSiguiente(nuevo);
				nuevo.setAnterior(actual);
			}else {
				nuevo.setSiguiente(actual);
				actual.getAnterior().setSiguiente(nuevo);
			}
		}
	}
	
	public void agregarNodoEnOrden(int num) {
		
		Nodo nuevo = new Nodo(num);
		Nodo actual = cabeza;
		
		if(num < actual.getValor()) {
			
			nuevo.setSiguiente(cabeza);
			cabeza = nuevo;
		}
		else {
			
			while(actual.getValor() < nuevo.getValor()&&actual.getSiguiente()!=null){
				
				actual = actual.getSiguiente();
			}
			if(actual.getSiguiente()==null) {
				actual.setSiguiente(nuevo);
				nuevo.setAnterior(actual);
			}else {
				nuevo.setSiguiente(actual);
				actual.getAnterior().setSiguiente(nuevo);
			}
		}
	}
	
	public String listar() {
		String nel="";
		Nodo ajam=cabeza;
		while(ajam.getSiguiente()!=null) {
			nel+=ajam.getValor()+" ";
			ajam=ajam.getSiguiente();
		}
		return nel;
	}
	
	public Nodo darCabeza() {
		return cabeza;
	}
	
	public void setCabeza(Nodo cabeza) {
		this.cabeza=cabeza;
	}
	
	public void eliminarcabeza() {
		cabeza=cabeza.getSiguiente();
		size--;
	}
	
	public void eliminar(int index) { 
		if(index==0) {
			cabeza=cabeza.getSiguiente();
		}else {
			int contador=0;
			Nodo temporal=cabeza;
			while(contador<index-1) {
				temporal=temporal.getSiguiente();
				contador++;
			}
			temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
		}
		size--;
	}
	
	public Nodo obtener(int index) {
		int contador=0;
		Nodo temporal=cabeza;
		while(contador<index) {
			temporal=temporal.getSiguiente();
			contador++;
		}
		return temporal;
	}
	
	public int size() {
		return size;
	}
	
	public void setSize(int size) {
		this.size=size;
	}
	
	public boolean estaVacia() {
		return (cabeza==null)?true:false;
	}
	
	public String imPares(Lista lista) {
		int contador=0;
		String imPares="";
		Nodo temporal=lista.darCabeza();
		while(contador<lista.size()) {
			if(temporal.getValor()%2!=0) {
				imPares+=Integer.toString((int)temporal.getValor())+" ";
			}
			temporal=temporal.getSiguiente();
			contador++;
		}
		return imPares;
	}
	
	
	
}
