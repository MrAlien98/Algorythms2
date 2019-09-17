package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hilos.HiloMoverUsuario;
import modelo.Juego;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{

	private Juego game;
	
	private PanelOpciones pO;
	private DialogPartida dP;
	
	private HiloMoverUsuario hMU;
	
	public VentanaPrincipal() {		
		game=new Juego();
		
		pO=new PanelOpciones(this);
		
		hMU=new HiloMoverUsuario(this);
		
		setLayout(new BorderLayout());
		setSize(Juego.LARGO_VENTANA, Juego.ALTO_VENTANA);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("WHACHALO");
		setLocationRelativeTo(null);		
		
		add(pO, BorderLayout.CENTER);
		iniciar();
	}

	public void moverUsuario() {
		hMU.run();
	}
	
	public void moverDerecha() {
		game.moverDerecha();
		repaint();
	}
	
	public void moverIzquierda() {
		game.moverIzquierda();
		repaint();
	}
	
	public void pararMovimientoUsuario() {
		hMU.setParar(true);
	}
	
	public void pasarAlJuego() {
		dP=new DialogPartida(this);
		dP.setVisible(true);
		this.dispose();
	}
	
	public Juego getGame() {
		return game;
	}

	public void guardar() {
		game.guardar();
	}
	
	public void iniciar() {
		String nombre=JOptionPane.showInputDialog("Ingrese su nombre de usuario");
		String contra=JOptionPane.showInputDialog("Ingrese su contraseña");
		game.agregarUsuario(nombre, contra);
	}

	public static void main(String[] args) {
		VentanaPrincipal ventana=new VentanaPrincipal();
		ventana.setVisible(true);
	}

	
}