package modelo;

import java.io.Serializable;

public class Usuario implements Serializable, Comparable<Usuario>{
	
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

	@Override
	public String toString() {
		return "Usuario: " + nickname + " puntaje: " + puntaje + " nivel: " + nivel+"";
	}

	@Override
	public int compareTo(Usuario o) {
		if(Integer.parseInt(this.getPuntaje())<Integer.parseInt(o.getPuntaje())) {
			return 1;
		}else if(Integer.parseInt(this.getPuntaje())>Integer.parseInt(o.getPuntaje())){
			return -1;
		}else {
			return 0;	
		}
	}	
	
		
}
