package interfaz;

import java.awt.*;
import javax.swing.*;

import modelo.Mundial;
import modelo.Seleccion;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{

	private Mundial pModelo;
	private PanelJugadorSeleccionado pJS;
	private PanelSeleccion pS;
	private PanelListaJugador pLJ;
	private PanelAgregarSeleccion pAS;
	
	public VentanaPrincipal() {
		pModelo=new Mundial();
		pJS=new PanelJugadorSeleccionado(this);
		pS=new PanelSeleccion(this);
		pLJ=new PanelListaJugador(this);
		pAS=new PanelAgregarSeleccion(this);
		pAS.setVisible(false);
		
		setSize(1000, 500);
		setVisible(true);
		setResizable(false);
		setTitle("Copa Mundial de la FIFA");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("src/Fotos/copa.png").getImage());
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,3));
		panel.add(pS);
		panel.add(pLJ);
		panel.add(pJS);
		
		add(panel, BorderLayout.CENTER);
		fillJList();
		pack();
	}
	
	public void limpiarCampos() {
		pJS.getTxtNombre().setText(null);
		pJS.getTxtPosicion().setText(null);
		pJS.getTxtAltura().setText(null);
		pJS.getTxtNacimiento().setText(null);
		pJS.getTxtPuntajeFifa().setText(null);	
	}
	
	public void limpiarCampos2() {
		pAS.getTxtPais().setText(null);
		pAS.getTxtPromAltura().setText(null);
		pAS.getTxtPromEdad().setText(null);
		pAS.getTxtPromFifa().setText(null);
		pAS.getTxtPuntos().setText(null);
		pAS.getLabImgPais().setIcon(null);
	}
	
	public void mostrarCampos() {
		pAS.setVisible(true);
		limpiarCampos2();
	}
	
	public void agregarSeleccion(String pais, String puntos, String imagen) {
		int ptos=Integer.parseInt(puntos);
		pModelo.add(pais, ptos, imagen);
		pAS.setVisible(false);
		fillJList();
	}
	
	public void fillJList() {
		pS.llenarJList(pModelo.toArray());
	}
	
	public void seleccionElegida(Seleccion p) {
		pLJ.llenarJList(p.toArray());
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana=new VentanaPrincipal();
	}
	
}
