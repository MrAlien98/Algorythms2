package hilos;

import interfaz.VentanaPrincipal;

public class HiloMoverUsuario extends Thread{

	private boolean parar;
	private VentanaPrincipal ventana;
	
	public HiloMoverUsuario(VentanaPrincipal ventana) {
		this.ventana=ventana;
		parar=false;
	}
	
	public void setParar(boolean parar) {
		this.parar=parar;
	}
	
	@Override
	public void run() {
		while(parar==false) {
			ventana.getGame().moverDerecha();
			try {
				sleep(10);
				ventana.repaint();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
