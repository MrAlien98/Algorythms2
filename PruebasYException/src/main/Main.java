package main;

import metodo.Metodo;
import exception.ValorNuloEnArreglo;
import javax.swing.*;

public class Main {
	
	private Metodo metodo;
	
	public Main() {
		metodo=new Metodo();
		verError();
		mostrar();
	}
	
	int uno=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero"));
	int dos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero"));
	int tres=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero"));
	int four=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero"));
	
	Integer[] a = {uno, dos, tres, four};
	
	public String verError() {
		Integer[] f=null;
		String m="";
		try {
			f=metodo.incognito(a).clone();
		}
		catch (ValorNuloEnArreglo vN){
			System.out.println(vN.getMessage());
		}
		for(int i=0;i<f.length;i++) {
			m+=f[i]+",";
		}
		return m;
	}
	
	public void mostrar() {
		JOptionPane.showMessageDialog(null, ""+verError());
	}
	
	public static void main(String[] args) {
		Main main=new Main();
	}


}
