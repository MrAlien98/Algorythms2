package fractal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;

@SuppressWarnings("serial")
public class Fractal extends JFrame{
	private final int ANCHURA = 400; // define la anchura de la GUI
	private final int ALTURA = 480; // define la altura de la GUI
	private final int NIVEL_MIN = 0, NIVEL_MAX = 15;
	private Color color = Color.BLUE;
	private JButton cambiarColorJButton, aumentarNivelJButton,reducirNivelJButton;
	private JLabel nivelJLabel;
	private FractalJPanel espacioDibujo;
	private JPanel principalJPanel, controlJPanel;
	
	public Fractal(){
		super( "Fractal" );
		controlJPanel = new JPanel();
		controlJPanel.setLayout( new FlowLayout() );
// establece el botón de color y registra el componente de escucha
		cambiarColorJButton = new JButton( "Color" );
		controlJPanel.add( cambiarColorJButton );
		cambiarColorJButton.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent evento ){
				color = JColorChooser.showDialog(
						Fractal.this, "Elija un color", color );
				if ( color == null )
					color = Color.BLUE;
				espacioDibujo.establecerColor(color);
			}
		}
				);
		reducirNivelJButton = new JButton( "Reducir nivel" );
		controlJPanel.add( reducirNivelJButton );
		reducirNivelJButton.addActionListener(
				new ActionListener(){
					public void actionPerformed( ActionEvent evento ){
					int nivel = espacioDibujo.obtenerNivel();
					nivel--; // reduce el nivel en uno
					// modifica el nivel si es posible
					if ( ( nivel >= NIVEL_MIN ) && ( nivel <= NIVEL_MAX ) ){
						nivelJLabel.setText( "Nivel: " + nivel );
						espacioDibujo.establecerNivel( nivel );
						repaint();
					} // fin de if
				} // fin del método actionPerformed
			} // fin de la clase interna anónima
		); // fin de addActionListener
		aumentarNivelJButton = new JButton( "Aumentar nivel" );
		controlJPanel.add( aumentarNivelJButton );
		aumentarNivelJButton.addActionListener(
				new ActionListener(){public void actionPerformed( ActionEvent evento ){
					int nivel = espacioDibujo.obtenerNivel();
					nivel++; // aumenta el nivel en uno
					// modifica el nivel si es posible
					if ( ( nivel >= NIVEL_MIN ) && ( nivel <= NIVEL_MAX ) ){
						nivelJLabel.setText( "Nivel: " + nivel );
						espacioDibujo.establecerNivel( nivel );
						repaint();
					} // fin de if
				} // fin del método actionPerformed
			} // fin de la clase interna anónima
			); // fin de addActionListener

		nivelJLabel = new JLabel( "Nivel: 0" );
		controlJPanel.add( nivelJLabel );

		espacioDibujo = new FractalJPanel( 0 );

		principalJPanel = new JPanel();
		principalJPanel.add( controlJPanel );
		principalJPanel.add( espacioDibujo );

		add( principalJPanel ); // agrega JPanel a JFrame
		setSize( ANCHURA, ALTURA ); // establece el tamaño de JFrame
		setVisible( true ); // muestra JFrame
	} // fin del constructor de Fractal
	public static void main(String[] args){
		Fractal demo = new Fractal();
		demo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}  