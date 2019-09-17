package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import modelo.Tablero;

public class Main extends Application {
	
	private static Stage primaryStage;
	private static Tablero tablero;
	
	public Main() {
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage=primaryStage;
		primaryStage.setTitle("Buscaminas");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Inicio.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void crearTablero(char dificultad) {
		tablero=new Tablero(dificultad);
	}
	
	public static Tablero getTablero() {
		return tablero;
	}
	
	public static void mandarPantalla() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("Tablero.fxml"));
			BorderPane root2 = loader.load();
			
			Stage stage2=new Stage();
			stage2.setTitle("Buscaminas");
			stage2.initModality(Modality.WINDOW_MODAL);
			stage2.initOwner(primaryStage);
			
			Scene scene2=new Scene(root2);
			stage2.setScene(scene2);
			stage2.showAndWait();
			primaryStage.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}