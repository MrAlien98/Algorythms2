package metodo;

import exception.ValorNuloEnArreglo;

public class Metodo {

	public Metodo() {
		
	}
	
	public Integer[] incognito(Integer a[]) throws ValorNuloEnArreglo {
		Integer r[] = a.clone();
		for (int i=0;i<r.length-1;i++) {
			if(r[i]==null) throw new ValorNuloEnArreglo("Error en la posicion: ", i);
		}
		for(int j=0; j<r.length-1;j++) {
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
