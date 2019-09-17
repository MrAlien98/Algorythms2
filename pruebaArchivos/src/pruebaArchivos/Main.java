package pruebaArchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader lector=new BufferedReader(new FileReader("src/Entrada.txt"));
		BufferedWriter escribir=new BufferedWriter(new FileWriter(new File("src/Salida.txt")));
		PrintWriter escritor = new PrintWriter(new FileWriter("src/Salida.txt"), true);
		
		String linea;
		
		while((linea=lector.readLine())!=null) {
			StringTokenizer dividir=new StringTokenizer(linea);
			
			int suma=0;
			
			while(dividir.hasMoreElements()){
				suma+=Integer.parseInt(dividir.nextToken());
			}
			
			escritor.println(suma);
		}
		
		escritor.flush();
		
		escritor.close();
		
		lector.close();
	}

}
