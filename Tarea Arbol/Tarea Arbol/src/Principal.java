
public class Principal {

	private static Arbol abb;
	
	public Principal() {
		abb=new Arbol();
	}
	
	public static Arbol getArbol() {
		return abb;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Principal main=new Principal();
		
		abb.add(abb.getRoot(), new Nodo(8));
		abb.add(abb.getRoot(), new Nodo(4));
		abb.add(abb.getRoot(), new Nodo(10));
		abb.add(abb.getRoot(), new Nodo(1));
		abb.add(abb.getRoot(), new Nodo(2));
		abb.add(abb.getRoot(), new Nodo(9));
		abb.add(abb.getRoot(), new Nodo(12));
		abb.add(abb.getRoot(), new Nodo(20));
		abb.add(abb.getRoot(), new Nodo(30));
		abb.add(abb.getRoot(), new Nodo(14));
		abb.add(abb.getRoot(), new Nodo(16));
		abb.add(abb.getRoot(), new Nodo(13));
		abb.add(abb.getRoot(), new Nodo(15));
		
		System.out.println("Total Nodos: "+abb.contarNodos());
		System.out.println("Total Hojas: "+abb.cantidadNodosHoja());
	}

}
