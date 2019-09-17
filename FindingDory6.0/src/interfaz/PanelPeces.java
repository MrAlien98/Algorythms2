package interfaz;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PanelPeces extends JPanel implements MouseListener{
	
	private VentanaPrincipal ventana;
	private ImageIcon logo;
	
	private ImageIcon pez1;
	private ImageIcon pez2;
	private ImageIcon pez3;
	private ImageIcon pez4;
	private ImageIcon pez5;
	private ImageIcon pez6;
	private ImageIcon pez7;
	private ImageIcon pez8;
	private ImageIcon pez9;
	private ImageIcon pez10;
	private ImageIcon pez11;
	private ImageIcon pez12;
	private ImageIcon pez13;
	
	public PanelPeces(VentanaPrincipal ventana) {
		this.ventana=ventana;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		logo= new ImageIcon ("src/fotos/Fondo.jpg");
		g2.drawImage(logo.getImage(), 0, 0, null);
		
		pez1=new ImageIcon(ventana.darPeces().getPeces()[0].getImagen());
		pez2=new ImageIcon(ventana.darPeces().getPeces()[1].getImagen());
		pez3=new ImageIcon(ventana.darPeces().getPeces()[2].getImagen());
		pez4=new ImageIcon(ventana.darPeces().getPeces()[3].getImagen());
		pez5=new ImageIcon(ventana.darPeces().getPeces()[4].getImagen());
		pez6=new ImageIcon(ventana.darPeces().getPeces()[5].getImagen());
		pez7=new ImageIcon(ventana.darPeces().getPeces()[6].getImagen());
		pez8=new ImageIcon(ventana.darPeces().getPeces()[7].getImagen());
		pez9=new ImageIcon(ventana.darPeces().getPeces()[8].getImagen());
		pez10=new ImageIcon(ventana.darPeces().getPeces()[9].getImagen());
		pez11=new ImageIcon(ventana.darPeces().getPeces()[10].getImagen());
		pez12=new ImageIcon(ventana.darPeces().getPeces()[11].getImagen());
		pez13=new ImageIcon(ventana.darPeces().getPeces()[12].getImagen());
		
		
		g2.drawImage(pez1.getImage(), ventana.darPeces().getPeces()[0].getX(), ventana.darPeces().getPeces()[0].getY(), ventana.darPeces().getPeces()[0].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez2.getImage(), ventana.darPeces().getPeces()[1].getX(), ventana.darPeces().getPeces()[1].getY(), ventana.darPeces().getPeces()[1].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez3.getImage(), ventana.darPeces().getPeces()[2].getX(), ventana.darPeces().getPeces()[2].getY(), ventana.darPeces().getPeces()[2].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez4.getImage(), ventana.darPeces().getPeces()[3].getX(), ventana.darPeces().getPeces()[3].getY(), ventana.darPeces().getPeces()[3].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez5.getImage(), ventana.darPeces().getPeces()[4].getX(), ventana.darPeces().getPeces()[4].getY(), ventana.darPeces().getPeces()[4].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez6.getImage(), ventana.darPeces().getPeces()[5].getX(), ventana.darPeces().getPeces()[5].getY(), ventana.darPeces().getPeces()[5].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez7.getImage(), ventana.darPeces().getPeces()[6].getX(), ventana.darPeces().getPeces()[6].getY(), ventana.darPeces().getPeces()[6].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez8.getImage(), ventana.darPeces().getPeces()[7].getX(), ventana.darPeces().getPeces()[7].getY(), ventana.darPeces().getPeces()[7].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez9.getImage(), ventana.darPeces().getPeces()[8].getX(), ventana.darPeces().getPeces()[8].getY(), ventana.darPeces().getPeces()[8].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez10.getImage(), ventana.darPeces().getPeces()[9].getX(), ventana.darPeces().getPeces()[9].getY(), ventana.darPeces().getPeces()[9].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez11.getImage(), ventana.darPeces().getPeces()[10].getX(), ventana.darPeces().getPeces()[10].getY(), ventana.darPeces().getPeces()[10].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez12.getImage(), ventana.darPeces().getPeces()[11].getX(), ventana.darPeces().getPeces()[11].getY(), ventana.darPeces().getPeces()[11].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		g2.drawImage(pez13.getImage(), ventana.darPeces().getPeces()[12].getX(), ventana.darPeces().getPeces()[12].getY(), ventana.darPeces().getPeces()[12].getW(), ventana.darPeces().getPeces()[0].getH(),null);
		
		for(int i=0;i<ventana.darPeces().getPeces().length;i++) {
			if(ventana.darPeces().getPeces()[i].getX()<750) {
				ventana.darPeces().reiniciar();
			}else {
				ventana.darPeces().getPeces()[i].comienzo();
			}
		}
		repaint();
	}

}