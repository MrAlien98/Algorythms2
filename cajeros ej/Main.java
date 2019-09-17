public class Main {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		Cajera cajera1 = new Cajera("Cajera 1", 0);
		Cajera cajera2 = new Cajera("Cajera 2", 0);

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		cajera1.setTimeStamp(initialTime);
		cajera2.setTimeStamp(initialTime);

		Hilo hilo1=new Hilo(cliente1, cajera1);
		Hilo hilo2=new Hilo(cliente2, cajera2);
		hilo1.start();hilo2.start();
	}
}