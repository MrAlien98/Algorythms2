package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AtraparController {
	
	public static final int POS_X_BANDERA=80;
	
	@FXML private ImageView cancha;
	@FXML private ImageView banner;
	@FXML private ImageView flag;
	@FXML private ImageView pika;

	public AtraparController () {	
	}
	
	public void initialize() {
		banner.setImage(new Image("data/Pokemon_Banner.jpg"));
		banner.setFitWidth(640); 
		
		cancha.setImage(new Image("data/cancha.jpg"));
		
		cancha.setOnMouseClicked(e->{
			Main.atraparPokemon((int)e.getSceneX(), (int)e.getSceneY());
		});
		imageView2();
	}
	
	public void imageView2(){
		flag.setImage(new Image("data/bandera.png"));
		flag.setOnMouseClicked(e->{
			Main.atraparPokemon((int)e.getSceneX(), (int)e.getSceneY());		
		});
		flag.setFitWidth(50);
		flag.setFitWidth(50);
		flag.setX(80);
		flag.setY(210);
		imageView3();
	}
	
	public void imageView3() {
		pika.setImage(new Image(Main.darPokemon().darRuta()));
		pika.setX(Main.darPokemon().getPosX());
		pika.setY(Main.darPokemon().getPosY());
		pika.setFitWidth(100);
		pika.setFitWidth(100);
		
		Timeline animacion=new Timeline(new KeyFrame(Duration.millis(30), e->{
			Main.darPokemon().avanzar(5);
			
			pika.setX(Main.darPokemon().getPosX());
		}));
		
		animacion.setCycleCount(Timeline.INDEFINITE);
		animacion.play();
		
		pika.setOnMouseClicked(e->{
			Main.atraparPokemon((int)e.getSceneX(), (int)e.getSceneY());
			
			if(Main.darPokemon().atrapado((int)e.getSceneX(), (int)e.getSceneY())==true) {
				pika.setImage(new Image(Main.darPokemon().darRuta()));
				pika.setFitWidth(80);
				pika.setFitWidth(80);
				animacion.stop();
			}
		});
	}
	
	
}
