public abstract class BoardGame {
    protected final Player player;
    protected int moveCount;

    protected BoardGame(Player player) {
        this.player = player;
        this.moveCount = 0;
    }

    protected abstract Board getBoard();

    protected abstract void setup();

    protected abstract Integer parseMove(String token);

    protected abstract boolean applyMove(int tile);

    protected abstract boolean handleSpecialCommand(String command);

    protected String getWelcomeMessage() {
        return "Welcome to the game!";
    }

    protected abstract String getInstructions();

    protected String getInputPrompt() {
        return "Enter your move, 'shuffle', or 'quit': ";
    }

    protected String getInvalidInputMessage() {
        return "Invalid input! Please try again.";
    }

    protected String getInvalidMoveMessage() {
        return "Invalid move! Please try again.";
    }

    protected String getVictoryMessage() {
        return "Congratulations! You won in " + moveCount + " moves!";
    }

    protected String getGoodbyeMessage() {
        return "Thanks for playing! Goodbye!";
    }

    protected String getQuitCommand() {
        return "quit";
    }

    protected String getPlayAgainPrompt() {
        return "Would you like to play again? (yes/no): ";
    }

    public final void run() {
        boolean playAgain = true;

        while (playAgain) {
            System.out.println(getWelcomeMessage());
            setup();
            this.moveCount = 0;
            System.out.println(getInstructions() + "\n");
            System.out.println(getBoard().toString());

            while (!getBoard().isSolved()) {
                String line = player.getInput(getInputPrompt());
                if (line == null) {
                    return;
                }
                if (line.equalsIgnoreCase(getQuitCommand())) {
                    System.out.println(getGoodbyeMessage());
                    return;
                }

                if (handleSpecialCommand(line)) {
                    System.out.println(getBoard().toString());
                    continue;
                }

                Integer tile = parseMove(line);
                if (tile == null) {
                    System.out.println(getInvalidInputMessage());
                    continue;
                }
                boolean moved = applyMove(tile);
                if (moved) {
                    moveCount++;
                } else {
                    System.out.println(getInvalidMoveMessage());
                }
                System.out.println(getBoard().toString());
            }

            if (getBoard().isSolved()) {
                System.out.println(getVictoryMessage());
                String response = player.getInput(getPlayAgainPrompt());
                playAgain = "yes".equals(response);
            } else {
                playAgain = false;
            }
        }

        System.out.println(getGoodbyeMessage());
    }
}
