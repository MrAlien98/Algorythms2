package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Seleccion;

@SuppressWarnings("serial")
public class PanelSeleccion extends JPanel implements ActionListener, ListSelectionListener{

	public static final String AGREGAR="Agregar";
	public static final String ELIMINAR="Eliminar";
	public static final String BUSCAR="Buscar";
	public static final String GUARDAR="Guardar";
	
	private JButton butAgregar;
	private JButton butEliminar;
	private JButton butBuscar;
	private JButton butGuardar;
	
	private JList<Seleccion> listaSelecciones;
		
	private VentanaPrincipal ventana;
	
	public PanelSeleccion(VentanaPrincipal ventana) {
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
		setSize(306, 361);
		TitledBorder border= BorderFactory.createTitledBorder("Selecciones");
		setBorder(border);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,4));
		panel.add(butAgregar);
		panel.add(butBuscar);
		panel.add(butEliminar);
		panel.add(butGuardar);
		
		jList();
		
		add(panel, BorderLayout.SOUTH);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equals(AGREGAR)) {
			ventana.mostrarCampos();
		}else if(comando.equals(BUSCAR)) {
			
		}else if(comando.equals(ELIMINAR)) {
			
		}else if(comando.equals(GUARDAR)) {
			
		}
	}
	
	public void jList() {
		listaSelecciones=new JList<Seleccion>();
		listaSelecciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaSelecciones.setLayoutOrientation(JList.VERTICAL);
		listaSelecciones.addListSelectionListener(this);
		JScrollPane scroll=new JScrollPane(listaSelecciones);
		add(scroll, BorderLayout.CENTER);
	}
	
	public void llenarJList(Seleccion[] selecciones) {
		DefaultListModel<Seleccion> listModel=new DefaultListModel<Seleccion>();
		for(Seleccion nombre: selecciones) {
			listModel.addElement(nombre);
		}
		listaSelecciones.setModel(listModel);		
	}


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		Seleccion pais=listaSelecciones.getSelectedValue();
		ventana.seleccionElegida(pais);
	}
	
	
	
	
	
	
	
	
	
	

}