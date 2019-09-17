package modelo;

public class Jugador {
	
	private String imagen;
	private String nombre;
	private String posicion;
	private String fechaNacimiento;
	
	private double puntajeFifa;
	private double altura;
	
	private Jugador siguiente;
	private Jugador anterior;
	
	
	//Constructor para cuando aun no hay nodos
	public Jugador(String imagen, String nombre, String posicion, double puntajeFifa, String fechaNacimiento, double altura) {
		this(imagen, nombre, posicion, puntajeFifa, fechaNacimiento, altura, null, null);
	}
	
	//Constructor para cuando ya hay nodos
	public Jugador(String imagen, String nombre, String posicion, double puntajeFifa, String fechaNacimiento, double altura, Jugador siguiente, Jugador anterior) {
		this.imagen=imagen;
		this.nombre=nombre;
		this.posicion=posicion;
		this.puntajeFifa=puntajeFifa;
		this.fechaNacimiento=fechaNacimiento;
		this.altura=altura;
		
		this.siguiente=siguiente;
		this.anterior=anterior;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void enlazarSiguiente(Jugador n) {
		siguiente=n;
	}
	
	public void enlazarAnterior(Jugador n) {
		anterior=n;
	}
	
	public Jugador obtenerAnterior() {
		return anterior;
	}
	
	public Jugador obtenerSiguiente() {
		return siguiente;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPosicion() {
		return posicion;
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public double getPuntajeFifa() {
		return puntajeFifa;
	}
	
	public void setPuntajeFifa(double puntajeFifa) {
		this.puntajeFifa = puntajeFifa;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	

}
