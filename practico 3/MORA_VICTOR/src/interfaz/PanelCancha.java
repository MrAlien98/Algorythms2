package interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelCancha extends JPanel implements MouseListener{

	public static final ImageIcon CANCHA=new ImageIcon("./data/cancha.jpg");
	public static final ImageIcon BANDERA=new ImageIcon("./data/bandera.png");
	public static final int POSX_BANDERA=0;
	public static final int POSY_BANDERA=0;
	
	private VentanaPrincipal pr;
	
	public PanelCancha(VentanaPrincipal pr) {
		this.pr=pr;
		
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintBackground(g);
		Graphics2D g2=(Graphics2D) g;
		
		g2.drawImage(BANDERA.getImage(), 180, 150, this);
		
		ImageIcon pika=new ImageIcon(pr.darPokemon().darRuta());
		pika.setImageObserver(this);
		g2.drawImage(pika.getImage(), pr.darPokemon().getPosX(), pr.darPokemon().getPosY(), this);
		
	}
	
	private void paintBackground(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		g2.drawImage(CANCHA.getImage(), 0, 0, 1024, 480, this);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//pr.atraparPokemon(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		pr.atraparPokemon(arg0.getX(), arg0.getY());		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
