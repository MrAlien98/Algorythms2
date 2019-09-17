package modelo;

public class Disparo {

	private int largo;
	private int ancho;
	
	private int x;
	private int y;
	
	public Disparo(int x) {
		largo=100;
		ancho=150;
		y=Juego.ALTO_VENTANA-165;
	}

	public void reload() {
		setY(Juego.ALTO_VENTANA-165);
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
	
	public void mover() {
		y-=50;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
