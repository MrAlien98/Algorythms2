package excepciones;

@SuppressWarnings("serial")
public class CasillaAbierta extends Exception {

	public CasillaAbierta(){
		super("La casilla a la que intentas acceder \n ya se encuentra abierta");
	}
	
}
