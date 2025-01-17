public abstract class TextAnalyzer {

    private String text;
    protected double results = -1.0; //protected variables
    protected String reportPrefix;

    //constructor with no arguments
    public TextAnalyzer() {
    }

    public TextAnalyzer(String t) {
        if (t == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        this.text = t;
    }

    public String getText(){
        return text;
    }

    public double getResults(){
        return results;
    }

    public void setText(String t){
        if (t == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        this.text = t;
    }

    public abstract void analyze();

    public String report(){
        return reportPrefix + results;
    }
}