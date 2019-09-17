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
	public static final String BUSC_J="Buscar Jugador";
	
	private JButton butGuardar;
	private JButton butIniciar;
	private JButton butVerPuntajes;
	private JButton butBuscarJugador;
	
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
		
		butBuscarJugador=new JButton("BuscarJugador");
		butBuscarJugador.setActionCommand(BUSC_J);
		butBuscarJugador.addActionListener(this);
		
		setLayout(new GridLayout(2,1));
		
		JPanel panel1=new JPanel();
		setLayout(new GridLayout(1,3));
		panel1.add(butGuardar);
		panel1.add(butVerPuntajes);
		panel1.add(butIniciar);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(1,1));
		panel2.add(butBuscarJugador);
		
		TitledBorder border= BorderFactory.createTitledBorder("Opciones");
		setBorder(border);
		
		add(panel1);
		add(panel2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String n=e.getActionCommand();
		if(n.equals(GUARDAR)) {
			ventana.guardarUsuario();
			butIniciar.setEnabled(true);
			ventana.darJuego().reiniciar();
		}else if(n.equals(INICIAR)) {
			ventana.mover();
			butIniciar.setEnabled(false);
		}else if(n.equals(VER_PUNTAJES)) {
			ventana.opcionesDeOrden();
		}else if(n.equals(BUSC_J)) {
			ventana.buscarJugador();
		}
	}
}
