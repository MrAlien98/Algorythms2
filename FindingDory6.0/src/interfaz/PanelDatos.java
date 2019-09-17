package interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelDatos extends JPanel{

	private JLabel labNick;
	private JLabel labNombre;
	
	private JLabel labPuntaje;
	private JLabel labPtos;
	
	private JLabel labNivel;
	private JLabel labLvl;
	
	public PanelDatos(String nick, int p, int lvl) {
		labNick=new JLabel("Jugador:");
		labNombre=new JLabel(""+nick);
		
		labPuntaje=new JLabel("Puntaje:");
		labPtos=new JLabel(""+Integer.toString(p));
		
		labNivel=new JLabel("Nivel:");
		labLvl=new JLabel(""+Integer.toString(lvl));
		
		setLayout(new GridLayout(1,6));
		TitledBorder border= BorderFactory.createTitledBorder("Juego");
		setBorder(border);
		
		add(labNick);
		add(labNombre);
		add(labPuntaje);
		add(labPtos);
		add(labNivel);
		add(labLvl);
	}
}

