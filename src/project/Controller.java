package project;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    public Button selectFileButton;
    public TextArea mainTextArea;
    public Text pathText;


    public File onSelectFile(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        FileToArrayList converter = new FileToArrayList();
        File selectedFile = fc.showOpenDialog(null);
        MessageConstructor constructor = new MessageConstructor();

        if (selectedFile != null) {
            try {
                ArrayList<Message> test = converter.setMessages(selectedFile.getAbsoluteFile());
                pathText.setText(selectedFile.getAbsolutePath());
                System.out.println(constructor.constructMain(test.get(0)));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The file has incorrect format!", ButtonType.OK);
                alert.show();
                pathText.setText("");
            }
        }
        return null;
    }
}
