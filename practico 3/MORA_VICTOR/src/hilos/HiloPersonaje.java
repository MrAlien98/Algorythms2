package hilos;

import modelo.Pokemon;
import interfaz.VentanaPrincipal;

public class HiloPersonaje extends Thread{

	private Pokemon unPer;
	private VentanaPrincipal vpr;
	
	public HiloPersonaje(Pokemon unPer, VentanaPrincipal vpr) {
		this.unPer=unPer;
		this.vpr=vpr;
	}
	
	public void run() {
		while(unPer.isDetenido()==false) {
			unPer.avanzar(5);
			try {
				sleep(20);
			}catch(Exception e) {
				e.printStackTrace();
			}
			vpr.refrescar();
		}
	}
	
	
	
	
	
}
