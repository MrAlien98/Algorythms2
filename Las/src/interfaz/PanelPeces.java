package interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PanelPeces extends JPanel implements MouseListener{
	
	private VentanaPrincipal ventana;
	private ImageIcon logo;
	
	private ImageIcon[] pez;
	
	public PanelPeces(VentanaPrincipal ventana) {
		this.ventana=ventana;
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		logo= new ImageIcon ("src/fotos/Fondo.jpg");
		g2.drawImage(logo.getImage(), 0, 0, 750, 300, null);
		
		pez=new ImageIcon[13];
		for(int i=0;i<pez.length;i++) {
			pez[i]=new ImageIcon(ventana.darJuego().getPeces()[i].getImagen());
			g2.drawImage(pez[i].getImage(), ventana.darJuego().getPeces()[i].getX(), ventana.darJuego().getPeces()[i].getY(), ventana.darJuego().getPeces()[i].getW(), ventana.darJuego().getPeces()[i].getH(),null);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xP=e.getX();
		int yP=e.getY();
		ventana.cambiarPuntos(xP, yP);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}