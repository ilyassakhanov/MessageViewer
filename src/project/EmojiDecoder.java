package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EmojiDecoder {
    String smilePath = new File("Resources/smile_happy.gif").getAbsolutePath();
    FileInputStream inputstreamSmile = new FileInputStream(smilePath);
    Image imageSmile = new Image(inputstreamSmile);
    ImageView smile = new ImageView(imageSmile);
    String sadPath = new File("Resources/smile_sad.gif").getAbsolutePath();
    FileInputStream inputstreamSad = new FileInputStream(sadPath);
    Image imageSad = new Image(inputstreamSad);
    ImageView sad = new ImageView(imageSad);

    public EmojiDecoder() throws FileNotFoundException {
    }

    TextFlow decodeEmojis(TextFlow textFlow, Message msg) {
        for (int i = 0; i < msg.getText().length(); i++) {
            if ((i + 1) < msg.getText().length()) {
                if (((msg.getText().charAt(i) == ':') && (msg.getText().charAt(i + 1) == ')'))) {
                    textFlow.getChildren().add(smile);
                    i++;
                    continue;
                } else  if (((msg.getText().charAt(i) == ':') && (msg.getText().charAt(i + 1) == '('))){
                    textFlow.getChildren().add(sad);
                    i++;
                    continue;
                }
            }
            textFlow.getChildren().add(new Text((Character.toString(msg.getText().charAt(i)))));
        }
        return textFlow;
    }
}
