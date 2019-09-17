package modelo;

public class Pez {

	private int x;
	private int y; 
	private int w; 
	private int h;
	private int r;
	private String imagen;
	
	public Pez(String imagen, int x, int y, int w, int h, int r) {
		this.imagen = imagen;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.r=r;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x=x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y=y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w=w;
	}

	public int getH() {
		return h;
	}

	public void seth(int h) {
		this.h=h;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void mover() {
		x++;
	}	
	
	public void comienzo() {
		setX(-100);
		mover();
	}
	
	public int getR() {
		return r;
	}
}
