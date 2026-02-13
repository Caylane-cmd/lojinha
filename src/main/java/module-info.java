module com.example.lojinha {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.lojinha to javafx.fxml;
    exports com.example.lojinha;
}