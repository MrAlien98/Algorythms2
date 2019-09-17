package modelo;

public class Paquete {

	public Lista lista;
	
	public Paquete() {
		lista=new Lista();
	}
	
	public Lista darImpares() {
		Lista list=new Lista();
		int contador=0;
		while(contador<lista.size()) {
			Nodo actual=lista.obtener(contador);
			if(actual.getValor()%2!=0) {
				list.agregarOrdenado(actual.getValor());
			}
			contador++;
			list.setSize(contador);
		}
		return list;
	}
	
}
