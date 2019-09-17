package interfaz;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class DialogPartida extends JDialog {

	private VentanaPrincipal ventana;
	private PanelJuego pJ;
	
	public DialogPartida(VentanaPrincipal ventana) {
		this.ventana=ventana;
		pJ=new PanelJuego(ventana);
		
		setSize(975, 665);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Galaxian");
		setLayout(new BorderLayout());
		
		add(pJ, BorderLayout.CENTER);
		
	}
	
	
}
