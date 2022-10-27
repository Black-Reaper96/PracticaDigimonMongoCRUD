module com.mycompany.digimonmongocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;
    opens com.mycompany.digimonmongocrud to javafx.fxml;
    exports com.mycompany.digimonmongocrud;
}
