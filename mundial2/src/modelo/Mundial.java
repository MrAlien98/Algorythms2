package modelo;

public class Mundial {

	private Seleccion cabeza;
	
	private int size;
	
	public Mundial() {
		cabeza=null;
		size=0;
	}

	public void add(String p, int ptos, String img) {
		if(cabeza==null) {
			cabeza=new Seleccion(p, ptos, img);
		}else {
			Seleccion nueva=new Seleccion(p, ptos, img);
			Seleccion temp=cabeza;
			while(temp.obtenerSiguiente()!=null) {
				temp=temp.obtenerSiguiente();
			}
			temp.enlazarSiguiente(nueva);
		}
		size++;	
	}
	
	public Seleccion darCabeza() {
		return cabeza;
	}
	
	public void setCabeza(Seleccion cabeza) {
		this.cabeza=cabeza;
	}
	
	public void eliminar(int index) { 
        if(index==0) {
            cabeza=cabeza.obtenerSiguiente();
        }else {
            int contador=0;
            Seleccion temporal=cabeza;
            while(contador<index-1) {
                temporal=temporal.obtenerSiguiente();
                contador++;
            }
            temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
        }
        size--;
    }
	
	public Seleccion obtener(int index) {
        int contador=0;
        Seleccion temporal=cabeza;
        while(contador<index) {
            temporal=temporal.obtenerSiguiente();
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
    
    public Seleccion[] toArray() {
		int contador=0;
		for(Seleccion c=cabeza;c!=null;c=c.obtenerSiguiente()) {
			contador++;
		}
		Seleccion[] nombres=new Seleccion[contador];
		int i=0;
		Seleccion temp = cabeza;
		while(temp!=null) {
			nombres[i]=temp;
			temp = temp.obtenerSiguiente();
			i++;
		}
		return nombres;
	}
    
	
}