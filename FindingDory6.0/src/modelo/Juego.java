package modelo;

public class Juego {

	private Pez[] peces;
	private Usuario usuario;

	public Juego(String nickname, String puntaje, String nivel) {
		peces=new Pez[13];
		peces[0]= new Pez("src/fotos/gio.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[1]= new Pez("src/fotos/dory.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70, 70);
		peces[2]= new Pez("src/fotos/nemo.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[3]= new Pez("src/fotos/shark.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[4]= new Pez("src/fotos/shark2.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[5]= new Pez("src/fotos/weird.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[6]= new Pez("src/fotos/weird2.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 90,90);
		peces[7]= new Pez("src/fotos/flo.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[8]= new Pez("src/fotos/estrella.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[9]= new Pez("src/fotos/martillo.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[10]= new Pez("src/fotos/crab.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		peces[11]= new Pez("src/fotos/raya.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 100,100);
		peces[12]= new Pez("src/fotos/prof.png",(int) (Math.random()*700)+1, (int) (Math.random()*230)+1, 70,70);
		
		usuario=new Usuario(nickname, puntaje, nivel);
	}

	public Pez[] getPeces() {
		return peces;
	}
	
	public void reiniciar() {
		for(int i=0; i<peces.length;i++) {
			if(peces[i].getX()==750) {
				peces[i].setX(1);
				peces[i].setY((int) (Math.random()*230)+1);
			}
		}	
	}
	
	
	public boolean verificarPez() {
		return true;
	}
	
	
	public int verificarPuntos(boolean we) {
		int pt=0;
		if(we==true) {
			pt+=5;
		}else {
			pt-=5;
		}
		return pt;
	}
	
	
	
	
}
