package exception;

public class ValorNuloEnArreglo extends Exception{

	public ValorNuloEnArreglo(String j, int i) {
		super("Error en la posicion:"+i+""+j+"");
	}
}