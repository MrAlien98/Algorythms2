package modelo;

import java.io.Serializable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Clase EnemigoBoss
 * @author Victor Mora
 *
 */
public class EnemigoBoss extends EnemigoA implements Serializable{

	private static final long serialVersionUID = 1L;

	private int vida;
	
	private DoubleProperty vidP;

	/**
	 * Constructor de la clase Enemigo Boss 
	 * @param posX != null, posX posicion x del EnemigoBoss
	 * @param posY != null, posY posicion y del EnemigoBoss
	 * @param puntos != null, puntos puntos que da el EnemigoBoss cuando es golpeado
	 * @param imagen != null, imagen ruta de la imagen que tendrá en la interfaz el EnemigoBoss
	 * @param vivo != null, vivo booleano de confirmacion para saber si el EnemigoBoss aun esta vivo o no
	 * @param direccion != null, direccion char que indica la direccion de movimiento del EnemigoBoss
	 */
	public EnemigoBoss(int posX, int posY, int puntos, String imagen, boolean vivo, char direccion) {
		super(posX, posY, puntos, imagen, vivo, direccion);
		setPuntos(300);
		vida=2500;
	}

	/**
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}

	public DoubleProperty vidaProperty() {
		if(vidP==null) {
			vidP=new SimpleDoubleProperty(0);
		}
		return vidP;
	}
	
	public double getVidP() {
		if(vidP!=null)
			return vidP.get();
		return 0;
	}
	
	public void setVidP(double num) {
		this.vidaProperty().set(num);
	}
	
	/**
	 * @param vida the vida to set
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
