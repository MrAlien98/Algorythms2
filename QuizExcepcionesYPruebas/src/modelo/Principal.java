package modelo;

import excepciones.*;

public class Principal {

	public Principal() {
		
	}
	
	public char auxiliar(String cadena, int pos) throws OutOfBounds {
		pos-=1;
		if(pos>=0 && pos<=cadena.length()) {
			return cadena.charAt(pos);
		}else {
			throw new OutOfBounds();
		}
	}
	
	public Integer[] incognito(Integer[] a) throws ValorNuloEnArreglo{
		Integer[] r=a.clone();
		for(int i=0;i<r.length-1;i++) {
			if(r[i]==null) {
				throw new ValorNuloEnArreglo("Error en la posicion: "+i);
			}
		}
		for(int j=0;j<r.length-1;j++) {
			for(int i=0;i<r.length-1-j;i++) {
				if(r[i]>r[i+1]) {
					int t=r[i];
					r[i]=r[i+1];
					r[i+1]=t;
				}
			}
		}
		return r;
	}
}

