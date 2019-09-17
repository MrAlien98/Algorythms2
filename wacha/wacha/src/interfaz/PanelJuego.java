package interfaz;

import java.awt.*;
import javax.swing.*;

import modelo.Juego;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel {

	private VentanaPrincipal ventana;
	private ImageIcon logo;
	
	public PanelJuego(VentanaPrincipal ventana) {
		this.ventana=ventana;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintBackground(g);
		paintTxt(g);
		paintUser(g);
		paintBullet(g);
	}
	
	public void paintBackground(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		logo=new ImageIcon("src/data/background.gif");
		logo.setImageObserver(this);
		g2.drawImage(logo.getImage(), 0, 0, Juego.LARGO_VENTANA, Juego.ALTO_VENTANA, logo.getImageObserver());
	}
	
	public void paintTxt(Graphics g) {
		ImageIcon logo2=new ImageIcon("src/data/usuarioD.png");
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("ARCADECLASSIC", 0, 30));
		g.drawString( "1UP", 1, 20);
		g.drawString("HIGH SCORE", 90, 20);
		g.drawImage(logo2.getImage(), 253, 12, 30, 30, this);
		g.drawImage(logo2.getImage(), 283, 12, 30, 30, this);
		g.drawImage(logo2.getImage(), 313, 12, 30, 30, this);
		g.drawString(Integer.toString(ventana.getGame().getUsuario().getPuntos()), 10, 40);
		try {
			g.drawString(Integer.toString(ventana.getGame().getUsuarios().get(0).getPuntos()), 60, 60);
			g.drawString(Integer.toString(ventana.getGame().buscarUsuarioMayorPuntaje()), 100, 40);
		}catch(Exception e) {
			g.drawString("5000", 130, 40);
		}
	}
	
	public void paintUser(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2=(Graphics2D) g;
		
		ImageIcon usuario=new ImageIcon(ventana.getGame().getUsuario().getAvatar().getImagen());
		g2.drawImage(usuario.getImage(), ventana.getGame().getUsuario().getAvatar().getPosX(), ventana.getGame().getUsuario().getAvatar().getPosY(), ventana.getGame().getUsuario().getAvatar().getAncho(), ventana.getGame().getUsuario().getAvatar().getLargo(), null);
	}
	
	public void paintBullet(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2=(Graphics2D) g;
		
		g2.setColor(Color.BLUE);
		if(ventana.getGame().getUsuario().getAvatar().isDisparando()==true) {
			ventana.getGame().getUsuario().getAvatar().disparar();
			g2.fillRect((ventana.getGame().getUsuario().getAvatar().getBala().getX())+(ventana.getGame().getUsuario().getAvatar().getAncho()/2), ventana.getGame().getUsuario().getAvatar().getBala().getY(), ventana.getGame().getUsuario().getAvatar().getBala().getAncho(), ventana.getGame().getUsuario().getAvatar().getBala().getLargo());
			ventana.getGame().getUsuario().getAvatar().reload();
		}
	}

}