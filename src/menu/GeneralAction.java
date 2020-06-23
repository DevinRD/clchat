package menu;

public class GeneralAction extends MenuAction {

    public interface Action {
        void execute();
    }

    private Action action;

    public GeneralAction(String name, Action action) {
        super(name);
        this.action = action;
    }

    public void execute() {
        action.execute();
    }
}