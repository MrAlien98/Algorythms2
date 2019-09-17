package application;
	
import hilos.HiloFibo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.Fibonacci;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private static Fibonacci f;
	private static HiloFibo hF;
	
	public Main() {
		hF=new HiloFibo(this);
	}
	
	public static void calcular(int x) {
		f=new Fibonacci("nuevo", x);
		iniciar();
	}
	
	public static void iniciar() {
		hF.start();
	}
	
	public static void mostrar() {
		f.mostrarSerie();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
