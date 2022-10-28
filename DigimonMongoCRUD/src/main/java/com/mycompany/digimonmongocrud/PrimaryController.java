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
import javafx.scene.control.Button;
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
    private TextField id;
    @FXML
    private TextField nombre;
    @FXML
    private TextField emblema;
    @FXML
    private TextField evDe;
    @FXML
    private Button modificar;
    @FXML
    private Button eliminar;
    @FXML
    private Button guardar;
    @FXML
    private Button cancelar;
    @FXML
    private Button nuevo;
    
    @FXML
    ObservableList<String> tipos = FXCollections.
            observableArrayList("","Vacuna","Virus","Datos","Libre","Variable","Desconocido");
    
    @FXML
    private TableView<Digimon> tabla;
    @FXML
    private TableColumn<Digimon, String> colNombre;
     @FXML
    private TableColumn<Digimon, Integer> colID;
    @FXML
    private TableColumn<Digimon, String> colEvDe;
    @FXML
    private TableColumn<Digimon, String> colEmblema;
    @FXML
    private TableColumn<Digimon, String> colTipo;
   
    @FXML
    private void initialize() throws IOException {
        tipo.setItems(tipos);
        
        MongoCRUD.obtenerDigimon(tabla, colID,  colNombre, colEvDe, colEmblema, colTipo);
    }
    
    @FXML
    private void Limpiar()throws IOException {
        this.id.setDisable(false);
        this.emblema.setDisable(false);
        this.nombre.setDisable(false);
        this.evDe.setDisable(false);
        this.tipo.setDisable(false);
        this.cancelar.setVisible(true);
        this.guardar.setVisible(true);
        this.nuevo.setVisible(false);
    }
    
    @FXML
    private void mostrarDatosTabla(){
        if(this.tabla != null){
            List<Digimon> item = this.tabla.getSelectionModel().getSelectedItems();
            final Digimon dMostrar = item.get(0);
            String id= " "+dMostrar.get_id()+" ";
            this.id.setText(id.trim());
            this.nombre.setText(dMostrar.getNombre());
            this.evDe.setText(dMostrar.getEvDe());
            this.emblema.setText(dMostrar.getEmblema());
            this.tipo.setValue(dMostrar.getTipo());
            this.emblema.setDisable(false);
            this.nombre.setDisable(false);
            this.evDe.setDisable(false);
            this.tipo.setDisable(false);
            this.modificar.setDisable(false);
            this.eliminar.setDisable(false);
        }
        
        
    }
    
    @FXML
    private void Guardar()throws IOException {
        
        MongoCRUD.insertarDigimon(Integer.parseInt(id.getText()),nombre.getText(),emblema.getText(),evDe.getText(),tipo.getValue().toString());
        MongoCRUD.obtenerDigimon(tabla, colID,  colNombre, colEvDe, colEmblema, colTipo);
        Cancelar();
    }
    
    @FXML
    private void Eliminar()throws IOException {
        
        MongoCRUD.eliminarDigimon(Integer.parseInt(id.getText().trim()));
        MongoCRUD.obtenerDigimon(tabla, colID,  colNombre, colEvDe, colEmblema, colTipo);
        Cancelar();
    }
    
    
    @FXML
    private void Cancelar()throws IOException {
        this.id.setText("");
        this.nombre.setText("");
        this.emblema.setText("");
        this.evDe.setText("");
        this.tipo.setValue("");
        this.cancelar.setVisible(false);
        this.guardar.setVisible(false);
        this.nuevo.setVisible(true);
        this.id.setDisable(true);
        this.emblema.setDisable(true);
        this.nombre.setDisable(true);
        this.evDe.setDisable(true);
        this.tipo.setDisable(true);
        
    
    }
    
    @FXML
    private void Modificar()throws IOException {
        System.out.println(nombre.getText()+" "+emblema.getText()+" "+evDe.getText()+" "+tipo.getValue().toString());
        MongoCRUD.modificarDigimon(Integer.parseInt(id.getText().trim()),nombre.getText(),emblema.getText(),evDe.getText(),tipo.getValue().toString());
        MongoCRUD.obtenerDigimon(tabla, colID,  colNombre, colEvDe, colEmblema, colTipo);
        Cancelar();
    }
    
}
