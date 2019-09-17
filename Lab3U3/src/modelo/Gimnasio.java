package modelo;

import java.io.*;

public class Gimnasio {
	
	private Pokemon pokemon;
	
	public Gimnasio() {
		this.pokemon = new Pokemon(500, 300);
	}
		
	public Pokemon darPokemon() {		
		return this.pokemon;
	}
	
	public void guardarArchivo(String nombreEntrenador) {
		File archivo=new File("src/nombres/entrenadores.txt");
		try {
			FileWriter aja=new FileWriter(archivo.getAbsolutePath(), true);
			BufferedWriter escribir=new BufferedWriter(aja);
			escribir.write(nombreEntrenador);
			escribir.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
