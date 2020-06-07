package bztf;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void SwitchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
