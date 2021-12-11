module com.example.primeirofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.example.primeirofx to javafx.fxml;
    exports com.example.primeirofx;
}