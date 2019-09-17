package interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelDatos extends JPanel{

	private JLabel labNick;
	private JLabel labNombre;
	
	private JLabel labPuntaje;
	private JTextField txtPtos;
	
	private JLabel labNivel;
	private JTextField txtLvl;
	
	private VentanaPrincipal ventana;
	
	public PanelDatos(String nick, int p, int lvl, VentanaPrincipal ventana) {
		this.ventana=ventana;
		
		labNick=new JLabel("Jugador:");
		labNombre=new JLabel(""+nick);
		
		labPuntaje=new JLabel("Puntaje:");
		txtPtos=new JTextField(""+p);
		txtPtos.setEditable(false);
		
		labNivel=new JLabel("Nivel:");
		txtLvl=new JTextField();
		txtLvl.setEditable(false);
		txtLvl.setText(""+lvl);
		
		setLayout(new GridLayout(1,6));
		TitledBorder border= BorderFactory.createTitledBorder("Juego");
		setBorder(border);
		
		add(labNick);
		add(labNombre);
		
		add(labPuntaje);
		add(txtPtos);
		
		add(labNivel);
		add(txtLvl);
	}

	public JLabel getLabNombre() {
		return labNombre;
	}

	public JTextField getTxtPtos() {
		return txtPtos;
	}

	public JTextField getTxtLvl() {
		return txtLvl;
	}

	
}

