import menus.*;

public class Main {

    private Main(){}; // make this class inaccessible to outsiders

    public void execute() {
        MainVMenu menu = new MainVMenu();
    }

    public static void main(String[] args) {
        new Main().execute();
    }

}