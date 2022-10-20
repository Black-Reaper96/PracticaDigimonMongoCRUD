module com.mycompany.digimonmongocrud {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.digimonmongocrud to javafx.fxml;
    exports com.mycompany.digimonmongocrud;
}
