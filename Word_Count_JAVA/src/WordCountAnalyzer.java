public class WordCountAnalyzer extends TextAnalyzer {

    public WordCountAnalyzer() { // no arg constructor
        super();
        this.reportPrefix = "Word Count: "; //setting reportPrefix to Word Count
    }

    public WordCountAnalyzer(String t) {
        super(t);
        this.reportPrefix = "Word Count: "; //set the reportPrefix to WordCount
    }

    //Implementation of analyze method
    public void analyze() {
        if (getText() != null && !getText().isEmpty()){
            // split the text by the characters (spaces, tabs, and newlines)
            String[] words = getText().split("\\s+");

            //count the number of words and set them to the results
            results = (double) words.length;
        } else {
            // if the text is null or empty, the reusult is 0.0
            results = 0.0;
        }
    }

    public String report() {
        return "Word Count: " + results;
    }
}
