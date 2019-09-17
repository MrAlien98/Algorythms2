	/**Paquete que contiene toda la informacion que se dio al modelado del entorno del programa.*/
package modelo;
import java.util.*;

import excepciones.CasillaAbierta;
import excepciones.CasillaInvalida;
import excepciones.JuegoTerminado;
/**Esta clase representa el tablero de juego.
*@author Jhon Edward Mora Mora - Universidad ICESI - A00355710
*@version 1.0 del 20/04/2018
*/
public class Tablero{
	//Constantes con el tamaño del tablero.
	/**Cantidad de filas del tablero en dificultad principiante*/
	public static final int FILAS_PRI = 8;
	/**Cantidad de columnas del tablero en dificultad principiante*/
	public static final int COLUMNAS_PRI = 8;
	/**Cantidad de filas del tablero en dificultad intermedio*/
	public static final int FILAS_INT = 16;
	/**Cantidad de columnas del tablero en dificultad intermedio*/
	public static final int COLUMNAS_INT = 16;
	/**Cantidad de filas del tablero en dificultad experto*/
	public static final int FILAS_EXP = 16;
	/**Cantidad de columnas del tablero en dificultad experto*/
	public static final int COLUMNAS_EXP = 30;
	
	//Relacion con la clase Casilla
	private Casilla[][] casillas;
	//Relacion con los utiles.
	private Random rnd;
	
	//Atributos:
	private char dificultad;
	
	private boolean terminado;
	
	private int casillasSeguras;
	private int casillasDestapadas;
	
	/**Constructor de la clase: <br> Inicializa y da valores a un objeto de esta clase. <br>
	<b> Post: </b> Se crea un objeto de la clase.
	@param d: Caracter que identifica la dificultad con la que se jugará el juego. 'P' Si es principiante, 'I' si es intermedio o cualquier otro caracter si es experto.
	*/
	public Tablero(char d){
		dificultad = d;
		rnd = new Random();
		if (dificultad == 'P'){
			casillas = new Casilla[FILAS_PRI][COLUMNAS_PRI];
			minarTablero(10);
			setCasillasSeguras(54);
			setCasillasDestapadas(0);
		}else if (dificultad == 'I'){
			casillas = new Casilla[FILAS_INT][COLUMNAS_INT];
			minarTablero(40);
			setCasillasSeguras(216);
			setCasillasDestapadas(0);
		}else {
			casillas = new Casilla[FILAS_EXP][COLUMNAS_EXP];
			minarTablero(99);
			setCasillasSeguras(381);
			setCasillasDestapadas(0);
		}
		terminado=false;
	}
	
	public void destaparCasilla(int f, int c, char estado) throws CasillaInvalida, CasillaAbierta, JuegoTerminado{
		if(f>getCasillas().length || f>getCasillas().length || c>getCasillas()[0].length || c>getCasillas()[0].length) {
			throw new CasillaInvalida();
		}else if(getCasillas()[f][c].darEstado()=='1') {
			throw new CasillaAbierta();
		}else if(terminado==true) {
			throw new JuegoTerminado();
		}else {
			getCasillas()[f][c].modificarEstado(estado);
			casillasDestapadas++;
			if(getCasillas()[f][c].estaMinada()==true) {
				perder();
				setTerminado(true);
			}
		}
	}
	
	public void destaparCasilla2(int f, int c, char estado){
		getCasillas()[f][c].modificarEstado(estado);
	}
	
	public Casilla[][] getCasillas() {
			return casillas;
	}
	
	/**Primero el metodo inicializa todas los objetos de la matriz casillas. Despues asigna el valor booleano de la clase Casilla <code>minada</code> a <code>true</code> a casillas aleatorias del tablero que no lo posean ya, una determinada cantidad de veces.
	<br><b> Post: </b> Todos los objetos de la matriz han sido inicializados, y algunos de ellos son casillas minadas.
	@param cantidad: Entero con la cantidad de minas a colocarse en el tablero.
	*/
	@SuppressWarnings("unused")
	public void minarTablero(int cantidad){
		int numFilas = casillas.length;
		int numColumnas = casillas[0].length;
		for (int i = 0; i<numFilas; i++){
			for (int j = 0; j<numColumnas; j++){
				casillas[i][j] = new Casilla (false);
			}
		}	
		boolean terminado = false;
		int numMinadas = 0;
		for (int l = 0; terminado == false; ){
			int posY = rnd.nextInt(numFilas);
			int posX = rnd.nextInt(numColumnas);
			if (casillas[posY][posX].estaMinada() == false){
					casillas[posY][posX].minar();
					numMinadas++;
					if (!(numMinadas < cantidad)){
						terminado=true;
					}
			}
		}
		contarCasillasMinadasAdyacentes();
	}
	
