package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import modelo.Juego;
import modelo.Usuario;
import org.junit.jupiter.api.Test;

class TestJuego {

	private Juego juego;
	
	private void setUpEscenario1() {
		juego=new Juego();
	}
	
	@Test
	void testBusquedaBinaria() {
		setUpEscenario1();
		juego.agregarUsuario("Niche", "76", "2");
		String actual=juego.busquedaBinaria(76);
		String esperado= "Usuario: Niche puntaje: 76 nivel: 2";
		assertEquals(esperado, actual);
	}
	

}
