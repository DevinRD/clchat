import menu.*;

import java.io.IOException;

public class HostChatroomAction extends MenuAction {

    public HostChatroomAction(String name) {
        super(name);
    }
    public void execute() {
        Chatroom chat = null;
        try {
            chat = new Chatroom();
            chat.start();
            chat.close();
        } catch (IOException e) {
            System.out.println("Could not start chatroom");
        }
    }
}