public class Main {

    private Main(){}; // make this class inaccessible to outsiders

    public void execute() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new Main().execute();
    }

}