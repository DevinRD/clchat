import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader sysIn;

    private Menu mainMenu;

    private Main() {
        sysIn = new BufferedReader(new InputStreamReader(System.in));
        mainMenu = new Menu("Main");
    }

    private void execute() {
        buildMenu();
        mainMenu.execute();
    }

    private void buildMenu() {
        mainMenu.add(new Menu("join chatroom"));
        mainMenu.add(new Menu("host chatroom"));
        mainMenu.add(new Menu("enter chatroom"));

        Menu friendsMenu = new Menu("manage friends");
        friendsMenu.add(new Menu("create friend"));
        friendsMenu.add(new Menu("delete friend"));
        friendsMenu.add(new Menu("back"));
        mainMenu.add(friendsMenu);

        mainMenu.add(new Menu("settings"));
        mainMenu.add(new MenuReturn("return"));
    }

    public static void main(String[] args) {
        new Main().execute();
    }

}