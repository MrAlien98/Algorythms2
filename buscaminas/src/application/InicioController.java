 package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class InicioController {

	@SuppressWarnings("unused")
	private Main main;
	
	@FXML private Label labTitulo;
	@FXML private Button butFacil;
	@FXML private Button butMedio;
	@FXML private Button butExperto;
	@FXML private GridPane tablero;
	
	public InicioController() {
		
	}
	
	public void initialize() {
		
	}
	
	public void mandarFacil() {
//		Lambda Expression
		butFacil.setOnAction(e -> {
			Main.crearTablero('P');
			Main.mandarPantalla();
		});
		butMedio.setOnAction(e -> {
			Main.crearTablero('I');
			Main.mandarPantalla();
		});
		butExperto.setOnAction(e -> {
			Main.crearTablero('E');
			Main.mandarPantalla();
		});
	}

	
}
