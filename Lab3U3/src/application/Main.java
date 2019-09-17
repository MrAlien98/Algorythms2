package application;
	
import javax.swing.JOptionPane;

import hilos.HiloPersonaje;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Gimnasio;
import modelo.Pokemon;


public class Main extends Application {
	
	private static Gimnasio gimnasio;
	private static HiloPersonaje hilo;
	private CanvasController canvas;

	public Main() {
		gimnasio=new Gimnasio();
		canvas=new CanvasController();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Canvas.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			moverPokemon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Pokemon darPokemon(){
		return gimnasio.darPokemon();
	}
	
	public void moverPokemon() {
		hilo=new HiloPersonaje(darPokemon(), this);
		hilo.start();
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
	
	public void actualizar() {
		canvas.getIvP().setX((int)darPokemon().getPosX());
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
