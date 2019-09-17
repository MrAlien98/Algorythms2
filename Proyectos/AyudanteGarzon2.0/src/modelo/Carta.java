package modelo;

import java.util.*;

public class Carta {

	private ArrayList<Menu> menus;
	
	public Carta() {
		menus=new ArrayList<Menu>();
		menus.add(new Menu("Ejecutivo"));
		menus.get(0).getPlatillos().add(new Platillo("Milanesa con papas y arroz", 12500));
		menus.get(0).getPlatillos().add(new Platillo("Milanesa con papas y arroz", 12500));
		menus.add(new Menu("Empresarial"));
		menus.get(1).getPlatillos().add(new Platillo("Coctel de camarones", 60000));
		menus.get(1).getPlatillos().add(new Platillo("Coctel de camarones", 60000));
		menus.add(new Menu("Corrientazo alv"));
		menus.get(2).getPlatillos().add(new Platillo("Calentao de frijoles", 5000));
		menus.get(2).getPlatillos().add(new Platillo("Calentao de frijoles", 5000));
		menus.add(new Menu("Infantil"));
		menus.get(3).getPlatillos().add(new Platillo("Cajita Feliz McDonaldTrump", 20000));
		menus.get(3).getPlatillos().add(new Platillo("Cajita Feliz McDonaldTrump", 20000));
	}
	
	public ArrayList<Menu> getMenu(){
		return menus;
	}
	
	public ArrayList<String> getMenuN(){
		ArrayList<String> menusN=new ArrayList<String>();
		for(int i=0;i<this.menus.size();i++) {
			menusN.add(getMenu().get(i).getNombre());
		}
		return menusN;
	}
	
	
	
}
