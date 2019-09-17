package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.security.SecureRandom;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Juego implements Serializable{

	public static final int ANCHO_VENTANA=360;
	public static final int ALTO_VENTANA=621;
	
	private Usuario usuario;
	private ABBUsuario arbolUsuarios;
	
	private ListaEnemigo listaEnemigos;
	private ListaEnemigo listaEnemigosA;
	
	private ArrayList<Usuario> usuarios;
		
	public Juego() {				
		usuario=new Usuario("Mora");
		
		cargarEnemigos();
	}
	
	public void cargarUsuarios(String nombre) {
		try {
			ObjectInputStream cargarUsuarios=new ObjectInputStream(new FileInputStream("src/usuarios/arbol.dat"));
			arbolUsuarios=(ABBUsuario)cargarUsuarios.readObject();
			cargarUsuarios.close();
		}catch(Exception e) {
			arbolUsuarios=new ABBUsuario();
		}finally {
			usuario=new Usuario(nombre);
		}
	}
	
	public void guardarUsuarios() {
		arbolUsuarios.add(arbolUsuarios.getRaiz(), usuario);
		try {
			ObjectOutputStream salvar=new ObjectOutputStream(new FileOutputStream("src/usuarios/arbol.dat"));
			salvar.writeObject(arbolUsuarios);
			salvar.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarEnemigos() {
		try {
			ObjectInputStream cargar=new ObjectInputStream(new FileInputStream("src/save/NormalEnemies.dat"));
			listaEnemigos=(ListaEnemigo) cargar.readObject();
			cargar.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarEnemigosAgresivos() {
		try {
			ObjectInputStream cargar=new ObjectInputStream(new FileInputStream("src/save/AtackingEnemies.dat"));
			setListaEnemigosA((ListaEnemigo)cargar.readObject());
			cargar.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int buscarUsuarioMayorPuntaje() {
		int mayor=0;
		for(int i=1;i<usuarios.size();i++) {
			Usuario porInsertar=(Usuario)usuarios.get(i);
			boolean termino=false;
			for(int j=i;j>0 && !termino;j--) {
				Usuario actual=(Usuario)usuarios.get(j-1);
				if(actual.compareTo(porInsertar)>0) {
					usuarios.set(j, actual);
					usuarios.set(j-1, porInsertar);
				}else {
					termino=true;
				}
			}
		}
		mayor=usuarios.get(0).getPuntos();
		return mayor;
	}
	
	public String ordenPuntos() {
		String end="";
		for(int i=1;i<usuarios.size();i++) {
			Usuario porInsertar=(Usuario)usuarios.get(i);
			boolean termino=false;
			for(int j=i;j>0 && !termino;j--) {
				Usuario actual=(Usuario)usuarios.get(j-1);
				if(actual.compareTo(porInsertar)>0) {
					usuarios.set(j, actual);
					usuarios.set(j-1, porInsertar);
				}else {
					termino=true;
				}
			}
		}
		for(int m=0;m<usuarios.size();m++) {
			int j=m+1;
			end+=""+j+")"+usuarios.get(m)+" ";
			end+="\n";
		}
		return end;
	}
	
	public String busquedaBinaria(int valor) {
		boolean encontre=false;
		int inicio=0;
		int medio=0;
		int fin=usuarios.size()-1;
		while(inicio<=fin && !encontre){
				medio=(inicio+fin)/2;
			if(usuarios.get(medio).getPuntos()==valor){
				encontre=true;
			}else if(usuarios.get(medio).getPuntos()>valor){
				fin=medio-1;
			}else{
				inicio=medio+1;
			}
		}
		return usuarios.get(medio).toString();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void moverDerecha() {
		usuario.moverDerecha();
	}
	
	public void moverIzquierda() {
		usuario.moverIzquierda();
	}
	
	public ListaEnemigo getListaEnemigos() {
		return listaEnemigos;
	}

	public void setListaEnemigos(ListaEnemigo listaEnemigos) {
		this.listaEnemigos = listaEnemigos;
	}

	public ABBUsuario getArbolUsuarios() {
		return arbolUsuarios;
	}

	public void setArbolUsuarios(ABBUsuario arbolUsuarios) {
		this.arbolUsuarios = arbolUsuarios;
	}

	public ListaEnemigo getListaEnemigosA() {
		return listaEnemigosA;
	}

	public void setListaEnemigosA(ListaEnemigo listaEnemigosA) {
		this.listaEnemigosA = listaEnemigosA;
	}
	
}