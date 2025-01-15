import java.util.Scanner;

public class Gameplay {
    private String secretWord;  // Secret word set by PlayerA
    private int maxAttempts = 6; // Maximum attempts for PlayerB

    // Constructor that sets the secret word
    public Gameplay(String secretWord) {
        this.secretWord = secretWord;
    }

    // Method to play the game
    public int playGame() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Game Start! PlayerB, it's your turn to guess.");

        // Start a loop where PlayerB gets a chance to guess
        while (attempts < maxAttempts) {
            System.out.print("PlayerB, enter your guess (5 letters): ");
            String guess = scanner.nextLine();

            // Validate the length of the guess
            if (guess.length() != 5) {
                System.out.println("Please enter a 5-letter word.");
                continue;
            }

            attempts++;

            // Check if the guess is correct
            if (guess.equalsIgnoreCase(secretWord)) {
                return attempts; // PlayerB guessed correctly
            } else {
                System.out.println("Incorrect guess. Try again.");
            }
        }
        return -1; // PlayerB failed to guess within the max attempts
    }
}
