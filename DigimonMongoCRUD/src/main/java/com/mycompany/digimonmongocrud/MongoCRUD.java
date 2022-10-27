/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonmongocrud;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;

/**
 *
 * @author am199
 */
public class MongoCRUD {
    

    
    public static void insertarDigimon(String n, String e, String ev, String t){
        MongoClient con;
        MongoCollection<Document> collection = null;
        String json;
        Document doc;
        try {
            con=ConnectionDB.conectar();
            MongoDatabase database = con.getDatabase("Digimon");
            collection = database.getCollection("Digimon");
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
        
        Digimon d1 = new Digimon();
        
        d1.setNombre(n);
        d1.setEvDe(ev);
        d1.setEmblema(e);
        d1.setTipo(t);
        Document digimon = new Document();
        digimon.append("nombre", d1.getNombre())
                .append("evDe", d1.getEvDe())
                .append("emblema", d1.getEmblema())
                .append("tipo", d1.getTipo());
        collection.insertOne(digimon);
    }
  
    
    public static void obtenerDigimon(TableView tabla, TableColumn colNombre,TableColumn colEvDe, TableColumn colEmblema, TableColumn colTipo){
        MongoClient con;
        MongoCollection<Document> collection=null;
        
        ObservableList<Digimon> obs = FXCollections.observableArrayList();
        try {
            con=ConnectionDB.conectar();
            MongoDatabase database = con.getDatabase("Digimon");
            collection = database.getCollection("Digimon");
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
        MongoCursor<Document> cursor3 = collection.find().iterator();
        
             try {
                while (cursor3.hasNext()) {
                    
                    Document json1 = cursor3.next();
                    
                    Digimon d3 = new Digimon(json1.getString("nombre"),json1.getString("evDe"),json1.getString("emblema"),json1.getString("tipo"));
                    
                    obs.add(d3);
                    tabla.setItems(obs);
                    colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
                    colEvDe.setCellValueFactory(new PropertyValueFactory("evDe"));
                    colEmblema.setCellValueFactory(new PropertyValueFactory("emblema"));
                    colTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
                    
                }

            } finally {
                cursor3.close();
            }  
            
    }
    
}
