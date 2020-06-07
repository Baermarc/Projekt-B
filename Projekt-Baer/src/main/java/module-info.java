module bztf {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;

    opens bztf to javafx.fxml;
    exports bztf;
}