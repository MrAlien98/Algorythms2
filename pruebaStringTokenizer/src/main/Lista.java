package main;

public class Lista {

	private Persona cabeza;
	
	public Lista() {
		cabeza=null;
	}

	public Persona getCabeza() {
		return cabeza;
	}

	public void setCabeza(Persona cabeza) {
		this.cabeza = cabeza;
	}
	
	public void add(Persona actual, String iD, String name, String lastName, String email, String gender, String avatar) {
		if(cabeza==null) {
			cabeza=new Persona(iD, name, lastName, email, gender, avatar);
		}else if(actual.getSiguiente()==null) {
			actual.setSiguiente(new Persona(iD, name, lastName, email, gender, avatar));
		}else {
			add(actual.getSiguiente(), iD, name, lastName, email, gender, avatar);
		}
	}
	
	public String listar() {
		String jeje="";
		Persona actual=cabeza;
		while(actual!=null) {
			jeje+=actual.toString()+"\n";
			actual=actual.getSiguiente();
		}
		return jeje;
	}
	
}
