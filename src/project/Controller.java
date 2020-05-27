package project;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    File prevPath = null;
    public Button selectFileButton;
    public Text pathText;
    public TextFlow mainTextFlow;

    /**
     * A method that connects UI with message processing
     * @param actionEvent launches on click of a select file button
     * @return null, the outcome of this method is in the GUI
     */
    public File onSelectFile(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(prevPath);
        FileToArrayList converter = new FileToArrayList();
        File selectedFile = fc.showOpenDialog(null);
        MessageConstructor constructor = new MessageConstructor();

        if (selectedFile != null) {
            try {
                ArrayList<Message> messagesObjcts = converter.setMessages(selectedFile.getAbsoluteFile());
                pathText.setText(selectedFile.getAbsolutePath());
                prevPath = selectedFile.getParentFile();
                for (int i = 0; i < messagesObjcts.size(); i++) {
                    mainTextFlow = constructor.constructMain(messagesObjcts.get(i), mainTextFlow);
                }
            } catch (java.lang.Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The file has incorrect format!", ButtonType.OK);
                alert.show();
                pathText.setText("");
                mainTextFlow = new TextFlow(new Text(""));
            }
        }
        return null;
    }
}
