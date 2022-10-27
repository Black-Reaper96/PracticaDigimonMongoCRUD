/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonmongocrud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author am199
 */
public class Digimon {
    private int id;
    private String Nombre;
    private String evDe;
    private String Emblema;
    private String Tipo;

    public Digimon(String Nombre, String evDe, String Emblema, String Tipo) {
        this.Nombre = Nombre;
        this.evDe = evDe;
        this.Emblema = Emblema;
        this.Tipo = Tipo;
    }
    
    public Digimon(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public Digimon(){}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEvDe() {
        return evDe;
    }

    public void setEvDe(String evDe) {
        this.evDe = evDe;
    }

    public String getEmblema() {
        return Emblema;
    }

    public void setEmblema(String Emblema) {
        this.Emblema = Emblema;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
        
    
}
