package modelo;

public class Mundial { 

	private Seleccion raiz;
	
	public Mundial() {
		raiz=null;
	}
	
	
	public Seleccion darCabeza() {
		return raiz;
	}
	
	public void setCabeza(Seleccion cabeza) {
		this.raiz=cabeza;
	}
	
	public void insertarNodo(Seleccion insertar){
		 if(raiz == null) {
			 raiz=insertar; //crea nodo raiz
		 }else {
			 raiz.insertar(insertar); //llama al metodo insertar
		 }
	 }
}
