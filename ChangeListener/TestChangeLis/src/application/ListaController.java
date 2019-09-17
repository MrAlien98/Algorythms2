package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListaController {
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ListView lista;
	@FXML
	private TextField txNombre;
	
	@FXML
	private ObservableList<String> dataLista = FXCollections.observableArrayList();
	
	public ListaController() {
		
	}
	
	@SuppressWarnings("unchecked")
	public void initialize() {
		
		for(int i=0;i<)
		
		dataLista.add("Bart");
		dataLista.add("Burns");
		dataLista.add("MilHouse");
		dataLista.add("Krusty");
		
		lista.setItems(dataLista);
		
		lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				txNombre.setText(newValue);
			}
		
		});
	}
	
}
