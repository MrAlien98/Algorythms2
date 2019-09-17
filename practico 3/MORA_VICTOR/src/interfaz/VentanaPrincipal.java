package interfaz;

import java.awt.*;
import javax.swing.*;

import modelo.*;
import hilos.HiloPersonaje;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{

	private Gimnasio gimnasio;
	private HiloPersonaje hilo;
	private PanelCancha pCancha;
	
	public VentanaPrincipal() {
		gimnasio=new Gimnasio();
		pCancha=new PanelCancha(this);
		
		JLabel banner=new JLabel();
		ImageIcon logo=new ImageIcon("./data/Pokemon_Banner.jpg");
		banner.setIcon(logo);
		banner.setPreferredSize(new Dimension(640, 230));
		
		setSize(1024, 740);
		setTitle("Entrenamiento Pokemon");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		add(banner, BorderLayout.NORTH);
		add(pCancha, BorderLayout.CENTER);
		
		moverPokemon();
	}


	public Pokemon darPokemon(){
		return gimnasio.darPokemon();
	}
	
	public void refrescar() {
		repaint();
	}
	
	public int darPosicionBandera() {
		return PanelCancha.POSX_BANDERA;
	}
	
	public void moverPokemon() {
		hilo=new HiloPersonaje(darPokemon(), this);
		hilo.start();
	}
	
	public void atraparPokemon(int x, int y) {
		if(darPokemon().atrapado(x, y)==true) {
			darPokemon().setDetenido(true);
			darPokemon().encapsularPokemon();
			String nombre=JOptionPane.showInputDialog("Lograste Atrapar al Pokemon, Ingresa Tu Nombre Para Registrate");
			gimnasio.guardarArchivo(nombre +" \n");
		}else {
			JOptionPane.showMessageDialog(null, "Y O U   F A I L E D");
		}
				
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana=new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
