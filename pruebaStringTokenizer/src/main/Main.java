package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static Lista lista;
	
	public Main() {
		lista=new Lista();
	}
	
	public static void add(String iD, String name, String lastName, String email, String gender, String avatar) {
		lista.add(lista.getCabeza(), iD, name, lastName, email, gender, avatar);
	}
	
	public static Lista getLista() {
		return lista;
	}
	
	public static void main(String[] ars) throws IOException {
		Main m=new Main();
		BufferedReader lector=new BufferedReader(new FileReader("src/main/MOCK_DATA (1).csv"));
		
		String linea;
		
		while((linea=lector.readLine())!=null) {
			String[] wepa=linea.split(",");
			Main.add(wepa[0], wepa[1], wepa[2], wepa[3], wepa[4], wepa[5]);
//			izq menores que la raiz derechos mayores que la raiz: ABB ordenado
		}
		lector.close();
		
		System.out.println(Main.getLista().listar());
	}
	
}
