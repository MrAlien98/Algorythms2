package interfaz;

import javax.swing.*;

import hilos.*;

import java.awt.*;

import modelo.Juego;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{

	private Juego juego;
	private DialogPartida dP;
	private PanelOpciones pO;
	
	private HiloMoverEnemigos hME;
	private HiloDisparoEnemigo hDE;
	
	public VentanaPrincipal() {
		juego=new Juego();
		pO=new PanelOpciones(this);
		hME=new HiloMoverEnemigos(this);
		hDE=new HiloDisparoEnemigo(this);
		
		setSize(975, 665);
		setTitle("Galaxian");
		setResizable(false);
		setLayout(new BorderLayout());
		
		add(pO, BorderLayout.CENTER);
		
		iniciar();
		shoot();
		moverse();
	}
	
	public void shoot() {
		hDE.start();
	}
	
	public void moverse() {
		hME.start();
	}
	
	public void detener() {
		hME.setMuertas(true);
	}
	
	public void visibleJ() {
		dP=new DialogPartida(this);
		dP.setVisible(true);
		this.dispose();
	}
	
	public Juego darJuego() {
		return juego;
	}
	
	public void iniciar() {
		String nick=JOptionPane.showInputDialog("Ingresa tu nickname compañerito :v");
		juego.agregarUsuario(nick, 0, 1, 0);
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana=new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
