package modelo;

import java.io.*;

@SuppressWarnings("serial")
public class NaveEnemiga extends Nave implements Serializable{

	private boolean viva;
	private int puntaje;

	public NaveEnemiga(String ruta, int posX, int posY, int largo, int ancho, Bala bullet, int puntaje) {
		super(ruta, posX, posY, largo, ancho, bullet);
		viva=true;
		this.puntaje=puntaje;
	}

	public boolean isViva() {
		return viva;
	}

	public void setViva(boolean viva) {
		this.viva = viva;
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public void mover(int x) {
		if(getPosX()<Juego.ANCHO_VENTANA) {
			setPosX(getPosX()+5);
		}else if(getPosX()==0) {
			setPosX(getPosX()-5);
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
	
	@Override
	public String toString() {
		return getRuta();
	}
}
