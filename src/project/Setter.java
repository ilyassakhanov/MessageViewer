package project;

public class Setter extends RegexMatcher {


    Message putTime(Message message, String data) throws Exception {
        String time = getInfo(data, "\\d{2}:\\d{2}:\\d{2}");
        message.setTime(time);
        return message;
    }

    Message putText(Message message, String data) throws Exception {
        String text = getInfoGroup(data, "Message:(.*)");
        message.setText(text);
        return message;

    }

    Message putNick(Message message, String data, String prevNick) throws Exception {
        String nickname = getInfoGroup(data, "Name:(.*)");
        if (nickname.equals(prevNick)) {
            message.setNick("...");
            return  message;
        }else {
            message.setNick(nickname);
            return message;
        }
    }

    Message putMain(Message message, String data, String prevNick) throws Exception {
        message = putTime(message, data);
        message = putNick(message, data, prevNick);
        message = putText(message, data);
        return message;
    }
}
