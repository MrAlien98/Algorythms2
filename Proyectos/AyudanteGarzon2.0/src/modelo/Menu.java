package modelo;

import java.util.*;

public class Menu {

	private String nombre;
	private ArrayList<Platillo> platillos;
	
	public Menu(String nombre) {
		this.nombre = nombre;
		platillos=(new ArrayList<Platillo>());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Platillo> getPlatillos() {
		return platillos;
	}
	
	public ArrayList<String> getPlatillosN() {
		ArrayList<String> platillosN=new ArrayList<String>(); 
		for(int i=0;i<this.platillos.size();i++) {
			platillosN.add(getPlatillos().get(i).getNombre()+" : "+getPlatillos().get(i).getCosto());
		}
		return platillosN;
	}
	
	
}
