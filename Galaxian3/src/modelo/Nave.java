package modelo;

import interfaces.*;

import java.io.*;

@SuppressWarnings("serial")
public class Nave implements InterfaceMover, InterfaceDisparar, Serializable{
	
	public static final String VERDE="src/imagenes/verde.png";
	public static final String AZUL="src/imagenes/azul.png";
	public static final String ROJA="src/imagenes/roja.png";
	public static final String REINA="src/imagenes/reina.png";
	public static final String BONUS="src/imagenes/bonus.png";
	public static final String USUARIO="src/imagenes/usuario.png";
	
	public static final int LARGO=40;
	public static final int ANCHO=40;
	
	private String ruta;
	private int posX;
	private int posY;
	private int largo;
	private int ancho;
	
	private Nave siguiente;
	
	protected Bala bullet; 
	
	public Nave(String ruta, int posX, int posY, int largo, int ancho, Bala bullet) {
		this.ruta = ruta;
		this.posX = posX;
		this.posY = posY;
		this.largo=largo;
		this.ancho=ancho;
		
		siguiente=null;
		
		this.bullet=bullet;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
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

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public Nave getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nave siguiente) {
		this.siguiente = siguiente;
	}
	
	public Bala getBullet() {
		return bullet;
	}

	public void setBullet(Bala bullet) {
		this.bullet = bullet;
	}

	@Override
	public void mover(int x) {
		if(getPosX()<0) {
			while(getPosX()<Juego.ANCHO_VENTANA) {
				setPosX(getPosX()+5);
			}
		}else if(getPosX()>Juego.ANCHO_VENTANA) {
			while(getPosX()>0) {
				setPosX(getPosX()-5);
			}
		}
	}
	
	@Override
	public void disparar() {
		bullet=new Bala(this.getPosX(), this.getPosY(), Bala.DISPARO_ALIADO);
		bullet.moverBala(getPosX());
	}
	
	public void pararDisparo() {
		bullet=null;
	}
	
	
	
}
