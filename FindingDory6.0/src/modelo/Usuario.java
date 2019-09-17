package modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private String nickname;
	private String puntaje;
	private String nivel;
	
	public Usuario(String nickname, String puntaje, String nivel) {
		
		this.nickname = nickname;
		this.puntaje = puntaje;
		this.nivel = nivel;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
