package project;


import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.io.FileNotFoundException;

/**
 * A class that deals with constructing the message for GUI
 */

public class MessageConstructor {
    /**
     * @param msgConstr a message constructor with data to create a message
     * @param textFlow  a textflow with previous messages that were displayed
     * @return textFlow that has time added to it
     */
    TextFlow constructTime(Message msgConstr, TextFlow textFlow) {
        textFlow.getChildren().add(new Text("[" + msgConstr.getTime() + "]"));
        return textFlow;
    }

    /**
     * @param msgConstr a message constructor with data to create a message
     * @param textFlow  with time added to it
     * @return textflow with time and a nickname
     */
    TextFlow constructName(Message msgConstr, TextFlow textFlow) {
        Text text = new Text(msgConstr.getNick());
        text.setFill(Color.BLUE);
        textFlow.getChildren().add(text);
        return textFlow;
    }

    /**
     * @param msgConstr message constructor with data to create a message
     * @param textFlow  with time and name added to it
     * @return textflow with time, nickname and text
     */
    TextFlow constructText(Message msgConstr, TextFlow textFlow) {
//        EmojiDecoder decoder = new EmojiDecoder();
        textFlow.getChildren().add(new Text((":" + msgConstr.getText()) + "\n"));
        return textFlow;
    }

    /**
     * @param textFlow A textflow that has previous messages
     * @param messageConstr message constructor with data to create a message
    * */
    TextFlow constructMain(Message messageConstr, TextFlow textFlow) throws FileNotFoundException {

        textFlow = constructTime(messageConstr, textFlow);
        textFlow = constructName(messageConstr, textFlow);
        textFlow = constructText(messageConstr, textFlow);

        return textFlow;
    }
}
