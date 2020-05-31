package project;

/**
 * A class that gets the data from the sandalone message, uses tools for it from RegexMatcher
 */
public class Setter extends RegexMatcher {

    /**
     * @param data    a standalone message
     * @param message a blank message object
     * @return a message object with a set time
     */
    Message putTime(Message message, String data) throws Exception {
        String time = getInfo(data, "\\d{2}:\\d{2}:\\d{2}");
        message.setTime(time);
        return message;
    }

    /**
     * @param message a message object with blank text
     * @return a message object with a set text
     */
    Message putText(Message message, String data) throws Exception {
        String text = getInfoGroup(data, "Message:(.*)");
        message.setText(text);
        return message;

    }

    /**
     * @param message  a message object with blank nickname
     * @param data     a standalone message
     * @param prevNick a nickname that was used in a previous message
     * @return a message object that has a nickname set
     */

    Message putNick(Message message, String data, String prevNick) throws Exception {
        String nickname = getInfoGroup(data, "Name:(.*)");
        if (nickname.equals(prevNick)) {
            message.setNick("...");
            return message;
        } else {
            message.setNick(nickname);
            return message;
        }
    }

    /**
     * @param message a blank message
     * @param prevNick a a nickname that was used in a previous message
     * @param data a standalone message
     * @return a message object that has every field set
     * */
    Message putMain(Message message, String data, String prevNick) throws Exception {
        message = putTime(message, data);
        message = putNick(message, data, prevNick);
        message = putText(message, data);
        return message;
    }
}
