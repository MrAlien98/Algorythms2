package hilos;

import modelo.Juego;
import interfaz.VentanaPrincipal;

//FindingDory5.0
public class HiloPez extends Thread{
	
	private VentanaPrincipal ventana;
	
	public HiloPez(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	public void run() {
		boolean we=false;
		try {
			while(!we) {
					for(int i=0;i<ventana.darPeces().getPeces().length;i++) {
						ventana.darPeces().getPeces()[i].mover();
					}
				sleep(5);
				ventana.repaint();
				ventana.darPeces().reiniciar();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
