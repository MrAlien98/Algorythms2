public class Arbol {

	private Nodo root;
	private int cant;
	
	public Arbol() {
		root=null;
	}
	
	public Nodo getRoot() {
		return root;
	}
	
	public void eliminar(Nodo eliminar) {
		Nodo aEliminar = buscar(root, eliminar.getC());
		root = root.eliminar(aEliminar.getC());
	}
	
	public Nodo buscar(Nodo actual, long c) {
		if(actual.getC()==c) {
			return actual;
		}else {
			if(c<actual.getC()) {
				if(actual.getI()!=null) {
					return buscar(actual.getI(), c);
				}else {
					return null;
				}
			}else {
				if(actual.getD()!=null) {
					return buscar(actual.getD(), c);
				}else {
					return null;
				}
			}
		}
	}
	
	public void add(Nodo actual, Nodo nuevo) {
		if(root==null) {
			root=nuevo;
		}else {
			if(nuevo.getC()<=actual.getC()) {
				if(actual.getI()==null) {
					actual.setI(nuevo);
				}else {
					add(actual.getI(), nuevo);
				}
			}else {
				if(actual.getD()==null) {
					actual.setD(nuevo);
				}else {
					add(actual.getD(), nuevo);
				}
			}
		}
	}
	
	public int contarNodos() {
		cant = 0;
		cantidad(root);
		return cant;
	}

	private void cantidad(Nodo a) {
		if (a != null) {
			cant++;
			cantidad(a.getI());
			cantidad(a.getD());
		}
	}
	
    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(root);
        return cant+1;
    }
	
	private void cantidadNodosHoja(Nodo a) {
		if (a != null) {
			if (a.isHoja()) {
				cant++;
			}
			cantidadNodosHoja(a.getI());
			cantidadNodosHoja(a.getD());
        }
    }
	
}
