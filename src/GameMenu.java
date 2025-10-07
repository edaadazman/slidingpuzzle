import java.util.Scanner;

public class GameMenu {
    private final Scanner scanner;

    public GameMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("\n=== Game Selection Menu ===");
        System.out.println("1. Sliding Puzzle");
        System.out.println("2. Dots and Boxes");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
    }

    public int getMenuChoice() {
        while (true) {
            displayMenu();
            try {
                String input = scanner.nextLine().trim();
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 3) {
                    return choice;
                }
                System.out.println("Please enter a number between 1 and 3.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void runGameLoop() {
        System.out.println("Welcome to the Game Collection!");

        while (true) {
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    runSlidingPuzzle();
                    break;
                case 2:
                    runDotsAndBoxes();
                    break;
                case 3:
                    System.out.println("Thanks for playing! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void runSlidingPuzzle() {
        System.out.println("\nStarting Sliding Puzzle...");
        Player player = new Player(scanner);
        SlidingPuzzleGame game = new SlidingPuzzleGame(player);
        game.run();
    }

    private void runDotsAndBoxes() {
        System.out.println("\nStarting Dots and Boxes...");
        Player player1 = new Player(scanner);
        Player player2 = new Player(scanner);
        DotsAndBoxesGame game = new DotsAndBoxesGame(player1, player2);
        game.run();
    }
}