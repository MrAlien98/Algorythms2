package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AplicacionController {
	
	@FXML private ListView<String> lista;
	@FXML private ListView<String> listaP;
	@FXML private ListView<String> listaR;
	
	@FXML private Button butGuardarPedido;
	
	@FXML private Label labTotal;
	@FXML private Label labUsuario;
	
	@FXML private ObservableList<String> dataLista = FXCollections.observableArrayList();
	@FXML private ObservableList<String> dataListaP = FXCollections.observableArrayList();
	@FXML private ObservableList<String> dataListaR = FXCollections.observableArrayList();
	
	public AplicacionController() {
		labTotal=new Label();
		labTotal.setText("0");
	}
	
	public void initialize() {
		for(int i=0;i<Main.getCarta().getMenu().size();i++) {
			dataLista.add(Main.getCarta().getMenuN().get(i));
		}
		lista.setItems(dataLista);
		lista.getSelectionModel().selectedItemProperty().addListener(e->{
			dataListaP.clear();
			for(int i=0;i<Main.getCarta().getMenuN().size();i++) {
				if(i==lista.getSelectionModel().getSelectedIndex()) {
					for(int j=0;j<Main.getCarta().getMenu().get(i).getPlatillosN().size();j++) {
						dataListaP.add(Main.getCarta().getMenu().get(i).getPlatillosN().get(j));
					}
				}
			}
			listaP.setItems(dataListaP);
		});
		listaP.getSelectionModel().selectedItemProperty().addListener(e->{
			
		});
//		lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				dataListaP.clear();
//				for(int i=0;i<Main.getCarta().getMenuN().size();i++) {
//					if(Main.getCarta().getMenuN().get(i).equals(newValue)) {
//						for(int j=0;j<Main.getCarta().getMenu().get(i).getPlatillosN().size();j++) {
//							dataListaP.add(Main.getCarta().getMenu().get(i).getPlatillosN().get(j));
//						}
//					}
//				}
//				listaP.setItems(dataListaP);
//				listaP.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//					@Override
//					public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//						String[] comp=newValue.split(" : ");
//						dataListaR.add(comp[0]);
//						int precio=Integer.parseInt(comp[1]);
//						int total=Integer.parseInt(labTotal.getText());
//						int nuevoTotal=precio+total;
//						labTotal.setText(Integer.toString(nuevoTotal));
//						listaR.setItems(dataListaR);
//					}
//				});
//			}
//		});	
	}
	
	
	
	
}
