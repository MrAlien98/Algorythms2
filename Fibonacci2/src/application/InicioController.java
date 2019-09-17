package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InicioController {

	private Main main;
	
	@FXML private Button butCalcular;
	@FXML private TextField txtNumero;
	@FXML private TextField txtResultado;
	
	public InicioController() {
		
	}
	
	public void inicialize() {
		
	}
	
	public void hacer() {
		butCalcular.setOnAction(e ->{
			Main.calcular(Integer.parseInt(txtNumero.getText()));
		});
	}
	
}
