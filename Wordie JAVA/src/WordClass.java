public class WordClass {

    // Private instance variables
    private int wordLength = 5;
    private String wordValue;

    // Constructors
    public WordClass() {
        this.wordValue = ""; // Initialize to an empty string
    }

    public WordClass(String wordValue) {
        this.wordValue = wordValue;
    }

    // Instance methods
    public String getWordValue() {
        return this.wordValue;
    }

    public void setWordValue(String a) {
        this.wordValue = a;
    }

    public String makeYellow(String letter) {
        // Change the background color of the text to yellow and return it
        return "\u001B[43m" + letter + "\u001B[0m"; // Yellow background
    }

    public String makeGreen(String letter) {
        // Change the background color of the text to green and return it
        return "\u001B[42m" + letter + "\u001B[0m"; // Green background
    }

    public String CheckLetters(String guess) {
        StringBuilder result = new StringBuilder();

        // Loop through each letter of the word
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);

            // Check bounds to avoid errors if `wordValue` is shorter
            if (i >= wordValue.length()) {
                result.append(guessChar); // Append without formatting
                continue;
            }

            char wordChar = wordValue.charAt(i);

            if (guessChar == wordChar) {
                // If letter of the word guessed is correct, make it green
                result.append(makeGreen(String.valueOf(guessChar)));
            } else if (wordValue.contains(String.valueOf(guessChar))) {
                // If the letter exists in the word but at a different position, make it yellow
                result.append(makeYellow(String.valueOf(guessChar)));
            } else {
                // Otherwise, leave it unchanged
                result.append(String.valueOf(guessChar));
            }
        }

        return result.toString();
    }
}
