import java.util.*;

public class App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            GameMenu menu = new GameMenu(in);
            menu.runGameLoop();
        }
    }
}
