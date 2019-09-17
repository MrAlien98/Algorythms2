package modelo;

public class Vector {

	private Object[] vector;
	private int size;
	
	public Vector() {
		size=0;
		vector=new Object[size];
	}

	public Object[] getVector() {
		return vector;
	}

	public void setVector(Object[] vector) {
		this.vector = vector;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void ingreso(Object aja) {
		vector[size]=aja;
		setSize(size+=1);
	}
}
