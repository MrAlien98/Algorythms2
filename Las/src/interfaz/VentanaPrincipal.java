package interfaz;

import java.awt.*;
import javax.swing.*;

import modelo.Juego;
import hilos.HiloPez;

public class VentanaPrincipal extends JFrame{
 
	private static final long serialVersionUID = 1L;
	
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
		pO=new PanelOpciones(this);
		pD=new PanelDatos("",0,0, this);
		pP=new PanelPeces(this);
		juego=new Juego();
		
		ancho=750;
		alto=550;
		
		setSize(ancho, alto);
		setResizable(false);
		setTitle("Where the f*ck is Dory?");
		setVisible(false);
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
		
		iniciarJuego();
	}
	
	public void iniciarJuego() {
		String m="";
		do {
			m=JOptionPane.showInputDialog("Ingrese su nickname");
		}while(m.equals(""));
		pD.getLabNombre().setText(m);
		juego.agregarUsuario(m, "0", "0");
		setVisible(true);
	}
	
	public void mover() {
		hilo=new HiloPez(this, 5);
		hilo.start();
		juego.reiniciar();
	}
	
	public Juego darJuego(){
		return juego;
	}
	
	public HiloPez darHilo() {
		return hilo;
	}
	
	public void guardarUsuario() {
		pD.getTxtLvl().setText("0");
		pD.getTxtPtos().setText("0");
		int time=5;
		hilo.setTime(time);
		juego.escribiendo2();
	}

	
	public void cambiarLvl() {
		String lvl=Integer.toString(juego.cambiarLvl(pD.getTxtPtos().getText()));
		int time=juego.cambiarSleep(pD.getTxtLvl().getText());
		pD.getTxtLvl().setText(lvl);
		hilo.setTime(time);
	}
	
	
	public void cambiarPuntos(int xP, int yP) {
		String n=pD.getTxtPtos().getText();
		String puntos=Integer.toString(juego.cambiarPuntos(n, xP, yP));
		pD.getTxtPtos().setText(puntos);
		cambiarLvl();
	}
	
	public void buscarJugador() {
		int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puntaje de usuario que desea buscar"));
		JOptionPane.showMessageDialog(null, juego.busquedaBinaria(n));
	}
	
	public void opcionesDeOrden() {
		String[] opciones= {"Orden alfabetico", "Orden de Puntaje"};
		int op=(JOptionPane.showOptionDialog(null, "Elige Una Opcion", "Tipos de ordenamiento", 0, 0, null, opciones, null));
		if(op==0) {
			ordenAlfa();
		}else if(op==1) {
			ordenPt();
		}
	}
	
	public void ordenAlfa() {
		JOptionPane.showMessageDialog(null, juego.ordenNombres());
	}
	
	public void ordenPt() {
		JOptionPane.showMessageDialog(null, juego.ordenPuntos());
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana=new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
