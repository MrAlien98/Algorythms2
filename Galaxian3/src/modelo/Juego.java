package modelo;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Juego implements Serializable{
	
	public static final int LARGO_VENTANA=665;
	public static final int ANCHO_VENTANA=975;

	private Nave primera;
	
	private Usuario primero;
	
	public Juego() {
		primera=null;
		primero=null;
	
		inicializarNaves();
	}
	
	public void inicializarNaves() {
		agregarNaves(new NaveEnemiga(Nave.AZUL, 283, 150, Nave.LARGO, Nave.ANCHO, null, 300));//primero
		agregarNaves(new NaveEnemiga(Nave.VERDE, 333, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 383, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.REINA,433, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.AZUL, 483, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.VERDE, 533, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 583, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.REINA, 633, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.AZUL, 683, 150, Nave.LARGO, Nave.ANCHO, null, 300));//ultimo
		agregarNaves(new NaveEnemiga(Nave.VERDE, 364, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 414, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.REINA, 464, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.AZUL, 514, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.VERDE, 564, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 614, 110, Nave.LARGO, Nave.ANCHO, null, 300));
	}
	
	public Nave getPrimera() {
		return primera;
	}

	public void setPrimera(Nave primera) {
		this.primera = primera;
	}

	public Usuario getPrimero() {
		return primero;
	}

	public void setPrimero(Usuario primero) {
		this.primero = primero;
	}

	public ArrayList<Nave> getNaves() {
		ArrayList<Nave> naves=new ArrayList<Nave>();
		Nave temp=primera;
		while(temp!=null){
			naves.add(temp);
			temp=temp.getSiguiente();
		}
		return naves;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> naves=new ArrayList<Usuario>();
		Usuario temp=primero;
		while(temp!=null){
			naves.add(temp);
			temp=temp.getSiguiente();
		}
		return naves;
	}
	
	public void guardar() {
		try {
			//Creo flujo de datos externo
			ObjectOutputStream escribir=new ObjectOutputStream(/**Indico la ruta de donde se va a guardar*/new FileOutputStream("src/daros/usuarios.dat"));
			escribir.writeObject(primero);
			escribir.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarNaves(Nave nueva) {
		if(primera==null) {
			primera=nueva;
		}else {
			Nave temp=primera;
			Nave nuevo=nueva;
			nuevo.setSiguiente(temp);
			primera=nuevo;
		}
	}
	
	public void agregarUsuario(String nick, int puntaje, int nivel, int vidas) {
		Usuario nuevo=new Usuario(nick, puntaje, nivel, vidas);
		if(primero==null) {
			primero=nuevo;
		}else {
			Usuario temp=primero;
			Usuario n=nuevo;
			n.setSiguiente(temp);
			primero=nuevo;
		}
	}
	
	public Usuario buscarUsuarioMayorPuntaje() {
		Usuario ret=primero;
		ret=getUsuarios().get(0);
		for(int j=1;j<getUsuarios().size();j++) {
			if(ret.getPuntaje()<getUsuarios().get(j).getPuntaje()) {
				ret=getUsuarios().get(j);
			}
		}
		return ret;
	}
	
	
}
