package modelo;

import java.awt.Color;
import java.io.*;

@SuppressWarnings("serial")
public class Bala implements Serializable{

	public final static int MOVIMIENTO_DISPARO = 1;
	public final static char DISPARO_ENEMIGO = 'E';
	public final static char DISPARO_ALIADO = 'A';
	public final static int ALTO_MISILES = 30;
	public final static int ANCHO_MISILES = 10;
	
	private int posX;
	private int posY;
	private char tipoDisparo;
	private Color color;
	
	
	public Bala(int x, int y, char tipoDisparo){
		posX=x;
		posY=y;
		this.tipoDisparo=tipoDisparo;
		if (tipoDisparo==DISPARO_ALIADO){
			color=Color.YELLOW;
		} else {
			color=Color.BLUE;
		}
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


	public char getTipoDisparo() {
		return tipoDisparo;
	}


	public void setTipoDisparo(char tipoDisparo) {
		this.tipoDisparo = tipoDisparo;
	}

	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	public void moverBala(int x) {
		setPosX(x);
		while(this.getPosY()<Juego.LARGO_VENTANA) {
			posY+=5;
		}
	}
	
}
