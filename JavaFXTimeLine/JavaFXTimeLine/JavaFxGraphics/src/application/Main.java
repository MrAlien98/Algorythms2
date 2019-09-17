package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Circulo;


public class Main extends Application {
	
	private static Circulo circulo;
	
	public Main() {
		setCirculo(new Circulo(60, 60, 80));
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Circulo getCirculo() {
		return circulo;
	}

	public static void setCirculo(Circulo circulo) {
		Main.circulo = circulo;
	}
}
