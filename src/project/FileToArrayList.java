package project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * A class that deals with connecting FileChooser output and message processing classes
 * */
public class FileToArrayList {
    /**
     * @param file A file with messages
     * @return ArrayList of Message constructors with set values
     * */
    ArrayList setMessages(File file) throws Exception {
        String prevNick = "";
        ArrayList<Message> sortedMessages = new ArrayList<Message>();
        MessageGetter getter = new MessageGetter();
        ArrayList unsortedMessages = getter.getAll(file);
        Setter setter = new Setter();
        for (Object unsortedMessage : unsortedMessages) {
            sortedMessages.add(setter.putMain(new Message(), (String) unsortedMessage, prevNick));
            if (!sortedMessages.get(sortedMessages.size() - 1).getNick().equals("...")) {
                prevNick = sortedMessages.get(sortedMessages.size() - 1).getNick();
            }
        }
        return sortedMessages;
    }
}
