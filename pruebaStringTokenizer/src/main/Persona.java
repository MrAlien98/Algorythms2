package main;

public class Persona {

	private String iD;
	private String name; 
	private String lastName;
	private String email;
	private String gender;
	private String avatar;
	
	private Persona siguiente;
	
	public Persona(String iD, String name, String lastName, String email, String gender, String avatar) {
		this.iD = iD;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.avatar = avatar;
		
		siguiente=null;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Persona getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Persona siguiente) {
		this.siguiente = siguiente;
	}
	
	@Override
	public String toString() {
		return iD+" "+name+" "+lastName+" "+email+" "+gender+" "+avatar;
	}
	
	
}
