package modelo;

public class Seleccion {

	private String nombre;
	private String imagen;
	
	private int puntos;
	private int size;
	
	private double promedioAltura;
	private double promedioEdad;
	private double promedioFIFA;
	
	private Jugador cabeza;
	private Jugador cola;
	
	private Seleccion siguiente; 
	
	public Seleccion(String nombre, int puntos,String imagen) {
		this.nombre = nombre;
		this.puntos = puntos;
		this.imagen = imagen;
		
		promedioAltura=0.0;
		promedioEdad=0.0;
		promedioFIFA=0.0;
		
		size=0;
		
		cabeza=null;
		cola=null;
		siguiente=null;
	}
	
	
	//Metodo para saer cuando la lista esta vacia
	public boolean estaVacia() {
		return (cabeza==null);
	}
	
	public void add(Jugador primero) {
		if(estaVacia()) {
			cabeza=primero;
		}else {
			Jugador temp=cabeza;
			while(temp.obtenerSiguiente()!=null) {
				temp=temp.obtenerSiguiente();
			}
			temp.enlazarSiguiente(primero);
			primero.enlazarAnterior(temp);
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public Jugador[] toArray() {
		Jugador[]nombres=new Jugador[size()];
		int i=0;
		Jugador temp=cabeza;
		while(temp!=null) {
			nombres[i]=temp;
			temp=temp.obtenerSiguiente();
			i++;
		}
		return nombres;
	}
	
	public double calcularPromedioEdad() {
		double promedio= 0.0;
		
		return promedio;
	}
	
	public double calcularPromedioAltura() {
		double promedio= 0.0;
		
		return promedio;
	}
	
	public void enlazarSiguiente(Seleccion siguiente) {
		this.siguiente=siguiente;
	}
	
	public Seleccion obtenerSiguiente() {
		return siguiente;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public double getPromedioAltura() {
		return promedioAltura;
	}

	public void setPromedioAltura(double promedioAltura) {
		this.promedioAltura = promedioAltura;
	}

	public double getPromedioEdad() {
		return promedioEdad;
	}

	public void setPromedioEdad(double promedioEdad) {
		this.promedioEdad = promedioEdad;
	}

	public double getPromedioFIFA() {
		return promedioFIFA;
	}

	public void setPromedioFIFA(double promedioFIFA) {
		this.promedioFIFA = promedioFIFA;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	
}
