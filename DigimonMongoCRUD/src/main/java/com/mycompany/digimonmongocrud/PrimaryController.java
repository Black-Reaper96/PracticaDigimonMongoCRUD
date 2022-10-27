package com.mycompany.digimonmongocrud;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;

public class PrimaryController {
    @FXML
    private ChoiceBox tipo;
    @FXML
    private TextField nombre;
    @FXML
    private TextField emblema;
    @FXML
    private TextField evDe;
    @FXML
    ObservableList<String> tipos = FXCollections.
            observableArrayList("","Vacuna","Virus","Datos","Libre","Variable","Desconocido");
    
    @FXML
    private TableView<Digimon> tabla;
    @FXML
    private TableColumn<Digimon, String> colNombre;
    @FXML
    private TableColumn<Digimon, String> colEvDe;
    @FXML
    private TableColumn<Digimon, String> colEmblema;
    @FXML
    private TableColumn<Digimon, String> colTipo;
   
    @FXML
    private void initialize() throws IOException {
        tipo.setItems(tipos);
        
        MongoCRUD.obtenerDigimon(tabla, colNombre, colEvDe, colEmblema, colTipo);
    }
    
    @FXML
    private void Limpiar()throws IOException {
        nombre.setText("");
        emblema.setText("");
        evDe.setText("");
        tipo.setValue("");
    }
    
    @FXML
    private void mostrarDatosTabla(){
        if(this.tabla != null){
            List<Digimon> item = this.tabla.getSelectionModel().getSelectedItems();
            final Digimon dMostrar = item.get(0);
            this.nombre.setText(dMostrar.getNombre());
            this.evDe.setText(dMostrar.getEvDe());
            this.emblema.setText(dMostrar.getEmblema());
            this.tipo.setValue(dMostrar.getTipo());
        }
        
        
    }
    
    @FXML
    private void Guardar()throws IOException {
        
        MongoCRUD.insertarDigimon(nombre.getText(),emblema.getText(),evDe.getText(),tipo.getValue().toString());
        MongoCRUD.obtenerDigimon(tabla, colNombre, colEvDe, colEmblema, colTipo);
        this.nombre.setText("");
        this.emblema.setText("");
        this.evDe.setText("");
        this.tipo.setValue("");
    }
    
}
