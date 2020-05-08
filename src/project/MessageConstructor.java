package project;

public class MessageConstructor {
    String constructTime(Message msgConstr, String messageFinal) {
        messageFinal = String.format("[%s]", msgConstr.getTime());
        return messageFinal;
    }

    String constructName(Message msgConstr, String messageFinal) {
        messageFinal = String.format(messageFinal + msgConstr.getNick());
        return messageFinal;
    }

    String constructText(Message messageConstr, String messageFinal) {
        messageFinal = messageFinal + ":" + messageConstr.getText();
        return messageFinal;
    }
    String constructMain(Message messageConstr){
        String messageFinal = null;
        messageFinal = constructTime(messageConstr, messageFinal);
        messageFinal = constructName(messageConstr, messageFinal);
        messageFinal = constructText(messageConstr, messageFinal);

        return messageFinal;
    }
}
