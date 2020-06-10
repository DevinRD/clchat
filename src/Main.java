import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader sysIn;

    private Main() {
        sysIn = new BufferedReader(new InputStreamReader(System.in));
    }

    private void execute() {
        menu();
    }

    private void menu() {
        String menuList = "1) join chatroom\n" +
                          "2) create chatroom\n" +
                          "3) manage friends\n" +
                          "4) settings\n" +
                          "5) exit";

        int choice = -1;

        do {
            System.out.println(menuList);
            try {
                choice = Integer.parseInt(sysIn.readLine());
                if (choice < 1 || choice > 5) throw new Exception();
                System.out.println();

            } catch (IOException e) {
                System.out.println("\nThere was an input problem");
                System.exit(1);

            } catch (NumberFormatException e) {
                System.out.println("\nEnter a number.\n");
                choice = -1;
            } catch (Exception e) {
                System.out.println("\nInvalid selection.\n");
                choice = -1;
            }

        } while (choice == -1);

        if (choice == 1) { // join chatroom

        }
        else if (choice == 2) { // create chatroom

        }
        else if (choice == 3) { // manage friends
            friendsMenu();
        }
        else if (choice == 4) { // settings
            settingsMenu();
        }
        else if (choice == 5) { // exit
            // do nothing
        }
        else {
            // should never happen
            System.out.println("Programmer, there was in invalid choice in menu()");
            System.exit(1);
        }
    }

    private void friendsMenu() {

    }

    private void settingsMenu() {

    }

    public static void main(String[] args) {
        new Main().execute();
    }

}