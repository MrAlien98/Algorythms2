package application;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CanvasController {
	
	public static final int POS_X_BANDERA=80;
	
	@FXML private Canvas canvas;
	@FXML private ImageView iv;
	@FXML private ImageView iv2;
	@FXML private ImageView ivP;

	public CanvasController() {	
		ivP=new ImageView();
	}
	
	public void initialize() {
		iv.setImage(new Image("data/cancha.jpg"));
		iv.setOnMouseClicked(e->{
			System.out.println(e.getSceneX()+"_"+e.getSceneY());
		});
		imageView2();
	}
	
	public void imageView2(){
		iv2.setImage(new Image("data/bandera.png"));
		iv2.setOnMouseClicked(e->{
			System.out.println(e.getSceneX()+"_"+e.getSceneY());
		});
		iv2.setFitWidth(50);
		iv2.setFitWidth(50);
		iv2.setX(80);
		iv2.setY(210);
		imageView3();
	}
	
	public void imageView3() {
		ivP.setImage(new Image(Main.darPokemon().darRuta()));
		ivP.setOnMouseClicked(e->{
			Main.atraparPokemon((int)e.getSceneX(), (int)e.getSceneY());
		});
		ivP.setX(Main.darPokemon().getPosX());
		ivP.setY(Main.darPokemon().getPosY());
		ivP.setFitWidth(100);
		ivP.setFitWidth(100);
	}
	
	public void actualizar() {
		ivP.setX(Main.darPokemon().getPosX());
	}
	
	public ImageView getIvP() {
		return ivP;
	}

	public void setIvP(ImageView ivP) {
		this.ivP = ivP;
	}
	
}
