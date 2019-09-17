package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Personaje implements Serializable{

	public static final String DER="src/data/usuarioD.png";
	public static final String IZQ="src/data/usuarioI.png";
	
	private String imagen;
		
	private int largo;
	private int ancho;
	
	private int posX;
	private int posY;
	
	private boolean disparando;
	
	private Disparo bala;
	
	public Personaje(String imagen) {
		this.imagen=imagen;
		
		posX=(Juego.LARGO_VENTANA/2)-getAncho();
		posY=(Juego.ALTO_VENTANA-165);
		
		largo=90;
		ancho=60;
		
		this.disparando = false;
		bala=new Disparo(0);
		reload();
	}

	public void reload() {
		if(bala.getY()<60) {
			disparando=false;
			bala.reload();
		}
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX=posX;
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

	public boolean isDisparando() {
		return disparando;
	}

	public void setDisparando(boolean disparando) {
		this.disparando = disparando;
	}
	
	public void reaparecer() {
		this.setPosX(Juego.LARGO_VENTANA/2);
	}
	
	public void moverDerecha() {
		setImagen(DER);
		if(getPosX()<Juego.LARGO_VENTANA) {
			posX+=5;
		}
	}
	
	public void moverIzquierda() {
		setImagen(IZQ);
		if(getPosX()<=Juego.LARGO_VENTANA) {
			posX-=5;
		}
	}

	public Disparo getBala() {
		return bala;
	}

	public void setBala(Disparo bala) {
		this.bala = bala;
	}
	
	public void disparar() {
		if(isDisparando()==true) {
			bala.mover();
		}
	}
	
	
}
