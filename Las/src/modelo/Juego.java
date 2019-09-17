package modelo;

import java.io.*;
import java.util.*;

public class Juego {
     
	private Pez[] peces;
	private Usuario usuario;
	private ArrayList<Usuario> usuarios;
	private ComparadorNombre comparator;

	public Juego() {
		String dory="src/fotos/dory.png";
		
		peces=new Pez[13];
		peces[0]= new Pez("src/fotos/gio.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[1]= new Pez(dory,-100, (int) (Math.random()*230)+1, 70, 70, 70);
		peces[2]= new Pez("src/fotos/nemo.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[3]= new Pez("src/fotos/shark.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[4]= new Pez("src/fotos/shark2.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[5]= new Pez("src/fotos/weird.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[6]= new Pez("src/fotos/weird2.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 90,90, 35);
		peces[7]= new Pez("src/fotos/flo.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[8]= new Pez("src/fotos/estrella.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[9]= new Pez("src/fotos/martillo.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[10]= new Pez("src/fotos/crab.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
		peces[11]= new Pez("src/fotos/raya.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 100,100, 50);
		peces[12]= new Pez("src/fotos/prof.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70, 35);
	}
	
	
	public void agregarUsuario(String nickname, String puntaje, String nivel) {
		try {
			//creo flujo de datos interno
			ObjectInputStream mostrar=new ObjectInputStream(/**Indico de donde voy a tomar el archivo a leer*/new FileInputStream("C:/Users/c/eclipse-workspace/Las/src/partidas/Usuarios.dat"));
			usuarios=(ArrayList<Usuario>) mostrar.readObject();//Retorna un objeto de tipo Object que debe ser casteado a ArrayList<Usuario>
			mostrar.close();
		}catch(Exception e) {
			usuarios=new ArrayList<Usuario>();
		}
		if(verificarNick(nickname)==false) {
			if(usuarios.size()<20) {
				usuarios.add(new Usuario(nickname, puntaje, nivel));
			}else {
				usuarios.remove(usuarios.size()-1);
				usuarios.add(new Usuario(nickname, puntaje, nivel));
			}
		}else {
			for(int i=0;i<usuarios.size();i++) {
				if(nickname.equalsIgnoreCase(usuarios.get(i).getNickname())){
					usuarios.get(i).setNivel(nivel);
					usuarios.get(i).setPuntaje(puntaje);
				}
			}
		}
		usuario=new Usuario(nickname, puntaje, nivel);
	}
	
	public ArrayList<Usuario> darUsuarios(){
		return usuarios;
	}
	
	public boolean verificarNick(String m){
		for(int i=0;i<usuarios.size();i++) {
			if(m.equalsIgnoreCase(usuarios.get(i).getNickname())){
				return true;
			}
		}
		return false;
	}
	
	
	public Pez[] getPeces() {
		return peces;
	}
	
	
	public void reiniciar() {
		for(int i=0; i<peces.length;i++) {
			if(peces[i].getX()==750) {
				peces[i].setX(-100);
				peces[i].setY((int) (Math.random()*230)+1);
			}
		}	
	}
	
	
	public void reiniciar1(int i) {
		peces[i].setY((int) (Math.random()*230)+1);
		peces[i].setX(-100);
	}
	
	
	public 	int cambiarPuntos(String n, int xP, int yP) {
		int ptos=0;
		if(n.equals("")) {
			ptos+=0;
		}else {
			ptos=Integer.parseInt(n);
		}
		int xR=xP-peces[1].getX();
		int yR=yP-peces[1].getY();
		double h=Math.sqrt(Math.pow(xR, 2)+Math.pow(yR, 2));
		if(h<=peces[1].getR()) {
			ptos+=10;
			reiniciar1(1);
		}else {
			ptos-=5;
		}
		for(int i=0;i<usuarios.size();i++) {
			if(usuarios.get(i).getNickname().equals(this.usuario.getNickname())) {
				usuarios.get(i).setPuntaje((Integer.toString(ptos)));
			}
		}
		return ptos;
	}
	
	
	public int cambiarLvl(String n) {
		int lvl=0;
		int p=Integer.parseInt(n);
		if(p<=0) {
			lvl=0;
		}else if(p>0 && p<100) {
			lvl=0;
		}else if(p>=100 && p<200) {
			lvl=1;
		}else if(p>=200 && p<300) {
			lvl=2;
		}else if(p>=300) {
			lvl=3;
		}
		for(int i=0;i<usuarios.size();i++) {
			if(usuarios.get(i).getNickname().equals(this.usuario.getNickname())) {
				usuarios.get(i).setNivel((Integer.toString(lvl)));
			}
		}
		return lvl;
	}
	
	
	public int cambiarSleep(String n) {
		int time=0;
		int p=Integer.parseInt(n);
		if(p==0) {
			time=5;
		}else if(p==1) {
			time=3;
		}else if(p==2) {
			time=2;
		}else if(p==3) {
			time=1;
		}
		return time;
	}
	
	
	public void escribiendo2() {
		try {
			//Creo flujo de datos externo
			ObjectOutputStream escribir=new ObjectOutputStream(/**Indico la ruta de donde se va a guardar*/new FileOutputStream("C:\\Users\\c\\eclipse-workspace\\Las\\src\\partidas\\Usuarios.dat"));
			escribir.writeObject(usuarios);
			escribir.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String ordenNombres() {
		String end="";
		comparator=new ComparadorNombre();
		Collections.sort(usuarios, comparator);
		for(int m=0;m<usuarios.size();m++) {
			int j=m+1;
			end+=""+j+")"+usuarios.get(m)+" ";
			end+="\n";
		}
		return end;
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
			if(Integer.parseInt(usuarios.get(medio).getPuntaje())==valor){
				encontre=true;
			}else if(Integer.parseInt(usuarios.get(medio).getPuntaje())>valor){
				fin=medio-1;
			}else{
				inicio=medio+1;
			}
		}
		return usuarios.get(medio).toString();
	}
	
	
}