package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import metodo.Metodo;

import org.junit.jupiter.api.Test;
import exception.ValorNuloEnArreglo;

class IncognitoTest {

	private Metodo metodo;
	
	private void setUpEscenario() {
		metodo=new Metodo();
	}
	
	@Test
	void testFunciona1() {
		setUpEscenario();
		Integer[] a = {1, 2, 3, 4};
		Integer[] f = {2, 3, 1, 4};
		try {
		assertArrayEquals(a, metodo.incognito(f));
		}catch(ValorNuloEnArreglo vN){
			System.out.println(vN.getMessage());
		}
	}
		
	@Test
	void testFalla() {
		setUpEscenario();
		Integer[] b = {null, 2, 1, 3};
		Integer[] f = {2, 3, 1, 4};
		try {
		assertArrayEquals(b, metodo.incognito(f));
		}catch(ValorNuloEnArreglo vN){
			System.out.println(vN.getMessage());
		}
	}
	
}
