package interfaz;

import java.awt.*;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements KeyListener{

	private VentanaPrincipal ventana;
	private ImageIcon logo;
	
	private ImageIcon[] naves;
	
	private ImageIcon u;
	
	public PanelJuego(VentanaPrincipal ventana) {
		this.ventana=ventana;
		
		addKeyListener(this);
	}
	
	public VentanaPrincipal darVentana() {
		return ventana;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		paintBackground(g);
		paintTxt(g);
		paintNaves(g);
		//Graphics2D g2=(Graphics2D) g;		
		
	}
	
	public void paintNaves(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2=(Graphics2D) g;
		
		naves=new ImageIcon[ventana.darJuego().getNaves().size()-1];
		for(int i=0;i<naves.length;i++) {
			naves[i]=new ImageIcon(ventana.darJuego().getNaves().get(i).toString());
			g2.drawImage(naves[i].getImage(), ventana.darJuego().getNaves().get(i).getPosX(), ventana.darJuego().getNaves().get(i).getPosY(), ventana.darJuego().getNaves().get(i).getLargo(), ventana.darJuego().getNaves().get(i).getAncho(), null);
		}
		
		u=new ImageIcon(ventana.darJuego().getUsuarios().get(0).getPersonal().getRuta());
		g2.drawImage(u.getImage(), ventana.darJuego().getUsuarios().get(0).getPersonal().getPosX(), ventana.darJuego().getUsuarios().get(0).getPersonal().getPosY(), ventana.darJuego().getUsuarios().get(0).getPersonal().getLargo(), ventana.darJuego().getUsuarios().get(0).getPersonal().getAncho(), null);
	}
	
	public void paintBackground(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2=(Graphics2D) g;
		
		logo=new ImageIcon("src/imagenes/fondo.gif");
		logo.setImageObserver(this);
		g2.drawImage(logo.getImage(), 0, 0, 975, 665, logo.getImageObserver());
	}
	
	public void paintTxt(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("ARCADECLASSIC", 0, 50));
		g.drawString( "1UP", 1, 30 );
		g.drawString(Integer.toString(ventana.darJuego().getPrimero().getPuntaje()), 60, 60);
		g.drawString("HIGH SCORE", 375, 30);
		g.drawString(Integer.toString(ventana.darJuego().buscarUsuarioMayorPuntaje().getPuntaje()), 600, 60);
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		int e=arg0.getKeyCode();
		if(e==KeyEvent.VK_RIGHT) {
			ventana.darJuego().getPrimero().getPersonal().mover(-1);
		}else if(e==KeyEvent.VK_LEFT) {
			ventana.darJuego().getPrimero().getPersonal().mover(1);
		}else if(e==KeyEvent.VK_SPACE) {
			ventana.darJuego().getPrimero().getPersonal().disparar();
		}		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

