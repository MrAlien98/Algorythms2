package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelAgregarSeleccion extends JFrame implements ActionListener{

	public static final String GUARDAR="Guardar";
	public static final String IMAGEN="Imagen";
	
	private JButton butImg;
	private JButton butGuardar;
	
	private JLabel labPais;
	private JLabel labPuntos;
	private JLabel labPromAltura;
	private JLabel labPromEdad;
	private JLabel labPromFifa;
	private JLabel labImg;
	private JLabel labImgPais;
	
	private JTextField txtPais;
	private JTextField txtPuntos;
	private JTextField txtPromAltura;
	private JTextField txtPromEdad;
	private JTextField txtPromFifa;
	
	private VentanaPrincipal ventana;
	
	public PanelAgregarSeleccion(VentanaPrincipal ventana) {
		
		setLayout(new GridLayout(1,2));
		setSize(767, 352);
		setTitle("jugador");
		
		this.ventana=ventana;
		
		butImg=new JButton("Imagen");
		butImg.setActionCommand(IMAGEN);
		butImg.addActionListener(this);
		
		butGuardar=new JButton("Guardar");
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener(this);
		
		labImg=new JLabel("Imagen");
		labImgPais=new JLabel();
		labImgPais.setSize(400, 300);
		labPais=new JLabel("País");
		labPuntos=new JLabel("Puntos");
		labPromAltura=new JLabel("Promedio Altura");
		labPromEdad=new JLabel("Promedio Edad");
		labPromFifa=new JLabel("Promedio FIFA");
		
		txtPais=new JTextField();
		txtPuntos=new JTextField();
		txtPromAltura=new JTextField();
		txtPromAltura.setEditable(false);
		txtPromEdad=new JTextField();
		txtPromEdad.setEditable(false);
		txtPromFifa=new JTextField();
		txtPromFifa.setEditable(false);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,1));
		TitledBorder border= BorderFactory.createTitledBorder("País");
		panel.setBorder(border);
		panel.add(labImgPais);
				
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(7,2));
		panel2.add(labPais);
		panel2.add(txtPais);
		panel2.add(labPuntos);
		panel2.add(txtPuntos);
		panel2.add(labPromAltura);
		panel2.add(txtPromAltura);
		panel2.add(labPromEdad);
		panel2.add(txtPromEdad);
		panel2.add(labPromFifa);
		panel2.add(txtPromFifa);
		panel2.add(labImg);
		panel2.add(butImg);
		panel2.add(butGuardar);
		
		add(panel);
		add(panel2);
	}
	
	public JTextField getTxtPais() {
		return txtPais;
	}

	public JTextField getTxtPuntos() {
		return txtPuntos;
	}

	public JTextField getTxtPromAltura() {
		return txtPromAltura;
	}

	public JTextField getTxtPromEdad() {
		return txtPromEdad;
	}

	public JTextField getTxtPromFifa() {
		return txtPromFifa;
	}

	public JLabel getLabImgPais() {
		return labImgPais;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(GUARDAR)) {
			String paisN=txtPais.getText();
			String nPuntos=txtPuntos.getText();
			String imagen=labImgPais.getIcon().toString();
			ventana.agregarSeleccion(paisN, nPuntos, imagen);
		}else if(e.getActionCommand().equals(IMAGEN)) {
			cargar();
		}
	}
	
	public void cargar(){
        String ruta="";
		JFileChooser fc=new JFileChooser(new File("C:\\Users\\1143876043\\Downloads\\MORA_VICTOR\\src\\ImgsPaises"));
        fc.setDialogTitle("Cargar Foto");
        int resultado=fc.showOpenDialog(null);
        if(resultado==JFileChooser.APPROVE_OPTION){
            File archivo=fc.getSelectedFile();
            ruta=archivo.getPath();
            labImgPais.setIcon(new ImageIcon(ruta));
        }
    }
	
	

}
