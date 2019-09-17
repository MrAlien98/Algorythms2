package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Enemigo implements Serializable{

	private int posX;
	private int posY;
	private int puntos;
	
	private String imagen;

	private boolean vivo;
	
	public Enemigo(int posX, int posY, int puntos, String imagen, boolean vivo) {
		this.posX = posX;
		this.posY = posY;
		this.puntos = puntos;
		this.imagen = imagen;
		this.vivo = vivo;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public void mover() {
		while(this.getPosX()>0) {
			this.setPosX(this.getPosX()-5);
		}while(this.getPosX()<1000) {
			this.setPosX(this.getPosX()+5);
		}
	}
}
