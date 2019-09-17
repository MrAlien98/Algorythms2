package hilos;

import interfaz.VentanaPrincipal;

//FindingDory5.0
public class HiloPez extends Thread{
	
	private VentanaPrincipal ventana;
	private int time;
	
	public HiloPez(VentanaPrincipal ventana, int time) {
		this.ventana = ventana;
		this.time=time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void run() {
		boolean we=false;
		try {
			while(!we) {
				for(int i=0;i<ventana.darJuego().getPeces().length;i++) {
					ventana.darJuego().getPeces()[i].mover();
				}
				sleep(time);
				ventana.repaint();
				ventana.darJuego().reiniciar();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
