module com.mycompany.digimonmongocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;
    opens com.mycompany.digimonmongocrud to javafx.fxml;
    exports com.mycompany.digimonmongocrud;
}
