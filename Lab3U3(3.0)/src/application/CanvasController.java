package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CanvasController {
	
	public static final int POS_X_BANDERA=80;
	
	@FXML private Canvas canvas;
	@FXML private ImageView banner;
	@FXML private ImageView pika;
	
	public CanvasController() {	
		
	}
	
	public void initialize() {
		
		banner.setImage(new Image("data/Pokemon_Banner.jpg"));
		banner.setFitWidth(640);
//		GraphicsContext gc=canvas.getGraphicsContext2D();
		
		pika.setImage(new Image(Main.darPokemon().darRuta()));
		pika.setX(Main.darPokemon().getPosX());
		pika.setY(Main.darPokemon().getPosY());
		pika.setFitWidth(100);
		pika.setFitHeight(100);
		
//		gc.drawImage(new Image("data/cancha.jpg"), 0, 0);
//		gc.drawImage(new Image("data/bandera.png"), POS_X_BANDERA, 210, 50, 50);
		
		Timeline timeLine=new Timeline(new KeyFrame(Duration.millis(30), e->{
			Main.darPokemon().avanzar(5);
			
			pika.setX(Main.darPokemon().getPosX());
		}));
		
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
		
//		canvas.setOnMouseClicked(e->{
//			Main.atraparPokemon((int)e.getX(), (int)e.getY());
//		});
	}

	
	
}
