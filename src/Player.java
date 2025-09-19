import java.util.Scanner;

public class Player {
    private String name;
    private final Scanner input;

    public Player(Scanner input) {
        this.input = input;
        this.name = "Player"; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        if (!input.hasNextLine()) {
            return null;
        }
        return input.nextLine().trim();
    }
}