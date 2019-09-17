package application;
	
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Gimnasio;
import modelo.Pokemon;


public class Main extends Application {
	
	private static Gimnasio gimnasio;
	private CanvasController canvas;

	public Main() {
		gimnasio=new Gimnasio();
		canvas=new CanvasController();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/Canvas.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String opciones() {
		String wea="";
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog with Custom Actions");
		alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
		alert.setContentText("Choose your option.");

		ButtonType buttonTypeLanzar = new ButtonType("Lanzar");
		ButtonType buttonTypeAtrapar = new ButtonType("Atrapar");

		alert.getButtonTypes().setAll(buttonTypeLanzar, buttonTypeAtrapar);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeLanzar){
			wea="/application/Canvas.fxml";
			return wea;
		} else if (result.get() == buttonTypeAtrapar) {
		    wea="/application/Canvas.fxml";
		    return wea;
		}
		return "aja";
	}
	
	public static Pokemon darPokemon(){
		return gimnasio.darPokemon();
	}
	
	public static void atraparPokemon(int x, int y) {
		if(darPokemon().atrapado(x, y)==true) {
			darPokemon().setDetenido(true);
			darPokemon().encapsularPokemon();
			String nombre=JOptionPane.showInputDialog("Lograste Atrapar al Pokemon, Ingresa Tu Nombre Para Registrate");
			gimnasio.guardarArchivo(nombre +" \n");
		}else {
			JOptionPane.showMessageDialog(null, "Y O U   F A I L E D");
		}			
	}
	
	public CanvasController getCanvas() {
		return canvas;
	}

	public void setCanvas(CanvasController canvas) {
		this.canvas = canvas;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
