package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Tablero;

import org.junit.jupiter.api.Test;

import excepciones.CasillaAbierta;
import excepciones.CasillaInvalida;
import excepciones.JuegoTerminado;

class TableroTest {

	private Tablero tablero;
	
	public void escenario1() {
		tablero=new Tablero('P');
	}
	
	@Test
	void ganarTest() {
		escenario1();
		tablero.setCasillasDestapadas(54);
		assertEquals(true, tablero.revisarSiGano());
	}
	
	@Test
	void perderTest() throws CasillaInvalida, CasillaAbierta {
		escenario1();
		for(int i=0;i<tablero.getCasillas().length;i++){
			for(int j=0;j<tablero.getCasillas()[i].length;j++){
				if(tablero.getCasillas()[i][j].estaMinada()==true) {
					try {
						tablero.destaparCasilla(i, j, '1');
					} catch (JuegoTerminado e) {
						e.printStackTrace();
					}
				}
			}
		}
		assertEquals(true, tablero.revisarSiPerdio());
	}
	
	/**
	 * A veces va a fallar la prueba, porque justo en la casilla que se esta abriendo saldrá una mina
	 * @throws CasillaInvalida
	 * @throws CasillaAbierta
	 * @throws JuegoTerminado
	 */
	@Test
	void abrirCasillaTest() throws CasillaInvalida, CasillaAbierta, JuegoTerminado {
		escenario1();
		tablero.destaparCasilla(1, 0, '1');
		assertEquals('1', tablero.getCasillas()[1][0].darEstado());
	}
	
	@Test
	void abrirCasillaTest2() throws CasillaInvalida, CasillaAbierta, JuegoTerminado {
		escenario1();
		tablero.destaparCasilla(0, 0, '1');
		assertEquals(1, tablero.getCasillasDestapadas());
	}

}
