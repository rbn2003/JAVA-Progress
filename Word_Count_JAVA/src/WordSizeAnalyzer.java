public class WordSizeAnalyzer extends TextAnalyzer {

    private String text;
    private double averageWordSize;

    public WordSizeAnalyzer() { // no arg constructor
        super();
        this.reportPrefix = "Average Word Size: "; //setting reportPrefix to Word Count
    }

    public WordSizeAnalyzer(String t) {
        super(t);
        this.text = t;
    }

    public void analyze() {
        if (getText() != null && !getText().isEmpty()) {
            //split the text into words babsed on any whitespace
            String[] words = getText().split("\\s+");

            //initialize variables to sum up the total number of characters and the numbers
            int totalCharacters = 0;
            int wordCount = 0;

            for (String word : words) {
                // ignore empty words if appear due to many spaces
                if (!word.isEmpty()) {
                    totalCharacters += word.length();
                    wordCount++;
                }
            }

            // compute the average word size
            if (wordCount > 0) {
                results = (double) totalCharacters / wordCount;
            } else {
                results = 0.0;
            }


        } else {
            results = 0.0;
        }
    }

    public String report() {
        return "Average word size: " + results;
    }
}



