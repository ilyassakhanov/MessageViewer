package project;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MessageConstructor {
    TextFlow constructTime(Message msgConstr, TextFlow textFlow) {
        textFlow.getChildren().add(new Text("[" + msgConstr.getTime() + "]"));
        return textFlow;
    }

    TextFlow constructName(Message msgConstr, TextFlow textFlow) {
        textFlow.getChildren().add(new Text(msgConstr.getNick() + ":"));
        return textFlow;
    }

    TextFlow constructText(Message msgConstr, TextFlow textFlow) {
        EmojiDecoder decoder = new EmojiDecoder();
        textFlow.getChildren().add(new Text(decoder.decodeEmojis(msgConstr.getText() + "\n")));
        return textFlow;
    }

    TextFlow constructMain(Message messageConstr, TextFlow textFlow) {

        textFlow = constructTime(messageConstr, textFlow);
        textFlow = constructName(messageConstr, textFlow);
        textFlow = constructText(messageConstr, textFlow);

        return textFlow;
    }
}
