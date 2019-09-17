package modelo;

import java.io.*;

public class Gimnasio {
	
	private Pokemon pokemon;
	
	private Pokebola poke1;
	private Pokebola poke2;
	private Pokebola poke3;
	
	public Gimnasio() {
		this.pokemon = new Pokemon(500, 300);
		poke1=new Pokebola("/data/pokeBall.png", new Pokemon(500, 300));
		poke1.getPokemon().setRuta("/data/charizard.gif");
		poke2=new Pokebola("/data/pokeBall.png", new Pokemon(500, 200));
		poke2.getPokemon().setRuta("/data/weird.gif");
		poke3=new Pokebola("/data/pokeBall.png", new Pokemon(500, 100));
		poke3.getPokemon().setRuta("/data/pato.gif");
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
	
	public Pokebola getPoke1() {
		return poke1;
	}

	public void setPoke1(Pokebola poke1) {
		this.poke1 = poke1;
	}

	public Pokebola getPoke2() {
		return poke2;
	}

	public void setPoke2(Pokebola poke2) {
		this.poke2 = poke2;
	}

	public Pokebola getPoke3() {
		return poke3;
	}

	public void setPoke3(Pokebola poke3) {
		this.poke3 = poke3;
	}
	
	
}
