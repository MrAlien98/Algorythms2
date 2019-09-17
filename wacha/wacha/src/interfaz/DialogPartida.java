package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import modelo.Juego;

@SuppressWarnings("serial")
public class DialogPartida extends JDialog implements ActionListener, KeyListener{

	public static final String GUARDAR="Guardar";
	
	private VentanaPrincipal ventana;
	private PanelJuego pJ;
	
	private JButton butGuardar;
	
	public DialogPartida(VentanaPrincipal ventana) {
		this.ventana=ventana;
		pJ=new PanelJuego(ventana);
		this.setLocation(ventana.getLocation());
		
		butGuardar=new JButton("Guardar");
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener(this);
		butGuardar.setOpaque(false);
		butGuardar.setContentAreaFilled(false);
		butGuardar.setBorderPainted(false);
		butGuardar.setFont(new Font("ARCADECLASSIC", 0, 30));		
		butGuardar.setForeground(Color.BLACK);
		butGuardar.setHorizontalAlignment(JLabel.CENTER);
		butGuardar.setVerticalAlignment(JLabel.CENTER);
		
		setFocusable(true);
		setSize(Juego.LARGO_VENTANA, Juego.ALTO_VENTANA);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("WACHALO");
		setLayout(new BorderLayout());
		addKeyListener(this);
		
		
		add(pJ, BorderLayout.CENTER);
		add(butGuardar, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(GUARDAR)) {
			ventana.guardar();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			ventana.getGame().moverDerecha();
//			ventana.moverUsuario();
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			ventana.getGame().moverIzquierda();
		}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(ventana.getGame().getUsuario().getAvatar().isDisparando()==true) {
			
			}else {
				ventana.getGame().getUsuario().getAvatar().setDisparando(true);
				ventana.getGame().getUsuario().getAvatar().getBala().setX(ventana.getGame().getUsuario().getAvatar().getPosX());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			ventana.pararMovimientoUsuario();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}