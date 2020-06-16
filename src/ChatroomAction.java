import menu.*;

public class ChatroomAction extends MenuAction {

    public interface Action {
        void execute();
    }

    private Action action;

    public ChatroomAction(String name, Action action) {
        super(name);
        this.action = action;
    }

    public void execute() {
        action.execute();
    }

}