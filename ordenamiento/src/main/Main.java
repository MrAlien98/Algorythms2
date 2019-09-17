package main;

public class Main {
	int[] wea;
	//Teoria: El doble menos 3
	public Main() {
		wea= new int[8];
		wea[0]=3;
		wea[1]=45;
		wea[2]=22;
		wea[3]=80;
		wea[4]=6;
		wea[5]=10;
		wea[6]=1;
		wea[7]=0;
		imp();
	}
	
	public int[] darWea() {
		return wea;
	}
	
	public String burbuja() {
		String end="";
		int contador=0;
		int[] arreglo=darWea();
		for(int i=wea.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				contador++;
				System.out.println(""+contador);
				if(arreglo[j]>arreglo[j+1]) {
					int temp=arreglo[j];
					arreglo[j]=arreglo[j+1];
					arreglo[j+1]=temp;
				}
			}
		}
		for(int n=0;n<arreglo.length;n++) {
			end+=arreglo[n]+"_";
		}
		return end;
	}
	
	
	
	public void imp() {
		System.out.println(burbuja());
	}
	
	public static void main(String[] args) {
		Main main=new Main();
	}

}
