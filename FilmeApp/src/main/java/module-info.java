module com.example.filmeapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.filmeapp to javafx.fxml;
    exports com.example.filmeapp;
}