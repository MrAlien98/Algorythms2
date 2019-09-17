package interfaz;

import java.awt.*;
import javax.swing.*;

import modelo.Juego;
import hilos.HiloPez;

public class VentanaPrincipal extends JFrame{

	private Juego juego;
	private PanelOpciones pO;
	private PanelDatos pD;
	private PanelPeces pP;
	
	private HiloPez hilo;
	
	private int alto;
	private int ancho;
	
	private JLabel labBanner;
	
	public VentanaPrincipal() {
		
		labBanner=new JLabel();
		ImageIcon logo=new ImageIcon("src/fotos/banner.jpg");
		labBanner.setIcon(logo);
		
		String m=JOptionPane.showInputDialog("Ingrese su nickname");
		pO=new PanelOpciones(this);
		pD=new PanelDatos(m,0,1);
		juego=new Juego(m,"0", "1");
		pP=new PanelPeces(this);
		
		ancho=750;
		alto=550;
		
		setSize(ancho, alto);
		setResizable(false);
		setTitle("Where the f*ck is Dory?");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("src/pepa.jpg").getImage());
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(pD);
		panel.add(pO);
		
		add(panel, BorderLayout.SOUTH);
		add(pP, BorderLayout.CENTER);
		add(labBanner, BorderLayout.NORTH);
	}
	
	public void mover() {
		hilo=new HiloPez(this);
		hilo.start();
		juego.reiniciar();
	}
	
	public void parar() {
		hilo.interrupt();
	}
	
	public int darAncho() {
		return ancho;
	}

	public int darAlto() {
		return alto;
	}
	
	public Juego darPeces(){
		return juego;
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal ventana=new VentanaPrincipal();
	}
}
