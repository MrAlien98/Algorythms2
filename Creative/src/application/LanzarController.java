package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class LanzarController {

	public static final int POS_X_BANDERA=80;
	public static final int POS_I_POKEMON=500;
	
	@FXML private VBox pokimas;
	
	@FXML private ImageView pokebola1;
	@FXML private ImageView pokebola2;
	@FXML private ImageView pokebola3;
	
	@FXML private ImageView cancha;
	@FXML private ImageView banner;
	@FXML private ImageView flag;
	
	@FXML private ImageView pokeActual;
	
	@FXML private Timeline animacion;
	
	public LanzarController() {
		
	}
	
	public void initialize() {
				
		pokebola1.setImage(new Image(Main.darGimnasio().getPoke1().getImagen()));
		pokebola2.setImage(new Image(Main.darGimnasio().getPoke2().getImagen()));
		pokebola3.setImage(new Image(Main.darGimnasio().getPoke3().getImagen()));
		
		pokebola1.setOnMouseClicked(e->{
			pokeActual.setImage(new Image(Main.darGimnasio().getPoke1().getPokemon().darRuta()));
			pokeActual.setFitWidth(150);
			pokeActual.setFitWidth(150);
			pokeActual.setX(Main.darPokemon().getPosX());
			pokeActual.setY(Main.darPokemon().getPosY());
			
			queComienceLaFiesta();
			pokimas.setDisable(true);
		});
		pokebola2.setOnMouseClicked(e->{
			pokeActual.setImage(new Image(Main.darGimnasio().getPoke2().getPokemon().darRuta()));
			pokeActual.setFitWidth(150);
			pokeActual.setFitWidth(150);
			pokeActual.setX(Main.darPokemon().getPosX());
			pokeActual.setY(Main.darPokemon().getPosY());
			
			queComienceLaFiesta();
			pokimas.setDisable(true);
		});
		pokebola3.setOnMouseClicked(e->{
			pokeActual.setImage(new Image(Main.darGimnasio().getPoke3().getPokemon().darRuta()));
			pokeActual.setFitWidth(100);
			pokeActual.setFitWidth(100);
			pokeActual.setX(Main.darPokemon().getPosX());
			pokeActual.setY(Main.darPokemon().getPosY());
			
			queComienceLaFiesta();
			pokimas.setDisable(true);
		});
		
		
		banner.setImage(new Image("data/Pokemon_Banner.jpg"));
		banner.setFitWidth(640);
		
		cancha.setImage(new Image("data/cancha.jpg"));
		imageView2();
	}
	
	public void imageView2(){
		flag.setImage(new Image("data/bandera.png"));
		flag.setFitWidth(50);
		flag.setFitWidth(50);
		flag.setX(80);
		flag.setY(210);
	}
	
	public void queComienceLaFiesta() {
		animacion=new Timeline(new KeyFrame(Duration.millis(30), e->{
			Main.darPokemon().avanzar(5);
			pokeActual.setX(Main.darPokemon().getPosX());
			detener();
		}));
		
		animacion.setCycleCount(Timeline.INDEFINITE);
		animacion.play();
	}
	
	public void detener() {
		if(pokeActual.getX()<POS_X_BANDERA-30) {
			animacion.stop();
			Main.mostrarDistancia(POS_I_POKEMON-POS_X_BANDERA);
		}
	}

	
}
