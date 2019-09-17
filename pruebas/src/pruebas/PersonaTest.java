package pruebas;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
import modelo.Persona;
import org.junit.jupiter.api.Test;

class PersonaTest {

	private Persona persona;
	
	public void escenario1() {
		persona=new Persona("Juan", "Lopez");
	}
	
	@Test
	void testDarNombreCompleto() {
		escenario1();
		assertEquals("Juan Lopez", persona.darNombreCompleto());
	}

}
