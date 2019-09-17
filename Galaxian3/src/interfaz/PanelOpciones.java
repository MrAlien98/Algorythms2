package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener{

	public static final String INICIAR="Iniciar";
	public static final String PUNTAJES="Puntajes";
	public static final String NAVES="Naves";
	public static final String INFO="Info";
	public static final String ARCADECLASSIC="src/arcade_classic_pizz/ARCADECLASSIC.TTF";
	
	private JLabel titulo;
	
	private JButton butIniciar;
	private JButton butPuntajes;
	private JButton butNaves;
	private JButton butInfo;
	
	private VentanaPrincipal ventana;
	
	public PanelOpciones(VentanaPrincipal ventana) {
		this.ventana=ventana;
		
		titulo=new JLabel("Galaxian");
		titulo.setFont(new Font("ARCADECLASSIC", 0, 100));
		titulo.setForeground(Color.YELLOW);
		titulo.setBounds(365, 0, 608, 400);
		titulo.setVisible(true);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setVerticalAlignment(JLabel.CENTER);
		
		butIniciar=new JButton("Iniciar");
		butIniciar.addActionListener(this);
		butIniciar.setActionCommand(INICIAR);
		butIniciar.setOpaque(false);
		butIniciar.setContentAreaFilled(false);
		butIniciar.setBorderPainted(false);
		butIniciar.setFont(new Font("ARCADECLASSIC", 0, 50));		
		butIniciar.setForeground(Color.RED);
		
		butPuntajes=new JButton("Puntajes");
		butPuntajes.addActionListener(this);
		butPuntajes.setActionCommand(PUNTAJES);
		butPuntajes.setOpaque(false);
		butPuntajes.setContentAreaFilled(false);
		butPuntajes.setBorderPainted(false);
		butPuntajes.setFont(new Font("ARCADECLASSIC", 0, 50));
		butPuntajes.setForeground(Color.BLUE);
		
		butNaves=new JButton("Naves");
		butNaves.addActionListener(this);
		butNaves.setActionCommand(NAVES);
		butNaves.setOpaque(false);
		butNaves.setContentAreaFilled(false);
		butNaves.setBorderPainted(false);
		butNaves.setFont(new Font("ARCADECLASSIC", 0, 50));	
		butNaves.setForeground(Color.RED);
		
		butInfo=new JButton("Info");
		butInfo.addActionListener(this);
		butInfo.setActionCommand(INFO);
		butInfo.setOpaque(false);
		butInfo.setContentAreaFilled(false);
		butInfo.setBorderPainted(false);
		butInfo.setFont(new Font("ARCADECLASSIC", 0, 50));
		butInfo.setForeground(Color.BLUE);
		
		setLayout(new BorderLayout());
		
		JPanel aux=new JPanel();
		aux.setLayout(new GridLayout(4,1));
		aux.add(butIniciar);
		aux.add(butPuntajes);
		aux.add(butNaves);
		aux.add(butInfo);
		aux.setOpaque(false);
		
		add(aux, BorderLayout.SOUTH);
		add(titulo, BorderLayout.CENTER);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintBackGround(g);
	}
	
	public void paintBackGround(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		ImageIcon logo=new ImageIcon("src/imagenes/fondo.gif");
		logo.setImageObserver(this);
		g2.drawImage(logo.getImage(), 0, 0, 975, 665, logo.getImageObserver());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando=arg0.getActionCommand();
		if(comando.equals(INICIAR)) {
			ventana.visibleJ();
		}
	}

}
