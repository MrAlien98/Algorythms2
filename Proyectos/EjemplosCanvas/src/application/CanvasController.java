package application;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class CanvasController {
	
	@FXML private Canvas canvas;

	
	public CanvasController() {
		
	}
	
	public void initialize() {
		canvas.setOnMouseClicked(e->{
			System.out.println(e.getSceneX()+"_"+e.getSceneY());
		});
	}
	
}
