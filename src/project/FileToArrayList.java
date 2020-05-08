package project;

import java.io.File;
import java.util.ArrayList;

public class FileToArrayList {
    ArrayList setMessages(File file) throws Exception {
        ArrayList<Message> sortedMessages = new ArrayList<Message>();
        MessageGetter getter = new MessageGetter();
        ArrayList unsortedMessages = getter.getAll(file);
        Setter setter = new Setter();
        for (Object unsortedMessage : unsortedMessages) {
            sortedMessages.add(setter.putMain(new Message(), (String) unsortedMessage));
        }
        return sortedMessages;
    }
}
