package menu;

public abstract class MenuComponent {

    public Menu add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public Menu remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void setName() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
    
    public void execute() {
        throw new UnsupportedOperationException();
    }

    public MenuAction choose() {
        throw new UnsupportedOperationException();
    }
}