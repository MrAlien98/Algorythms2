public class Hilo extends Thread{
	
	private Cliente cliente;
	private Cajera c;

	public Hilo(Cliente cliente, Cajera c){
		this.cliente=cliente;
		this.c=c;
	}

	public void setCliente(Cliente cliente){
		this.cliente=cliente;
	}

	public Cliente getCliente(){
		return cliente;
	}

	public void run(){
		try{
			c.procesarCompra(cliente);
			sleep((System.currentTimeMillis()-c.getTimeStamp())/1000);
		}catch(Exception e){

		}
	}

}