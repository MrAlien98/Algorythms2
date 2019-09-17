package fractal;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FractalJPanel extends JPanel{
	
	private Color color; // almacena el color utilizado para dibujar el fractal
	private int nivel; // almacena el nivel actual del fractal
	private final int ANCHURA = 400; // define la anchura de JPanel
	private final int ALTURA = 400; // define la altura de JPanel

	// establece el nivel inicial del fractal al valor especificado
	// y establece las especificaciones del JPanel
	public FractalJPanel( int nivelActual ){
			color = Color.BLUE; // inicializa el color de dibujo en azul
			nivel = nivelActual; // establece el nivel inicial del fractal
			setBackground( Color.WHITE );
			setPreferredSize( new Dimension( ANCHURA, ALTURA ) );
	} // fin del constructor de FractalJPanel

	// dibuja el fractal en forma recursiva
	public void dibujarFractal( int nivel, int xA, int yA, int xB,int yB, Graphics g ){
		// caso base: dibuja una línea que conecta dos puntos dados
		if ( nivel == 0 )
			g.drawLine( xA, yA, xB, yB );
		else // paso recursivo: determina los nuevos puntos, dibuja el siguiente nivel
		{
			// calcula punto medio entre (xA, yA) y (xB, yB)
			int xC = ( xA + xB ) / 2;
			int yC = ( yA + yB ) / 2;

			// calcula el cuarto punto (xD, yD) que forma un
			// triángulo recto isósceles entre (xA, yA) y (xC, yC)
			// en donde el ángulo recto está en (xD, yD)
			int xD = xA + ( xC - xA ) / 2 - ( yC - yA ) / 2;
			int yD = yA + ( yC - yA ) / 2 + ( xC - xA ) / 2;

			// dibuja el Fractal en forma recursiva
			dibujarFractal( nivel - 1, xD, yD, xA, yA, g );
			dibujarFractal( nivel - 1, xD, yD, xC, yC, g );
			dibujarFractal( nivel - 1, xD, yD, xB, yB, g );
		} // fin de else
	} // fin del método dibujarFractal

	// inicia el dibujo del fractal
	public void paintComponent( Graphics g ){
		super.paintComponent( g );
		// dibuja el patrón del fractal
		g.setColor( color );
		dibujarFractal( nivel, 100, 90, 290, 200, g );	
	} // fin del método paintComponent

	// establece el color de dibujo a c
	public void establecerColor( Color c ){
		color = c;
	} // fin del método setColor

	// establece el nuevo nivel de recursividad
	public void establecerNivel( int nivelActual ){
		nivel = nivelActual;
	} // fin del método setLevel

	// devuelve el nivel de recursividad
	public int obtenerNivel(){
		return nivel;
	} // fin del método getLevel
	
 } // fin de la clase FractalJPanel