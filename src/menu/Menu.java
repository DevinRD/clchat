package menu;

import java.util.ArrayList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu extends MenuComponent {
    
    private String name;
    private ArrayList<MenuComponent> items;

    private static BufferedReader sysIn;

    public Menu(String name) {
        this.name = name;
        sysIn = new BufferedReader(new InputStreamReader(System.in));
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

    public Menu add(MenuComponent item) {
        items.add(item);
        return this;
    }

    public Menu remove(int index) {
        items.remove(index);
        return this;
    }

    public MenuAction choose() {
        if (items.size() == 0) return null;

        int choice = -1;
        MenuComponent menuChoice;

        do {
            do {
                print();

                try {
                    System.out.print("-> ");
                    choice = Integer.parseInt(sysIn.readLine());
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

            menuChoice = items.get(choice - 1).choose();
            if (menuChoice instanceof MenuReturn) return null;

        } while (!(menuChoice instanceof MenuAction));

        return (MenuAction) menuChoice;
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