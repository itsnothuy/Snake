public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Window window = Window.getWindow();

        Thread thread = new Thread(window);
        thread.start();
    }
}