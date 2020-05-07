package project;

public class Setter extends RegexMatcher {
    Message putTime(Message message, String data) {
        String time = getInfo(data, ":\\d{2}:\\d{2}\\d{2}");
        message.setTime(time);
        return message;
    }

    Message putText(Message message, String data) {
        String text = getInfoGroup(data, "Message:(.*)");
        message.setText(text);
        return message;

    }
    Message putNick(Message message, String data){
        String nickname = getInfoGroup(data, "Name:(.*)" );
        message.setNick(nickname);
        return message;
    }
}
