public abstract class MenuAction extends MenuComponent {

    private String name;

    public MenuAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public void execute() {

    }

    public String toString() {
        return name;
    }

}