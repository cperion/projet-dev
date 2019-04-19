package principal;

import java.util.List;

public class Inbox {
    List<Message> messages;

    @Override
    public String toString() {
        String out = "";
        for (Message m: messages) {
            out += "de :" + m.getEnvoyeur()+ "\n";
            out += "a :" + m.getDestinataire()+"\n";
            out+= m.getMsg()+"\n";
        }
        return out;
    }
}