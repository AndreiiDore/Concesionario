module clases {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens clases to javafx.fxml;
    exports clases;
}
