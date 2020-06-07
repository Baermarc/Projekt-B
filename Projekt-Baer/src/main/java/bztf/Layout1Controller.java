package bztf;

import java.io.IOException;
import javafx.fxml.FXML;

public class Layout1Controller {

    @FXML
    private void CreateNewDB() throws IOException{
        App.setRoot("LayoutAddNew");
    }
}