	/**El metodo cuenta cuantas casillas minadas adyacentes tiene cada casilla del tablero y le asigna ese valor a cada casilla del tablero.
	<br> <b> Pre: </b> La matriz de casillas ya ha sido inicializada y cada uno de sus objetos tambien. Existen casillas minadas en la matriz.
	<b> Post: </b> Cada casilla guarda la informacion de cuantas de sus casillas adyacentes estan minadas.
	*/
	public void contarCasillasMinadasAdyacentes(){
		int numFilas = casillas.length;
		int numColumnas = casillas[0].length;
		
		for (int x=0; x<numFilas; x++){
			for (int y=0; y<numColumnas; y++){
				int numMinadas = 0;
				if (x==0){
					if (y==0){
						if (casillas[x][y+1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y].estaMinada()){numMinadas++;}
					}
					else if (y==numColumnas-1){
						if (casillas[x][y-1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y].estaMinada()){numMinadas++;}
					}
					else{
						if (casillas[x][y-1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y].estaMinada()){numMinadas++;}
						if (casillas[x+1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x][y+1].estaMinada()){numMinadas++;}
					}
				}
				else if(x==numFilas-1){
					if(y==0){
						if (casillas[x-1][y].estaMinada()){numMinadas++;}
						if (casillas[x-1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x][y+1].estaMinada()){numMinadas++;}
					}
					else if (y==numColumnas-1){
						if (casillas[x-1][y].estaMinada()){numMinadas++;}
						if (casillas[x-1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x][y-1].estaMinada()){numMinadas++;}
					}
					else{
						if (casillas[x][y-1].estaMinada()){numMinadas++;}
						if (casillas[x-1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x-1][y].estaMinada()){numMinadas++;}
						if (casillas[x-1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x][y+1].estaMinada()){numMinadas++;}
					}
				}
				else{
					if (y==0){
						if (casillas[x-1][y].estaMinada()){numMinadas++;}
						if (casillas[x-1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x][y+1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y].estaMinada()){numMinadas++;}
					}
					else if (y==numColumnas-1){
						if (casillas[x-1][y].estaMinada()){numMinadas++;}
						if (casillas[x-1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x][y-1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y].estaMinada()){numMinadas++;}
					}
					else {
						if (casillas[x-1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x-1][y].estaMinada()){numMinadas++;}
						if (casillas[x-1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x][y+1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y+1].estaMinada()){numMinadas++;}
						if (casillas[x+1][y].estaMinada()){numMinadas++;}
						if (casillas[x+1][y-1].estaMinada()){numMinadas++;}
						if (casillas[x][y-1].estaMinada()){numMinadas++;}
					}
				}
				casillas[x][y].modificarNumMinasAdyacentes(numMinadas);
			}
		}
	}

	/**El metodo revisa la matriz de casillas y luego modifica el estado de todas las casillas que posean una mina en ellas, indicando que el usuario ha perdido. <br>
	<b> Pre: </b> La matriz ed casillas y cada uno de sus elementos ha sido inicializada. <br>
	<b> Post: </b> El juego termina y el usuario ha perdido.
	*/
	public void perder(){
		int numFilas = casillas.length;
		int numColumnas = casillas[0].length;
		for (int x=0; x<numFilas; x++){
			for (int y=0; y<numColumnas; y++){
				if(casillas[x][y].estaMinada()){
					casillas[x][y].modificarEstado('x');
				}
			}
		}
	}
	
