package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import application.Character;


public class Main extends Application {
	
	private static Character character;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SampleController spController = loader.getController();
			spController.initialize(scene);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		character = new Character(10,10);
		launch(args);
	}
	
	
	
	public static double getPosx() {
		return character.getPosx();
	}
	
	public static double getPosy() {
		return character.getPosy();
	}
	
	public static void setPosx(double posx) {
		character.setPosx(posx);
	}
	
	public static void setPosy(double posy) {
		character.setPosy(posy);
	}
	
	public static void setRight(boolean right) {
		character.setRight(right);
	}
	
	public static void setLeft(boolean left) {
		character.setLeft(left);
	}
	
	public static void setUp(boolean up) {
		character.setUp(up);
	}
	
	public static void setDown(boolean down) {
		character.setDown(down);
	}

	
	public static void moveCharacter(double d , double e) {
		//setPosx(d);
		//setPosy(e);
		Thread t1 = new Thread(character);
		t1.start();
	}
	
	public static void move() {
		Thread t1 = new Thread(character);
		t1.start();
	}
	
	
}
