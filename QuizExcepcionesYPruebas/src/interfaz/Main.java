package interfaz;

import modelo.Principal;

import java.util.Scanner;

import excepciones.OutOfBounds;

public class Main {

	private Principal p;
	
	public Main() {
		p=new Principal();
	}
	
	@SuppressWarnings("resource")
	public void auxiliar() {
		Scanner leer=new Scanner(System.in);
		System.out.println("Ingrese una cadena de texto: ");
		String cadena=leer.nextLine();
		System.out.println("Ingrese una posicion: ");
		int pos=leer.nextInt();
		try {
			System.out.println(p.auxiliar(cadena, pos));
		}catch(OutOfBounds e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Main main=new Main();
		main.auxiliar();
	}

}
