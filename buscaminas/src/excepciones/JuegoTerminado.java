package excepciones;

@SuppressWarnings("serial")
public class JuegoTerminado extends Exception {

	public JuegoTerminado() {
		super("El juego ya termin� \n The game is over my friend");
	}
	
}
