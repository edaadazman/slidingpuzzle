import java.util.*;

public class App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Player player = new Player(in);

            while (true) {
                System.out.println("\n=== GAME MENU ===");
                System.out.println("1. Sliding Puzzle");
                System.out.println("2. Dots and Boxes");
                System.out.println("3. Quit");

                String choice = player.getInput("Choose a game (1-3): ");

                if (choice == null) {
                    System.out.println("Input ended. Goodbye!");
                    break;
                } else if (choice.equals("1")) {
                    SlidingPuzzleGame slidingGame = new SlidingPuzzleGame(in);
                    slidingGame.run();
                } else if (choice.equals("2")) {
                    DotsAndBoxesGame dotsGame = new DotsAndBoxesGame(player);
                    dotsGame.run();
                } else if (choice.equals("3")) {
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
