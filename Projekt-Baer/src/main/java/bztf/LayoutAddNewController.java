package bztf;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.stage.Window;


public class LayoutAddNewController {

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

    @FXML
    private void BackToMain() throws IOException {
        App.setRoot("Layout1");
    }

    @FXML
    private void NewDB() throws IOException {

        Window owner = CreateButton.getScene().getWindow();
        
        if (DBName.getText().isEmpty()) {
            System.out.println("Form Error! Please enter a name for the new database");
            return;
        }

        if (PWField.getText().isEmpty()) {
            System.out.println("Form Error! Please enter a password");
            return;
        }

        if (PWField.getText() != PWConField.getText()) {
            System.out.println("Form Error! Passwords do not match");
            return;
        }

        if (!DBName.getText().isEmpty() && PWField.getText() == PWConField.getText()) {
            System.out.println("Success");
        }
    }
}
