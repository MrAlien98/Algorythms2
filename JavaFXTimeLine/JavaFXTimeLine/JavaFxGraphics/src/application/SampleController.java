package application;

import java.security.SecureRandom;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class SampleController {

	@FXML private Circle c;
	@FXML private Pane pane;

	public void initialize() {
		SecureRandom random = new SecureRandom();

		c.setLayoutX(Main.getCirculo().getPosX());
		c.setLayoutY(Main.getCirculo().getPosY());
		c.setRadius(Main.getCirculo().getDiametro()/2);
		
		Timeline timeLineAnimation = new Timeline(new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {
			
			int dx = 1+random.nextInt(5);
			int dy = 1+random.nextInt(5);

			@Override
			public void handle(ActionEvent e) {
				Main.getCirculo().setPosX(Main.getCirculo().getPosX() + dx);
				Main.getCirculo().setPosY(Main.getCirculo().getPosY() + dy);
				
				c.setLayoutX(Main.getCirculo().getPosX());
				c.setLayoutY(Main.getCirculo().getPosY());		
				
				Bounds bounds = pane.getBoundsInLocal();
				
				if(hitRiLe(bounds)) {
					dx *= -1;
				}else if(hitTopBot(bounds)) {
					dy *= -1;
				}
			}
		}));		
		
		timeLineAnimation.setCycleCount(Timeline.INDEFINITE);
		timeLineAnimation.play();
		
		pane.setOnMouseClicked(e->{
			int ejem=(int) Math.sqrt(Math.pow((e.getX()-Main.getCirculo().getPosX()), 2)+Math.pow((e.getY()-Main.getCirculo().getPosY()), 2));
			
			if(ejem<Main.getCirculo().getDiametro()/2 && timeLineAnimation.getStatus().equals(Animation.Status.RUNNING)) {
				timeLineAnimation.stop();
			}else if(ejem<Main.getCirculo().getDiametro()/2 && timeLineAnimation.getStatus().equals(Animation.Status.STOPPED)) {
				timeLineAnimation.play();
			}
		});
		
		
	}	

	
	private boolean hitRiLe(Bounds bounds) {
		return (Main.getCirculo().getPosX() <= (bounds.getMinX() + Main.getCirculo().getDiametro()/2)) || (Main.getCirculo().getPosX() >= (bounds.getMaxX() - Main.getCirculo().getDiametro()/2));
	}
	
	private boolean hitTopBot(Bounds bounds) {
		return (Main.getCirculo().getPosY() <= (bounds.getMinY() + Main.getCirculo().getDiametro()/2)) || (Main.getCirculo().getPosY() >= (bounds.getMaxY() - Main.getCirculo().getDiametro()/2));
	}
}
