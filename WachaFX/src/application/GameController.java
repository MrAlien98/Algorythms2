package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelo.Personaje;

public class GameController extends Scene{
	
	@FXML private ImageView vida1;
	@FXML private ImageView vida2;
	@FXML private ImageView vida3;
	@FXML private ImageView fondo;
	@FXML private ImageView imgUsuario;
	
	@FXML private ImageView laser;
	
	@FXML private Timeline animacionD;
	@FXML private Timeline animacionI;
	@FXML private Timeline animacionB;	
	
	@FXML Pane ajam;
	
	public GameController(Pane root, double width, double height) {
		super(root, width, height);
		
		ajam=root;
		
		laser=new ImageView(new Image("data/laser.png"));
		laser.setRotate(90);
		laser.setFitWidth(Main.getGame().getUsuario().getAvatar().getBala().getAncho());
		laser.setFitHeight(Main.getGame().getUsuario().getAvatar().getBala().getLargo());
				
		imgUsuario=new ImageView();
		imgUsuario.setImage(new Image(Main.getGame().getUsuario().getAvatar().getImagen()));
		imgUsuario.setX(Main.getGame().getUsuario().getAvatar().getPosX());
		imgUsuario.setY(Main.getGame().getUsuario().getAvatar().getPosY());
		imgUsuario.setFitWidth(Main.getGame().getUsuario().getAvatar().getAncho());
		imgUsuario.setFitHeight(Main.getGame().getUsuario().getAvatar().getLargo());
		
		fondo=new ImageView();
		fondo.setImage(new Image("data/background.gif"));
		fondo.setX(0);
		fondo.setY(0);
			
		((Pane) root).getChildren().add(fondo);
		((Pane) root).getChildren().add(imgUsuario);
		((Pane) root).getChildren().add(laser);
		laser.setVisible(false);
	}
	
	public void moverI() {
		animacionI=new Timeline(new KeyFrame(Duration.millis(10), e->{
			Main.getGame().getUsuario().getAvatar().setImagen(Personaje.IZQ);
			Main.getGame().getUsuario().getAvatar().moverIzquierda();
			imgUsuario.setImage(new Image(Main.getGame().getUsuario().getAvatar().getImagen()));
			imgUsuario.setX(Main.getGame().getUsuario().getAvatar().getPosX());
			corregir();
		}));
		animacionI.setCycleCount(Timeline.INDEFINITE);
		animacionI.play();
		corregir();
	}
	
	public void moverD() {
		animacionD=new Timeline(new KeyFrame(Duration.millis(10), e->{
			Main.getGame().getUsuario().getAvatar().setImagen(Personaje.DER);
			Main.getGame().getUsuario().getAvatar().moverDerecha();
			imgUsuario.setImage(new Image(Main.getGame().getUsuario().getAvatar().getImagen()));
			imgUsuario.setX(Main.getGame().getUsuario().getAvatar().getPosX());
			corregir();
		}));
		animacionD.setCycleCount(Timeline.INDEFINITE);
		animacionD.play();
		corregir();
	}
	
	public void disparar() {
		animacionB=new Timeline(new KeyFrame(Duration.millis(100), e->{

			Main.getGame().getUsuario().getAvatar().disparar();
					
			laser.setX(Main.getGame().getUsuario().getAvatar().getBala().getX()-40);
			laser.setY(Main.getGame().getUsuario().getAvatar().getBala().getY()-40);
						
			laser.contains(new Point2D(0, 0));
			
			laser.setVisible(true);
			
			Main.getGame().getUsuario().getAvatar().reload();
			dejarDeDisparar();
		}));
		animacionB.setCycleCount(Timeline.INDEFINITE);
		animacionB.play();
	}
	
	public void dejarDeDisparar() {
		if(Main.getGame().getUsuario().getAvatar().isDisparando()==false) {
			detener(getAnimacionB());
			laser.setVisible(false);
		}
	}
	
	public void detener(Timeline animacion) {
		animacion.pause();
	}

	public void corregir() {
		Bounds bs=ajam.getBoundsInLocal();
		if(imgUsuario.getX()>bs.getMaxX()-80) {
			detener(animacionD);
		}else if(imgUsuario.getX()<bs.getMinX()+80){
			detener(animacionI);
		}
	}

	public Timeline getAnimacionD() {
		return animacionD;
	}

	public Timeline getAnimacionI() {
		return animacionI;
	}

	public Timeline getAnimacionB() {
		return animacionB;
	}
	
	
	
}
