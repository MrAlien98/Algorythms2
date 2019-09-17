package Main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Principal {

	private ArrayList<int[]> arreglos;
	private Random aleatorio;
	
	public Principal() {
		arreglos=new ArrayList<int[]>();
		aleatorio=new Random();
		crearArreglos();
	}
	
	public ArrayList<int[]> darArreglos() {
		return arreglos;
	}
	
	public void crearArreglos() {
		int f=0;
		for(int i=0;i<100;i++) {
			f=aleatorio.nextInt(1000)+10;
			int[] n=new int[f];
			for(int j=0;j<n.length;j++) {
				f=aleatorio.nextInt(1000);
				n[j]=f;
			}
			arreglos.add(n);
		}
		burbuja(darArreglos());
		insercion(darArreglos());
		seleccion(darArreglos());
	}
	
	public void burbuja(ArrayList<int[]> llega) {
		String finl="";
		ArrayList<int[]> arreglo=llega;
		for(int i=0;i<arreglo.size();i++) {
			int[] n=arreglo.get(i);
			long principio=System.nanoTime();
			ordenarBurbuja(n);
			long finish=System.nanoTime();
			finl+=(finish-principio)+"\n";
		}
		nanoBurbuja(finl);
	}
	
	public void ordenarBurbuja(int[] n) {
		for(int l=n.length-1;l>0;l--) {
			for(int j=0;j<l;j++) {
				if(n[j]>n[j+1]) {
					int temp=n[j];
					n[j]=n[j+1];
					n[j+1]=temp;
				}
			}
		}
	}
	
	public void insercion(ArrayList<int[]> llega) {
		String fin="";
		ArrayList<int[]> arreglo=llega;
		for(int i=0;i<arreglo.size();i++) {
			int[] n=arreglo.get(i);
			long principio=System.nanoTime();
			ordenarInsercion(n);
			long finish=System.nanoTime();
			fin+=finish-principio+"\n";
		}
		nanoInsercion(fin);
	}
	
	public void ordenarInsercion(int[] n) {
		for(int j=1;j<n.length-1;j++) {
			for(int l=j;l>0 && n[l-1]>n[l];l++) {
				int temp=n[l];
				n[l]=n[l-1];
				n[l-1]=temp;
			}
		}
	}
	
	public void seleccion(ArrayList<int[]> llega) {
		String fin="";
		ArrayList<int[]> arreglo=llega;
		for(int l=0;l<arreglo.size();l++) {
			int[] n=arreglo.get(l);
			long principio=System.nanoTime();
			ordenarSeleccion(n);
			long finish=System.nanoTime();
			fin+=finish-principio+"\n";
		}
		nanoSeleccion(fin);
	}
	
	public void ordenarSeleccion(int[] n) {
		for(int i=0;i<n.length-1;i++) {
			int menor=n[i];
			int cual=i;
			for(int j=i+1;j<n.length;j++) {
				if(n[j]<menor) {
					cual=j;
				}
			}
			int temp=n[i];
			n[i]=menor;
			n[cual]=temp;
		}
	}
	
	public void nanoBurbuja(String burbuja) {
		File archivo=new File("src/Burbuja.txt");
		try {
			PrintWriter escribir = new PrintWriter(archivo); 
			escribir.write(burbuja);
			escribir.close();
		}catch(IOException e) {
			
		}
	}
	
	public void nanoInsercion(String insercion) {
		File archivo=new File("src/Insercion.txt");
		try {
			PrintWriter escribir = new PrintWriter(archivo); 
			escribir.write(insercion);
			escribir.close();
		}catch(IOException e) {
			
		}
	}
	
	public void nanoSeleccion(String seleccion) {
		File archivo=new File("src/Seleccion.txt");
		try {
			PrintWriter escribir = new PrintWriter(archivo); 
			escribir.write(seleccion);
			escribir.close();
		}catch(IOException e) {
			
		}
	}
	
	public static void main (String[] args) {
		Principal principal=new Principal();
	}
}