package modelo;

public class Seleccion{
	
	private String nombre;
	private String imagen;
	
	private int puntos;
	
	private double promedioAltura;
	private double promedioEdad;
	private double promedioFIFA;
	
	private Jugador raiz;
	
	private Seleccion derecho;
	private Seleccion izquierdo;
	private Vector v;
	
	public Seleccion(String nombre, int puntos,String imagen) {
		this.nombre = nombre;
		this.puntos = puntos;
		this.imagen = imagen;
		
		Vector v=new Vector();
		
		promedioAltura=0.0;
		promedioEdad=0.0;
		promedioFIFA=0.0;
				
		raiz=null;
		derecho=null;
		izquierdo=null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public Jugador getRaiz() {
		return raiz;
	}

	public void setRaiz(Jugador raiz) {
		this.raiz = raiz;
	}

	public Seleccion getDerecho() {
		return derecho;
	}

	public void setDerecho(Seleccion derecho) {
		this.derecho = derecho;
	}

	public Seleccion getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Seleccion izquierdo) {
		this.izquierdo = izquierdo;
	}
	
	 public void insertarNodo(Jugador insertar){
		 if(raiz == null) {
			 raiz=insertar; //crea nodo raiz
		 }else {
			 raiz.insertar(insertar); //llama al metodo insertar
		 }
	 }
	  
	 public void insertar(Seleccion insertar){
		 if(insertar.getPromedioFIFA() < this.getPromedioFIFA()){
			 if(izquierdo == null) {
	           	izquierdo=insertar;
	         }else {
	           	izquierdo.insertar(insertar);
	         }
		 }else if(insertar.getPromedioFIFA() > this.getPromedioFIFA()){
			 if(derecho==null) {
				 derecho=insertar;
			 }else {
				 derecho.insertar(insertar);
			 }
		 }
	 }

	 
//	 public void arrgelo() {
//		 v=raiz.preOrden(raiz, v);
//	 }
	
	
}
