package hilos;

import interfaz.VentanaPrincipal;

public class HiloDisparoEnemigo extends Thread{

	private VentanaPrincipal ventana;
	private boolean muertas;
	
	public HiloDisparoEnemigo(VentanaPrincipal ventana) {
		this.ventana=ventana;
		muertas=false;
	}
	
	public void setMuertas(boolean muertas) {
		this.muertas=muertas;
	}
	
	@Override
	public void run() {
		while(muertas==false) {
			for(int i=0;i<ventana.darJuego().getNaves().size();i++) {
				ventana.darJuego().getNaves().get(i).disparar();
			}try {
				sleep(20);
				ventana.repaint();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
