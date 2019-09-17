package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.OutOfBounds;
import excepciones.ValorNuloEnArreglo;
import modelo.Principal;

class PrincipalTest {

	private Principal p;
	
	public void escenario1() {
		p=new Principal();
	}
	
	@Test
	void auxiliarTest() throws OutOfBounds {
		escenario1();
		assertEquals('a',p.auxiliar("aja", 1));
	}
	
	@Test
	void auxiliarTest2() throws OutOfBounds {
		escenario1();
		assertNotEquals('a', p.auxiliar("aja", 2));
	}

	@Test
	void incognitoTest() throws ValorNuloEnArreglo {
		escenario1();
		Integer[] a= {1,2,3};
		Integer[] b= {2,3,1};
		assertArrayEquals(a, p.incognito(b));
	}
	
	@Test
	void incognitoTest2() throws ValorNuloEnArreglo {
		escenario1();
		Integer[] a= {1,2,3};
		Integer[] b= {2,null,1};
		assertArrayEquals(a, p.incognito(b));
	}
	
}
