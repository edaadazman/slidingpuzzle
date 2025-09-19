import java.util.*;

public class SlidingPuzzleGame extends BoardGame {
    private SlidingPuzzleBoard board;

    public SlidingPuzzleGame(Scanner in) {
        super(new Player(in));
    }

    @Override
    protected Board getBoard() {
        return board;
    }

    @Override
    protected String getWelcomeMessage() {
        return "Welcome to the Sliding Puzzle Game! Arrange the numbeed tiles such that tiles are ordered from least to greatest from top left to bottom right.";
    }

    @Override
    protected String getInstructions() {
        return "Enter the number of the tile you want to move. Type 'shuffle' to reshuffle the board. Enter 'quit' to exit.";
    }

    @Override
    protected void setup() {
        String nameIn = player.getInput("Enter your name: ");
        if (!nameIn.isEmpty()) {
            player.setName(nameIn);
        }

        int r = getValidSize("Enter number of rows (2-10): ");
        int c = getValidSize("Enter number of cols (2-10): ");

        this.board = new SlidingPuzzleBoard(r, c);
        System.out.println("Good luck, " + player.getName() + "!");
    }

    private int getValidSize(String prompt) {
        while (true) {
            String input = player.getInput(prompt);
            if (input == null) {
                return 3;
            }
            try {
                int value = Integer.parseInt(input);
                if (value >= 2 && value <= 10) {
                    return value;
                }
                System.out.println("Please enter an integer between 2 and 10.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    @Override
    protected Integer parseMove(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    protected boolean applyMove(int tile) {
        return board.trySlideTile(tile);
    }

    @Override
    protected boolean handleSpecialCommand(String command) {
        if (command.equalsIgnoreCase("shuffle")) {
            board.shuffle();
            System.out.println("Board shuffled.");
            return true;
        }
        return false;
    }

}
