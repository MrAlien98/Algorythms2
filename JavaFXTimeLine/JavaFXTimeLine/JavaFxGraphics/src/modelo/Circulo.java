package modelo;

public class Circulo {

	private int posX;
	private int posY;
	private int diametro;
	
	
	public Circulo(int posX, int posY, int ancho) {
		this.posX = posX;
		this.posY = posY;
		this.diametro = ancho;
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

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int ancho) {
		this.diametro = ancho;
	}

	
	
	
}
