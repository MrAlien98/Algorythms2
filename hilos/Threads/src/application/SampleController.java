package application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class SampleController {
	
	
	
	@FXML
	private Circle circle;
	
	private Character character;
	
	public SampleController() {
		
	}
	
	
	public void initialize(Scene scene) {
		Main.move();
		moveOnkeyPressed(scene);
		stopOnkeyReleased(scene);
	}
	
	
	
	private void stopOnkeyReleased(Scene scene) {
		scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent e) {
				switch(e.getCode()) {
				 case UP:   Main.setUp(false);//circle.setCenterY(circle.getCenterY() - Main.getPosy());
				 	circle.setTranslateY(Main.getPosy());break;
		          case RIGHT: Main.setRight(false);//circle.setCenterX(circle.getCenterX() + Main.getPosx());
		          circle.setTranslateX(Main.getPosx());
		          break;
		          case DOWN:  Main.setDown(false);//circle.setCenterY(circle.getCenterY() + Main.getPosy());
		          circle.setTranslateY(Main.getPosy());
		          break;
		          case LEFT: Main.setLeft(false);//circle.setCenterX(circle.getCenterX() - Main.getPosx());
		          circle.setTranslateX(Main.getPosx());
		          break;
				}
			}
		});
	}


	private void moveOnkeyPressed(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent e) {
				//System.out.println(Main.getPosy());
				switch(e.getCode()) {
				 case UP:   Main.setUp(true); //circle.setLayoutY(circle.getLayoutY() - Main.getPosy());
				 break;
		          case RIGHT: Main.setRight(true);//circle.setLayoutX(circle.getLayoutX() +  Main.getPosx());
		          break;
		          case DOWN:  Main.setDown(true);//circle.setLayoutY(circle.getLayoutY() + Main.getPosy());
		          break;
		          case LEFT: Main.setLeft(true);//circle.setLayoutX(circle.getLayoutX() - Main.getPosx()); 
		          break;
				}
			}
		});
		
		
	}


	public void keyPressed(KeyEvent e) {
		Main.move();
		
		if(e.getCode() == KeyCode.RIGHT) {
			System.out.println("RIGTH");
			Main.setRight(true);
		}
		if(e.getCode() == KeyCode.LEFT) {
			System.out.println("LEFT");
			Main.setLeft(true);
		}
		if(e.getCode() == KeyCode.DOWN) {
			System.out.println("DOWN");
			Main.setDown(true);
		}
		if(e.getCode() == KeyCode.UP) {
			System.out.println("UP");
			Main.setDown(false);
			Main.setUp(true);
		}
		
	}
	
	
	public void keyReleased(KeyEvent e) {
		Main.move();
		
		if(e.getCode() == KeyCode.RIGHT) {
			Main.setRight(false);
		}
		if(e.getCode() == KeyCode.LEFT) {
			Main.setLeft(false);
		}
		if(e.getCode() == KeyCode.DOWN) {
			Main.setDown(true);
		}
		if(e.getCode() == KeyCode.UP) {
			Main.setDown(true);
			Main.setUp(false);
		}
	}
	
	
	public void mouseclicked() {
//		Main.moveCharacter(20, 0);
//		System.out.println(circle.getLayoutX() + "   "+ circle.getLayoutY());
//		double x = Main.getPosx();
//		double y = Main.getPosy();
//		System.out.println(x+ "   "+ y);
//		circle.setLayoutX(x);
//		circle.setLayoutY(y);
//		System.out.println(" "+ circle.getLayoutX() + circle.getLayoutY());
//		character = new Character(10,10);
	}
	
	
	
}
