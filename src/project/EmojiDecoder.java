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
                    textFlow.getChildren().addAll(new ImageView(imageSmile));
                    i++;
                    continue;
                } else  if (((msg.getText().charAt(i) == ':') && (msg.getText().charAt(i + 1) == '('))){
                    textFlow.getChildren().addAll(new ImageView(imageSad));
                    i++;
                    continue;
                }
            }
            textFlow.getChildren().addAll(new Text((Character.toString(msg.getText().charAt(i)))));
        }
        return textFlow;
    }
}
