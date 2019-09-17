package modelo;

public class Pokemon {
	
	private String ruta;
	private boolean detenido;
	private int posX;
	private int posY;
		
	public Pokemon(int posX, int posY) {
		this.ruta = "./data/pikachu.gif";
		this.detenido = false;
		this.posX = posX;
		this.posY = posY;
	}
		
	public String darRuta() {
		return this.ruta;
	}

	public boolean isDetenido() {
		return detenido;
	}

	public void setDetenido(boolean detenido) {
		this.detenido = detenido;
	}
	
	public void avanzar(int dist) {
		setPosX(posX-=dist);
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
	
	public boolean verificarposicion(int x) {
		return false;
	}
	
	public boolean atrapado(int x, int y) {
		if(x-getPosX()>20 && getPosX()>180 && y-getPosY()>20) {
			return true;
		}
		return false;
	}
	
	public void encapsularPokemon() {
		this.ruta = "./data/pokeBall.png";
	}
	
	
}
