package hilos;

import interfaz.VentanaPrincipal;

public class HiloMoverEnemigos extends Thread{

	private VentanaPrincipal ventana;
	private boolean muertas;
	
	public HiloMoverEnemigos(VentanaPrincipal ventana) {
		this.ventana=ventana;
		muertas=false;
	}
	
	public void setMuertas(Boolean muertas) {
		this.muertas=muertas;
	}
	
	public boolean areMuertas() {
		return muertas;
	}
	
	@Override
	public void run() {
		while(muertas==false) {
			for(int i=0;i<ventana.darJuego().getNaves().size();i++) {
				ventana.darJuego().getNaves().get(i).mover(0);
			}
			try {
				sleep(150);
				ventana.repaint();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
