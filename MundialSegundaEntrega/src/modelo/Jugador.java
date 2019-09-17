package modelo;

public class Jugador{

	private String imagen;
	private String nombre;
	private String posicion;
	private String bornDate;
	private double puntajeFifa;
	private double altura;
	
	private Jugador der;
	private Jugador izq;
	private Vector v;
	
	public Jugador(String imagen, String nombre, String posicion, String bornDate, double puntajeFifa, double altura) {
		this.imagen = imagen;
		this.nombre = nombre;
		this.posicion = posicion;
		this.bornDate = bornDate;
		this.puntajeFifa = puntajeFifa;
		this.altura = altura;
		
		v=new Vector();
		
		der=null;
		izq=null;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public double getPuntajeFifa() {
		return puntajeFifa;
	}

	public void setPuntajeFifa(double puntajeFifa) {
		this.puntajeFifa = puntajeFifa;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Jugador getDerecho() {
		return der;
	}

	public void setDerecho(Jugador der) {
		this.der = der;
	}

	public Jugador getIzquierdo() {
		return izq;
	}

	public void setIzquierdo(Jugador izq) {
		this.izq= izq;
	}
	
    public void insertar(Jugador insertar){
        if(insertar.getPuntajeFifa()<this.getPuntajeFifa()){
        	if(izq == null) {
            	izq=insertar;
            }else {
            	izq.insertar(insertar);
            }
        }else if(insertar.getPuntajeFifa()>this.getPuntajeFifa()){
            if(der==null) {
            	der=insertar;
            }else {
            	der.insertar(insertar);
            }
                
        }
    }
	
    public Jugador buscar(String nombre) {
		 Jugador j=this;
		 while(j!=null) {
			 int comp=j.nombre.compareToIgnoreCase(nombre);
			 if(comp==0) {
				 return j;
			 }else if(comp>0) {
				 j=j.izq;
			 }else {
				 j=j.der;
			 }
		 }
		 return null;
	 }
    
    
//    public Object[] preOrden(Jugador aja, Vector v) {
//		 this.v=v;
//		 v.ingreso(aja);
//		 if(aja.getIzquierdo()!=null) {
//			 aja.preOrden(aja, v);
//		 }
//		 if(aja.getDerecho()!=null) {
//			 aja.preOrden(aja, v);
//		 }
//		 return v.getVector();
//	 }
}
