package hilos;

import modelo.Pokemon;
import application.Main;

public class HiloPersonaje extends Thread{

	private Pokemon unPer;
	private Main m;
	
	public HiloPersonaje(Pokemon unPer, Main m) {
		this.unPer=unPer;
		this.m=m;
	}
	
	public void run() {
		while(unPer.isDetenido()==false) {
			unPer.avanzar(5);
			m.actualizar();
			m.getCanvas().actualizar();
			try {
				sleep(20);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
