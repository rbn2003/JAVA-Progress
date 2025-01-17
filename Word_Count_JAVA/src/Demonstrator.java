public class Demonstrator {
    public static void main(String[] args) {
            String assignmentExampleText = "This is a sentence.";
// You can have your individual TextAnalyzer subclasses analyze text, as in this example:
            WordCountAnalyzer wca = new WordCountAnalyzer(assignmentExampleText);
        wca.analyze();
            System.out.println(wca.report()); // Should print "Word count: 4.0"
// Or this example:
            WordSizeAnalyzer wla = new WordSizeAnalyzer(assignmentExampleText);
            wla.analyze();
            System.out.println(wla.report()); // Should print "Average word length: 4.0"

        // or this example:
        LongestWordSizeAnalyzer lwsa = new LongestWordSizeAnalyzer(assignmentExampleText);
        lwsa.analyze();
        System.out.println(lwsa.report());

        // I did the upper one, as I feel quite easier in understanding those.
        // Thus I kept the lower ones as a comment and introduce myself for the longest word size analyzer.
// Or, you can put together and construct an entire TextAnalysisSystem and have it analyze
// text, as in this example:
//            TextAnalysisSystem tas = new TextAnalysisSystem(assignmentExampleText);
//            tas.setAnalyzers(new TextAnalyzer[]
//                    {new WordCountAnalyzer(tas.getCurrentText()), new WordSizeAnalyzer(tas.getCurrentText()), new LongestWordSizeAnalyzer(tas.getCurrentText())});tas.runAnalysis(); // Should print:
//// Word Count: 4.0
//// Average Word Length: 4.0
//// Longest word length: 9.0
//// Here's another way to do the same as above:
//            tas = new TextAnalysisSystem(assignmentExampleText);
//            tas.setAnalyzers(new TextAnalyzer[]
//                    {new WordCountAnalyzer(), new WordSizeAnalyzer(), new LongestWordSizeAnalyzer()});
//            TextAnalyzer[] analyzers = tas.getAnalyzer();
//            for (int i = 0; i < analyzers.length; i++) {
//                analyzers[i].setText(tas.getCurrentText());
//            }
//            tas.runAnalysis(); // Should print, just as above:
// Word Count: 4.0
// Average Word Length: 4.0
// Longest word length: 9.0
        }
    }


