import java.util.ArrayList;

import java.io.IOException;

public class Menu extends MenuComponent {
    
    private String name;
    private ArrayList<MenuComponent> items;

    public Menu(String name) {
        this.name = name;
        items = new ArrayList<MenuComponent>();
    }

    public Menu(String name, ArrayList<MenuComponent> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public void add(MenuComponent item) {
        items.add(item);
    }

    public void remove(Menu item) { // TODL: 

    }

    public void execute() { // FIXME: Figure out how to go back one menu
        int choice = -1;
        MenuComponent menuChoice;

        do {
            do {
                print();

                try {
                    System.out.print("-> ");
                    choice = Integer.parseInt(Main.sysIn.readLine());
                    if (choice < 1 || choice > items.size()) throw new Exception();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                } catch (NumberFormatException e) {
                    System.out.println("\nEnter a number.");
                    choice = -1; // redundent
                } catch (Exception e) {
                    System.out.println("Invalid option.");
                    choice = -1;
                }
            } while (choice == -1);

            menuChoice = items.get(choice - 1);
            menuChoice.execute();

        } while (!(menuChoice instanceof MenuReturn));

    }

    public void print() {
        String output = "";
        if (items.size() > 0) output += "1) " + items.get(0);
        for (int i = 1; i < items.size(); i++) output += "\n" + (i+1) + ") " + items.get(i);
        System.out.println(output);
    }

    public String toString() {
        return name;
    }

}