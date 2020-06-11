package bztf;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.stage.Window;

//Comment for Test Commit / Push

/*
import java.net.URL;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
*/

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static String URL = "jdbc:mysql://localhost:3306/Passwords?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String User = "root";
    public static Connection connection;
    public static Statement statement;

    // Scene: New Database

    @FXML
    public static TextField DBName;

    @FXML
    public static PasswordField PWField;

    @FXML
    public static PasswordField PWConField;

    @FXML
    public static Button CreateButton;

    @FXML
    public static Button CancelButton;

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    @FXML
    public void creation() throws SQLException {

        Window owner = CreateButton.getScene().getWindow();

        if (DBName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a name for the new database");
            return;
        }

        if (PWField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
            return;
        }

        if (PWField.getText() != PWConField.getText()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Passwords do not match");
            return;
        }

        if (!DBName.getText().isEmpty() && PWField.getText() == PWConField.getText()) {
            System.out.println("Success");
        }

        connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootpassword");
        statement = connection.createStatement();
        int Result = statement.executeUpdate("CREATE DATABASE databasename");

    }

    // Scene: Main Window

    @FXML
    private MenuItem NewDBButton;

    public static void main(String[] args) {
        try {
            connect();
        } catch (Exception e) {
            // TODO: handle exception
        }
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("PassVault");
        scene = new Scene(loadFXML("Layout1"), 1200, 800);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void connect() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, User, "");
    }
}