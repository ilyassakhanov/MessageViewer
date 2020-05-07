package project;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public File onSelectFile(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            return selectedFile.getAbsoluteFile();
        }
        return null;
    }
}
