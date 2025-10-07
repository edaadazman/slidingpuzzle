import java.util.*;

public class DotsAndBoxesGame extends BoardGame {
    private DotsAndBoxesBoard dotsBoard;
    private List<String> players;
    private int currentPlayerIndex;
    private String currentPlayer;

    public DotsAndBoxesGame(Player player) {
        super(player);
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    @Override
    protected Board getBoard() {
        return dotsBoard;
    }

    @Override
    protected void setup() {
        System.out.println("Welcome to Dots and Boxes!");

        // Get board rows
        int rows;
        do {
            String input = player.getInput("Enter number of rows (2-10): ");
            try {
                rows = Integer.parseInt(input);
                if (rows >= 2 && rows <= 10)
                    break;
                System.out.println("Rows must be between 2 and 10.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                rows = 0;
            }
        } while (true);

        // Get board columns
        int cols;
        do {
            String input = player.getInput("Enter number of columns (2-10): ");
            try {
                cols = Integer.parseInt(input);
                if (cols >= 2 && cols <= 10)
                    break;
                System.out.println("Columns must be between 2 and 10.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                cols = 0;
            }
        } while (true);

        // Get player names
        String player1 = player.getInput("Enter name for Player 1: ");
        if (player1.trim().isEmpty()) {
            player1 = "Player 1";
        }

        String player2 = player.getInput("Enter name for Player 2: ");
        if (player2.trim().isEmpty()) {
            player2 = "Player 2";
        }

        players.add(player1);
        players.add(player2);
        currentPlayer = players.get(0);

        // Create board
        dotsBoard = new DotsAndBoxesBoard(rows, cols, players);

        dotsBoard.displayBoard();
    }

    @Override
    protected Integer parseMove(String input) {
        String[] parts = input.split("\\s+");
        if (parts.length != 3) {
            return null;
        }

        try {
            char type = parts[0].toUpperCase().charAt(0);
            if (type != 'H' && type != 'V') {
                return null;
            }

            int row = Integer.parseInt(parts[1]);
            int col = Integer.parseInt(parts[2]);

            // Encode the move as a single integer (type + row*1000 + col)
            // H = 1, V = 2
            int typeCode = (type == 'H') ? 1 : 2;
            return typeCode * 1000000 + row * 1000 + col;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    protected boolean applyMove(int encodedMove) {
        // Decode the move
        int typeCode = encodedMove / 1000000;
        int remainder = encodedMove % 1000000;
        int row = remainder / 1000;
        int col = remainder % 1000;
        char type = (typeCode == 1) ? 'H' : 'V';

        // Get scores before the move
        Map<String, Integer> scoresBefore = dotsBoard.getScores();
        int playerScoreBefore = scoresBefore.get(currentPlayer);

        if (dotsBoard.claimEdge(type, row, col, currentPlayer)) {
            // Check if player scored
            Map<String, Integer> scoresAfter = dotsBoard.getScores();
            int playerScoreAfter = scoresAfter.get(currentPlayer);

            if (playerScoreAfter > playerScoreBefore) {
                int boxesScored = playerScoreAfter - playerScoreBefore;
                System.out.println(currentPlayer + " completed " + boxesScored + " box(es)! Go again!");
                // Don't switch players - same player goes again
            } else {
                // Switch to next player
                switchPlayer();
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean handleSpecialCommand(String command) {
        // No special commands for Dots and Boxes
        return false;
    }

    @Override
    protected String getInstructions() {
        return "Enter moves as: [H/V] [row] [col]\n" +
                "H = Horizontal edge, V = Vertical edge\n" +
                "Example: 'H 0 1' claims horizontal edge at row 0, col 1\n" +
                "Complete boxes to score points! Player with most boxes wins!";
    }

    @Override
    protected String getInputPrompt() {
        return "\n" + currentPlayer + "'s turn - Enter your move (H/V row col) or 'quit': ";
    }

    @Override
    protected String getVictoryMessage() {
        String winner = dotsBoard.getWinner();
        StringBuilder message = new StringBuilder("\nGame Over!\n");

        if (winner != null) {
            message.append("Winner: ").append(winner).append("!\n");
        } else {
            message.append("It's a tie!\n");
        }

        message.append("\nFinal Scores:\n");
        Map<String, Integer> finalScores = dotsBoard.getScores();
        for (String playerName : players) {
            message.append(playerName).append(": ").append(finalScores.get(playerName)).append("\n");
        }

        return message.toString();
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        currentPlayer = players.get(currentPlayerIndex);
    }
}