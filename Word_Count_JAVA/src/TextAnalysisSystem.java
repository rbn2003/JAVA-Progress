public class TextAnalysisSystem {

    private TextAnalyzer [] analyzers;
    private String currentText;

    public TextAnalysisSystem(String ct) {
        if (ct == null) {
            throw new IllegalArgumentException("ct cannot be null");
        }
        this.currentText = ct;

    }

    public TextAnalyzer getCurrentTextAnalyzer() {
        return this.analyzers[this.currentText.length()];
    }

    public String getCurrentText() {
        return this.currentText;
    }

    public void setCurrentText(String ct) {
        this.currentText = ct;
    }

    public void setAnalyzers(TextAnalyzer[] ta) {
        this.analyzers = ta;
    }

    public void runAnalysis() {

        if (analyzers == null) {
            throw new IllegalStateException("Analyzers have not been set.");
        }

        for (TextAnalyzer ta : this.analyzers) {
            ta.analyze();
            System.out.println(ta.report());
        }
    }

    public TextAnalyzer[] getAnalyzer() {
         return getAnalyzer();
    }

    public Object[] getAnalyzers() {
        return null;
    }
}