	/**Este metodo indica si el usuario tiene todas las casillas con mina como marcadas. <br>
	<b> Pre: </b> La matriz de casillas junto a cada uno de sus elementos ha sido inicializada. <br>
	@return gano: Valor booleano que inidica si el usuario ya ha ganado o no.
	*/
	public boolean revisarSiGano(){
		if(getCasillasDestapadas()==getCasillasSeguras()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**Indica si el usuario tiene todas las casillas con mina como abiertas, significando que ha perdido. <br>
	<b> Pre: </b> La matriz de casillas junto a cada uno de sus elementos ha sido inicializada. <br>
	@return Valor booleano que inidica si el usuario ha perdido o no.
	*/
	public boolean revisarSiPerdio(){
		for (int i=0;i<casillas.length;i++){
			for (int j=0;j<casillas[i].length;j++){
				if (casillas[i][j].estaMinada()&&casillas[i][j].darEstado()=='x'){
					return true;
				}
			}
		}
		return false;
	}
	
	/**Retorna la cantidad de casillas minadas que tiene el tablero.<br>
	<b> Pre: </b> La matriz de casillas y cada uno de sus elementos ha sido inicializada.
	@return minadas: Cantidad de casillas minadas.
	*/
	public int contarTotalMinadas(){
		int minadas = 0;
		int numFilas = casillas.length;
		int numColumnas = casillas[0].length;
		for (int x=0; x<numFilas; x++){
			for (int y=0; y<numColumnas; y++){
				if (casillas[x][y].estaMinada()){
					minadas++;
				}
			}
		}
		return minadas;
	}
	
	/**Muestra la solucion del tablero.<br>
	<b> Pre: </b> La matriz de casillas y cada uno de sus elementos ha sido inicializada.<br>
	<b> Post: </b> Cada casilla del tablero cambia su estado al que deberia tener si esta fuese abierta, y si la casilla esta minada, marca la casilla como "Marcada".
	*/
	public void solucionar() throws JuegoTerminado{
		if(revisarSiGano()==true) {
			throw new JuegoTerminado();
		}else if(isTerminado()==true){
			throw new JuegoTerminado();
		}else {
			int numFilas = casillas.length;
			int numColumnas = casillas[0].length;
			for (int x=0; x<numFilas; x++){
				for (int y=0; y<numColumnas; y++){
					if (!casillas[x][y].estaMinada()){
						try {
							destaparCasilla(x,y,'1');
						}catch(Exception e) {
							e.getMessage();
						}
					}else{
						try {
							destaparCasilla(x,y,'2');
						}catch(Exception e) {
							e.getMessage();
						}
					}
				}
			}
		}
	}
	
	/**Muestra al usuario la primera casilla del tablero que no tenga una mina en ella y que ademas tenga 0 casillas minadas adyacentes.
	<b> Pre: </b> La matriz de casillas y cada uno de sus elementos ha sido inicializada.<br>
	<b> Post: </b> La primera casilla de la matriz cuyo atributo <code>minada</code> sea <code>false</code>, y que no este ya abierta, y que ademas tenga una cantidad de casillas minadas adyacentes igual a 0.
	*/
	public String darPista() throws JuegoTerminado{
		if(revisarSiGano()==true) {
			throw new JuegoTerminado();
		}else if(isTerminado()==true){
			throw new JuegoTerminado();
		}else {
			String pos ="";
			int numFilas = casillas.length;
			int numColumnas = casillas[0].length;
			boolean encontrada = false;
			for (int x=0; x<numFilas && encontrada == false; x++){
				for (int y=0; y<numColumnas && encontrada == false; y++){
					if ((!casillas[x][y].estaMinada())&&(casillas[x][y].darEstado() == '-')&&(casillas[x][y].darMinadasAdyacentes()!=0)) {
						try {
							destaparCasilla(x,y,'2');
						}catch(Exception e) {
							e.getMessage();
						}
						encontrada = true;
						pos=x+"_"+y;
						return pos;
					}
				}
			}
			return null;
		}
	}
	
	
	/**Crea una cadena de caracteres con toda la informacion del tablero.
	<b> Pre: </b> La matriz de casillas y cada uno de sus elementos ha sido inicializada.
	@return mensaje: Cadena de caracteres con toda la informacion del tablero de juego.
	*/
	public String mostrarTablero(){
		int numFilas = casillas.length;
		int numColumnas = casillas[0].length;
		String primeraLinea = "    ";
		String otrasLineas = "";
		for (int j = 0; j<numColumnas; j++){
			if (j<9){
				primeraLinea+= j+1 + "  ";
			} else {
				primeraLinea+= j+1 + " ";
			}
		}
		for (int x=0; x<numFilas; x++){
			if (x<9){
					otrasLineas+= x+1 + "  ";
				}else{
					otrasLineas+= x+1 + " ";
				}
			for (int y=0; y<numColumnas; y++){
				if (x<10){
					 otrasLineas+=" " + casillas[x][y].darEstado() + " ";
				}else{
					otrasLineas+=" " + casillas[x][y].darEstado() + " ";
				}
			}
			otrasLineas += "\n";
		}
		String mensaje = primeraLinea + "\n" + otrasLineas;
		return mensaje;
	}

	/**Entrega la cantidad de filas del tablero.
	@return filas: Numero de filas que posee el tablero.
	*/
	public int darNumFilas(){
		return casillas.length;
	}
	/**Entrega el numero de columnas del tablero.
	@return columnas: Numero de columnas que posee el tablero.
	*/
	public int darNumColumnas(){
		return casillas[0].length;
	}

	public int getCasillasSeguras() {
		return casillasSeguras;
	}

	public void setCasillasSeguras(int casillasSeguras) {
		this.casillasSeguras = casillasSeguras;
	}

	/**
	 * @return the casillasDestapadas
	 */
	public int getCasillasDestapadas() {
		return casillasDestapadas;
	}

	/**
	 * @param casillasDestapadas the casillasDestapadas to set
	 */
	public void setCasillasDestapadas(int casillasDestapadas) {
		this.casillasDestapadas = casillasDestapadas;
	}

	/**
	 * @return the terminado
	 */
	public boolean isTerminado() {
		return terminado;
	}

	/**
	 * @param terminado the terminado to set
	 */
	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	} 
	
	
}