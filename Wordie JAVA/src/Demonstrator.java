import java.util.Scanner;

public class Demonstrator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PlayerA sets the word
        ConsoleColor.print(ConsoleColor.CYAN, "Welcome to the Wordle Game Demonstrator!");
        ConsoleColor.print(ConsoleColor.CYAN, "PlayerA will set a 5-letter word, and PlayerB will guess it.\n");
        System.out.print("PlayerA, please give me a 5-letter word: ");
        String secretWord = scanner.nextLine();

        // Check if the word is exactly 5 letters
        if (secretWord.length() != 5) {
            ConsoleColor.print(ConsoleColor.RED, "The word must be 5 letters long. Exiting the game.");
            return; // Exit if the word is not 5 letters
        }

        // Create a Gameplay instance with the secret word
        Gameplay gameplay = new Gameplay(secretWord);

        // Start the game
        int result = gameplay.playGame();

        // Display the outcome of the game
        if (result != -1) {
            ConsoleColor.print(ConsoleColor.GREEN, "PlayerB guessed the word correctly in " + result + " tries! Congratulations!");
        } else {
            ConsoleColor.print(ConsoleColor.RED, "Better luck next time, PlayerB! The correct word was: " + secretWord);
        }
    }
}
