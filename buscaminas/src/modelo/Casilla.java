/**Paquete que contiene toda la informacion que se dio al modelado del entorno del programa.*/
package modelo;
/** Esta clase representa cada una de las casillas del tablero
*@author Jhon Edward Mora - Universidad ICESI - A00355710
*@version 1.0 del 20/04/2018
*/
public class Casilla{
	//Atributos
	private boolean minada;
	private int numMinadasAdyacentes;
	private char estado;
	
	/**Metodo constructor:<br>
	*Este metodo inicializa un objeto de la clase y le asigna el valores a sus atributos. Ademas, asigna el valor inicial de <code>'-'</code> al estado de la casilla. <br>
	*<b> Post: </b> Se crea un objeto de la clase casilla.
	*@param minada: Indica si la casilla posee una mina o no.
	*/
	public Casilla (boolean minada){
		this.minada = minada;
		numMinadasAdyacentes = 0;
		estado = '-';
	}
	
	/**Este metodo retorna la existencia de una mina en la casilla.
	@return minada: Valor boolean que indica si en la casilla hay una mina o no.
	*/
	public boolean estaMinada(){
		return minada;
	}
	
	/**Este metodo modifica el valor del atributo <code> minada </code>.
	*/
	public void minar(){
		minada = true;
	}
	/**Este metodo retorna la cantidad de casillas minadas adyacentes
	@return numMinadasAdyacentes: Numero entero que indica la cantidad de casillas minadas adyacentes.
	*/
	public int darMinadasAdyacentes(){
		return numMinadasAdyacentes;
	}
	
	/**Este metodo retorna el estado de la casilla.
	@return estado: '1' Si la casilla ha sido abierta.'-' Si la casilla no ha sido modificada. '@' Si el usuario ya marco la casilla y 'x' si la casilla es minada y ha sido abierta.
	*/
	public char darEstado(){
		return estado;
	}
	
	/**Modifica el estado actual de la casilla, permitiendo al usuario marcar la casilla como lo desee.
	@param est: '!' Si el usuario ya marco la casilla y 'x' si la casilla es minada y ha sido abierta.
	*/
	public void modificarEstado(char est){
		estado = est;
	}
	
	/**Modifica el atributo numMinadasAdyacentes y toma el valor recibido por parametro.<br>
	<b> Post </b> El atributo <code>numMinadasAdyacentes</code> cambia su valor.
	@param adyacentes: numero de casillas minadas adyacentes a esta casilla.*/
	public void modificarNumMinasAdyacentes(int adyacentes){
		numMinadasAdyacentes = adyacentes;
	}
	
}