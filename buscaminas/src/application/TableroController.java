package application;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import excepciones.JuegoTerminado;

public class TableroController {

	@FXML private BorderPane bPane;
	@FXML private GridPane grid;
	@FXML private Button[][] tab;
	@FXML private Button butHint;
	@FXML private Button butRendirse;
	@FXML private Button butSeleccion;
	@FXML private Label labMinasRestantes;
	@FXML private TextField txtFilas;
	@FXML private TextField txtColumnas;
	
	private int limite;
	
	@SuppressWarnings("unused")
	private Main main;
	
	public TableroController() {
		grid =new GridPane();
		bPane=new BorderPane();
		limite=0;
	}
	
	public void initialize() {
		lanzarTablero();
	}
	
	public void destaparPorTeclado() {
		butSeleccion.setOnAction(e ->{
			try {
				int filas=Integer.parseInt(txtFilas.getText())-1;
				int columnas=Integer.parseInt(txtColumnas.getText())-1;
				destaparCasilla(filas, columnas);
			}catch(NumberFormatException n) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Announcement");
				alert.setHeaderText("be careful");
				alert.setContentText("Escribe algo men -.-");

				alert.showAndWait();
			}
		});
	}
	
	public void lanzarTablero() {
		tab=new Button[Main.getTablero().darNumFilas()][Main.getTablero().darNumColumnas()];
		labMinasRestantes.setText(Integer.toString(Main.getTablero().contarTotalMinadas()));
		GridPane.setColumnIndex(grid, Main.getTablero().darNumFilas());
		GridPane.setRowIndex(grid, Main.getTablero().darNumColumnas());
		for(int i=0;i<tab.length;i++) {
			final int l=i;
			for(int j=0;j<tab[i].length;j++) {
				final int n=j;
				tab[i][j]=new Button("");
				tab[i][j].setPrefSize(40,40);
				tab[i][j].setOnAction(e -> {destaparCasilla(l, n);});
				grid.add(tab[i][j], j, i);
			}
		}
		bPane.setCenter(grid);
	}

	public void destaparCasilla(int f, int c) {
		try {
			Main.getTablero().destaparCasilla(f, c, '1');
			if(Main.getTablero().getCasillas()[f][c].estaMinada()==true) {
				for(int i=0;i<Main.getTablero().darNumFilas();i++) {
					for(int j=0;j<Main.getTablero().darNumColumnas();j++) {
						if(Main.getTablero().getCasillas()[i][j].estaMinada()==true) {
							File file = new File("src/img/mina.png");
							Image image = new Image(file.toURI().toString());
							ImageView imageView = new ImageView(image);
							imageView.setFitWidth(20);
							imageView.setFitHeight(20);
							tab[i][j].setGraphic(imageView);
						}
					}
				}
				Main.getTablero().perder();
				perder();
			}else {	
				tab[f][c].setText(Integer.toString(Main.getTablero().getCasillas()[f][c].darMinadasAdyacentes()));
			}
		}catch(Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Announcement");
			alert.setHeaderText("be careful");
			alert.setContentText(e.getMessage());

			alert.showAndWait();
		}	
	}
	
	public void destaparCasilla2(int f,int c) {
		Main.getTablero().destaparCasilla2(f, c, '1');
		if(Main.getTablero().getCasillas()[f][c].estaMinada()==true) {
			for(int i=0;i<Main.getTablero().darNumFilas();i++) {
				for(int j=0;j<Main.getTablero().darNumColumnas();j++) {
					if(Main.getTablero().getCasillas()[i][j].estaMinada()==true) {
						File file = new File("src/img/mina.png");
						Image image = new Image(file.toURI().toString());
						ImageView imageView = new ImageView(image);
						imageView.setFitWidth(20);
						imageView.setFitHeight(20);
						tab[i][j].setGraphic(imageView);
					}
				}
			}
			Main.getTablero().perder();
		}else {	
			tab[f][c].setText(Integer.toString(Main.getTablero().getCasillas()[f][c].darMinadasAdyacentes()));
		}
		Main.getTablero().setCasillasDestapadas(Main.getTablero().getCasillasDestapadas()+1);
	}
	
	public void pista() {
		butHint.setOnAction(e ->{
			try {
				String pos=Main.getTablero().darPista();
				String[] ne=pos.split("_");
				int f=Integer.parseInt(ne[0]);
				int c=Integer.parseInt(ne[1]);
				destaparCasilla(f,c);
				Main.getTablero().setCasillasDestapadas(Main.getTablero().getCasillasDestapadas()-1);
				desactivarPista();
			}catch(JuegoTerminado jT) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Announcement");
				alert.setHeaderText("be careful");
				alert.setContentText(jT.getMessage());

				alert.showAndWait();
			}
			
		});
	}
	
	public void desactivarPista() {
		if(limite<4) {
			limite++;
		}else {
			butHint.setDisable(true);
		}
	}
	
	public void rendirse() {
		try{
			Main.getTablero().solucionar();
			for(int i=0;i<Main.getTablero().darNumFilas();i++) {
				for(int j=0;j<Main.getTablero().darNumColumnas();j++) {
					destaparCasilla2(i, j);
				}
			}
		}catch(JuegoTerminado jT) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Announcement");
			alert.setHeaderText("be careful");
			alert.setContentText(jT.getMessage());

			alert.showAndWait();
		}
	}
	
	public void perder() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Announcement");
		alert.setHeaderText("game summary");
		alert.setContentText("PERDISTE CARNALIT@"+"\n"+"\n"+"YOU LOSE MY FRIEND");

		alert.showAndWait();
	}
	
	public void ganar() {
		if(Main.getTablero().getCasillasDestapadas()==Main.getTablero().getCasillasSeguras()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Announcement");
			alert.setHeaderText("game summary");
			alert.setContentText("WINNER WINNER, CHICKEN DINNER"+"\n"+"\n"+"GANARÉ, GANARÉ Y GALLINA CENARÉ");

			alert.showAndWait();
		}
	}
	
}
