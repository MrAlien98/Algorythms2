package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelJugadorSeleccionado extends JPanel implements ActionListener{
	
	public static final String ANTERIOR="Anterior";
	public static final String PRIMERO="Primero";
	public static final String SIGUIENTE="Siguiente";
	
	private JButton butAnterior;
	private JButton butPrimero;
	private JButton butSiguiente;
	
	private JLabel labImagen;
	private JLabel labNombre;
	private JLabel labPosicion;
	private JLabel labPuntajeFifa;
	private JLabel labNacimiento;
	private JLabel labAltura;
	
	private JTextField txtNombre;
	private JTextField txtPosicion;
	private JTextField txtPuntajeFifa;
	private JTextField txtNacimiento;
	private JTextField txtAltura;
	
	private VentanaPrincipal ventana;
	
	public PanelJugadorSeleccionado(VentanaPrincipal ventana) {
		this.ventana=ventana;
		
		butAnterior=new JButton("Anterior");
		butAnterior.setActionCommand(ANTERIOR);
		butAnterior.addActionListener(this);
		
		butSiguiente=new JButton("Siguiente");
		butSiguiente.setActionCommand(SIGUIENTE);
		butSiguiente.addActionListener(this);
		
		butPrimero=new JButton("Primero");
		butPrimero.setActionCommand(PRIMERO);
		butPrimero.addActionListener(this);
		
		labImagen=new JLabel();
		labNombre=new JLabel("Nombre");
		labPosicion=new JLabel("Posicion");
		labPuntajeFifa=new JLabel("Puntaje FIFA");
		labNacimiento=new JLabel("Fecha Nacimiento");
		labAltura=new JLabel("Altura");
		
		txtNombre=new JTextField();
		txtPosicion=new JTextField();
		txtPuntajeFifa=new JTextField();
		txtNacimiento=new JTextField();
		txtAltura=new JTextField();
		
		setLayout(new BorderLayout());
		setSize(306, 361);
		TitledBorder border= BorderFactory.createTitledBorder("Jugador");
		setBorder(border);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,3));
		panel.add(butAnterior);
		panel.add(butSiguiente);
		panel.add(butPrimero);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(6,2));
		panel2.add(labNombre);
		panel2.add(txtNombre);
		panel2.add(labPosicion);
		panel2.add(txtPosicion);
		panel2.add(labPuntajeFifa);
		panel2.add(txtPuntajeFifa);
		panel2.add(labNacimiento);
		panel2.add(txtNacimiento);
		panel2.add(labAltura);
		panel2.add(txtAltura);
		
		JPanel panel3=new JPanel();
		panel3.setSize(100, 200);
		panel3.add(labImagen);
		
		add(panel, BorderLayout.SOUTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.NORTH);
		
	}	

	public JTextField getTxtNombre() {
		return txtNombre;
	}



	public JTextField getTxtPosicion() {
		return txtPosicion;
	}



	public JTextField getTxtPuntajeFifa() {
		return txtPuntajeFifa;
	}



	public JTextField getTxtNacimiento() {
		return txtNacimiento;
	}



	public JTextField getTxtAltura() {
		return txtAltura;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equals(ANTERIOR)) {
			
		}else if(comando.equals(PRIMERO)) {
			
		}else if(comando.equals(SIGUIENTE)) {
			
		}
	}
}
