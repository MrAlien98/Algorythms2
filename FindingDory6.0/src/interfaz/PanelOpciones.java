package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener{
	
	public static final String GUARDAR="Guardar";
	public static final String INICIAR="Iniciar";
	public static final String VER_PUNTAJES="Ver puntajes";
	
	private JButton butGuardar;
	private JButton butIniciar;
	private JButton butVerPuntajes;
	
	private VentanaPrincipal ventana;
	
	public PanelOpciones(VentanaPrincipal ventana) {
		this.ventana=ventana;
		
		butGuardar= new JButton("Guardar");
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener(this);
		
		butIniciar= new JButton("Iniciar");
		butIniciar.setActionCommand(INICIAR);
		butIniciar.addActionListener(this);
		
		butVerPuntajes= new JButton("Ver puntajes");
		butVerPuntajes.setActionCommand(VER_PUNTAJES);
		butVerPuntajes.addActionListener(this);
		
		setLayout(new GridLayout(1,3));
		
		TitledBorder border= BorderFactory.createTitledBorder("Opciones");
		setBorder(border);
		
		add(butGuardar);
		add(butVerPuntajes);
		add(butIniciar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String n=e.getActionCommand();
		if(n.equals(GUARDAR)) {
			ventana.parar();
			butIniciar.setEnabled(true);
			ventana.darPeces().reiniciar();
		}else if(n.equals(INICIAR)) {
			ventana.mover();
			butIniciar.setEnabled(false);
		}else if(n.equals(VER_PUNTAJES)) {
			System.out.println("xd");
		}
	}
}
