package modelo;

public class Principal {
	
	private Lista lista;
	private Paquete paquete;
	
	public Principal() {
		lista=new Lista();
		paquete=new Paquete();
	}
	
	public void imprimir() {
		System.out.println("Numeros impares en la lista: "+lista.imPares(paquete.darImpares()));
		System.out.println(lista.listar());
	}
	
	public static void main(String[] args) {
		Principal principal=new Principal();
		principal.imprimir();
	}
}
