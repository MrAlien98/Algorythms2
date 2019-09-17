package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.Mundial;
import modelo.Seleccion;

class MundialTest {

	private Mundial mundial;
	private Seleccion sel;
	
	private void setUpEscenario1() {
		mundial=new Mundial();
	}
	
	private void setUpEscenario2() {
		sel=new Seleccion("colombia", 80, "C:\\Users\\c\\eclipse-workspace\\LabMundial\\src\\ImgsPaises\\colombia");
	}
	
	
	@Test
	void testAgregar() {
		setUpEscenario2();
		sel.add(new Jugador("C:\\Users\\c\\eclipse-workspace\\LabMundial\\src\\ImgsPaises\\colombia", "Cuadrado", "Medio Campo", 45.5, "11/04/1995", 1.75));
		sel.add(new Jugador("C:\\Users\\c\\eclipse-workspace\\LabMundial\\src\\ImgsPaises\\colombia", "James", "Delantero", 80.0, "20/05/1997", 1.85,null,null ));
	}
	
	
	@Test
	void testAgregarPrimero() {
		setUpEscenario1();
		mundial.add("colombia", 80, "C:\\Users\\c\\eclipse-workspace\\LabMundial\\src\\ImgsPaises\\colombia");
		mundial.add("mexico", 70, "C:\\Users\\c\\eclipse-workspace\\LabMundial\\src\\ImgsPaises\\mexico");
		assertTrue(mundial.size()==2);
	}

	@Test
	void testToArray() {
		setUpEscenario1();
		mundial.add("mexico", 70, "C:\\Users\\c\\eclipse-workspace\\LabMundial\\src\\ImgsPaises\\mexico");
		mundial.add("colombia", 80, "C:\\Users\\c\\eclipse-workspace\\LabMundial\\src\\ImgsPaises\\colombia");
		String[] comparar= {"mexico","colombia"};
		assertArrayEquals(comparar, mundial.toArray());
	}
	
	
}
