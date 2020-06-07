package bztf;
import java.io.IOException;
import javafx.fxml.FXML;


public class LayoutAddNewController {

    @FXML
    private void BackToMain() throws IOException {
        App.setRoot("Layout1");
    }
}
