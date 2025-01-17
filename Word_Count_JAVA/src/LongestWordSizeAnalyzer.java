
public class LongestWordSizeAnalyzer extends TextAnalyzer{

//    private String text;

    public LongestWordSizeAnalyzer(){
        reportPrefix = "Longest word size: ";
    }

    public LongestWordSizeAnalyzer(String t) {
        this();
        setText(t);
    }

    @Override
    public void analyze() {
        String text = getText(); // getting the text from the parent class
        if (text == null || text.isEmpty()) {
            results = 0; // Handle edge cases where text is empty or null
            return;
        }

        String[] words = text.split(" "); //spliting the words

        int maxLength = 0;
        for (String word : words) {
            String cleanedWord = word.replaceAll("[^a-zA-Z.]", "");
            if (cleanedWord.length() > maxLength) {
                maxLength = cleanedWord.length();
            }

        }

        results = maxLength; // Set the result to the length of the longest word
    }
 }

