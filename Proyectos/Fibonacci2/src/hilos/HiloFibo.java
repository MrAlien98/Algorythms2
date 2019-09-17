package hilos;

import application.Main;

public class HiloFibo extends Thread {

	@SuppressWarnings("unused")
	private Main main;
	
	public HiloFibo(Main main) {
		this.main=main;
	}
	
	@Override
	public void run() {
		Main.mostrar();
	}
	
}
