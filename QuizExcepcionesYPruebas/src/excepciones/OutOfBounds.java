package excepciones;

@SuppressWarnings("serial")
public class OutOfBounds extends Exception {

	public OutOfBounds() {
		super("Has intentado recuperar una posici�n que no existe en la cadena de caracteres.");
	}
	
}
