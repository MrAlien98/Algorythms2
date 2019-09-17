package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Jugador;

@SuppressWarnings("serial")
public class PanelListaJugador extends JPanel implements ActionListener, ListSelectionListener{

	public static final String AGREGAR="Agregar";
	public static final String ELIMINAR="Eliminar";
	public static final String BUSCAR="Buscar";
	public static final String GUARDAR="Guardar";
	
	private JButton butAgregar;
	private JButton butEliminar;
	private JButton butBuscar;
	private JButton butGuardar;
	
	private JList<Jugador> listaJugadores;
	
	private VentanaPrincipal ventana;
	
	public PanelListaJugador(VentanaPrincipal ventana) {
		this.ventana=ventana;
		
		butAgregar=new JButton("Agregar");
		butAgregar.setActionCommand(AGREGAR);
		butAgregar.addActionListener(this);
		
		butBuscar=new JButton("Buscar");
		butBuscar.setActionCommand(BUSCAR);
		butBuscar.addActionListener(this);
		
		butEliminar=new JButton("Eliminar");
		butEliminar.setActionCommand(ELIMINAR);
		butEliminar.addActionListener(this);
		
		butGuardar=new JButton("Guardar");
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener(this);
			
		setLayout(new BorderLayout());
		setSize(204, 370);
		TitledBorder border= BorderFactory.createTitledBorder("Jugadores");
		setBorder(border);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,4));
		panel.add(butAgregar);
		panel.add(butBuscar);
		panel.add(butEliminar);
		panel.add(butGuardar);
		
		add(panel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equals(AGREGAR)) {
			ventana.limpiarCampos();
		}else if(comando.equals(BUSCAR)) {
		
		}else if(comando.equals(ELIMINAR)) {
			
		}else if(comando.equals(GUARDAR)) {
			
		}
				
	}

	public void jList() {
		listaJugadores=new JList<Jugador>();
		listaJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaJugadores.setLayoutOrientation(JList.VERTICAL);
		listaJugadores.addListSelectionListener(this);
		JScrollPane scroll=new JScrollPane(listaJugadores);
		add(scroll, BorderLayout.CENTER);
	}
	
	public void llenarJList(Jugador[] jugadores) {
		DefaultListModel<Jugador> listModel=new DefaultListModel<Jugador>();
		for(Jugador nombre : jugadores) {
			listModel.addElement(nombre);
		}
		listaJugadores=new JList<Jugador>(listModel);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		Jugador j=listaJugadores.getSelectedValue();
		
	}
	
	
}
