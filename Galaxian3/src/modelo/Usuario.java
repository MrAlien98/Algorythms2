package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable{

	private Nave personal;
	
	private String nick;
	
	private int puntaje;
	private int nivel;
	private int vidas;
	
	private Usuario siguiente;
	
	public Usuario(String nick, int puntaje, int nivel, int vidas) {
		this.nick = nick;
		this.puntaje = puntaje;
		this.nivel = nivel;
		this.vidas=vidas;
		
		siguiente=null;
		
		personal=new Nave(Nave.USUARIO, 487, 625, Nave.ANCHO, Nave.LARGO, null);
	}

	public Nave getPersonal() {
		return personal;
	}

	public void setPersonal(Nave personal) {
		this.personal = personal;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public Usuario getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Usuario siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
	
}