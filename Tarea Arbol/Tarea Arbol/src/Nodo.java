
public class Nodo {

	private Nodo d;
	private Nodo i;
	
	private int c;
	
	public Nodo(int c) {
		this.c=c;
		
		d=null;
		i=null;
	}

	public Nodo getD() {
		return d;
	}

	public void setD(Nodo d) {
		this.d = d;
	}

	public Nodo getI() {
		return i;
	}

	public void setI(Nodo i) {
		this.i = i;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public boolean isHoja() {
		return (getI()==null && getD()==null);
	}
	
	public Nodo darMenor() {
		return (i==null) ? this : i.darMenor();
	}
	
	public Nodo eliminar(long punt) {
		if(isHoja()) {
			return null;
		}
		if(c == punt) {
			if(i == null)
				return d;
			
			if(d == null)
				return i;
			
			Nodo suce = d.darMenor();
			d = d.eliminar(suce.getC());
			suce.i = i;
			suce.d = d;
			return suce;
		}
		else if(c>punt) {
			i = i.eliminar(punt);
		}else {
			d = d.eliminar(punt);
		}
		return this;
	}
	
}
