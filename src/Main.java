import menu.*;

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
        MenuAction action;
        while ((action = mainMenu.choose()) != null) action.execute();
    }

    private void buildMenu() {
        Menu tempMenu = null;
        
        /*
        tempMenu = new Menu("host room");
        tempMenu.add(new GeneralAction("new room", () -> System.out.println("Creating new room")));
        tempMenu.add(new GeneralAction("existing room", () -> System.out.println("Starting existing room")));
        tempMenu.add(new MenuReturn("back"));
        mainMenu.add(tempMenu); // "host room"
        */

        mainMenu.add(new HostChatroomAction("host room"));

        mainMenu.add(new GeneralAction("join room", () -> System.out.println("Joining room")));

        tempMenu = new Menu("manage aliases");
        tempMenu.add(new GeneralAction("create alias", () -> System.out.println("Creating alias")));
        tempMenu.add(new GeneralAction("edit alias", () -> System.out.println("Editing alias")));
        tempMenu.add(new GeneralAction("delete alias", () -> System.out.println("Deleting alias")));
        tempMenu.add(new MenuReturn("back"));
        mainMenu.add(tempMenu); // "manage aliases"

        tempMenu = new Menu("settings");
        tempMenu.add(new GeneralAction("mute ip address", () -> System.out.println("ip address has been muted")));
        tempMenu.add(new MenuReturn("back"));
        mainMenu.add(tempMenu); // "settings"

        mainMenu.add(new MenuReturn("exit"));
    }

    public static void main(String[] args) {
        new Main().execute();
    }

}