import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class Lab10Tests {

    @Nested
    class TextAnalyzerTest {
        @Test
        @DisplayName("TextAnalyzer: No-arg constructor creates uninitialized object")
        public void testNoArgConstructor() {
            TextAnalyzer analyzer = new WordCountAnalyzer();
            assertNull(analyzer.getText());
            assertEquals(-1.0, analyzer.getResults());
        }

        @Test
        @DisplayName("TextAnalyzer: Parameterized constructor sets text correctly")
        public void testParameterizedConstructor() {
            String testText = "This is a test sentence";
            TextAnalyzer analyzer = new WordCountAnalyzer(testText);
            assertEquals(testText, analyzer.getText());
        }

        @Test
        @DisplayName("TextAnalyzer: Null text throws IllegalArgumentException")
        public void testNullTextThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> {
                new WordCountAnalyzer(null);
            });
            
            TextAnalyzer analyzer = new WordCountAnalyzer("Initial text");
            assertThrows(IllegalArgumentException.class, () -> {
                analyzer.setText(null);
            });
        }
    }

    @Nested
    class WordCountAnalyzerTest {
        private WordCountAnalyzer analyzer;

        @BeforeEach
        public void setUp() {
            analyzer = new WordCountAnalyzer();
        }

        @Test
        @DisplayName("WordCountAnalyzer: Count words in basic sentence")
        public void testBasicSentenceWordCount() {
            analyzer.setText("This is a sentence");
            analyzer.analyze();
            assertEquals(4.0, analyzer.getResults());
        }

        @Test
        @DisplayName("WordCountAnalyzer: Count words in sentence with multiple separators")
        public void testMultipleSeparatorsWordCount() {
            analyzer.setText("  This   is\ta\nsentence  ");
            analyzer.analyze();
            assertEquals(4.0, analyzer.getResults());
        }

        @Test
        @DisplayName("WordCountAnalyzer: Count words in sentence with punctuation")
        public void testPunctuationWordCount() {
            analyzer.setText("This: is a sentence!");
            analyzer.analyze();
            assertEquals(4.0, analyzer.getResults());
        }

        @Test
        @DisplayName("WordCountAnalyzer: Count words in sentence with non-letter characters")
        public void testNonLetterCharactersWordCount() {
            analyzer.setText("% ! & word***");
            analyzer.analyze();
            assertEquals(4.0, analyzer.getResults());
        }

        @Test
        @DisplayName("WordCountAnalyzer: Report format")
        public void testReportFormat() {
            analyzer.setText("This is a sentence");
            analyzer.analyze();
            assertEquals("Word Count: 4.0", analyzer.report());
        }
    }

    @Nested
    class WordSizeAnalyzerTest {
        private WordSizeAnalyzer analyzer;

        @BeforeEach
        public void setUp() {
            analyzer = new WordSizeAnalyzer();
        }

        @Test
        @DisplayName("WordSizeAnalyzer: Calculate average word size")
        public void testAverageWordSize() {
            analyzer.setText("Here is a sentence.");
            analyzer.analyze();
            assertEquals(4.0, analyzer.getResults());
        }

        @Test
        @DisplayName("WordSizeAnalyzer: Calculate average word size with punctuation")
        public void testAverageWordSizeWithPunctuation() {
            analyzer.setText("This is a sentence. This is another sentence.");
            analyzer.analyze();
            assertEquals(4.75, analyzer.getResults());
        }

        @Test
        @DisplayName("WordSizeAnalyzer: Calculate average word size with non-letter characters")
        public void testAverageWordSizeWithNonLetterChars() {
            analyzer.setText("% ! word***");
            analyzer.analyze();
            assertEquals(3.0, analyzer.getResults());
        }

        @Test
        @DisplayName("WordSizeAnalyzer: Report format")
        public void testReportFormat() {
            analyzer.setText("Here is a sentence.");
            analyzer.analyze();
            assertEquals("Average word size: 4.0", analyzer.report());
        }
    }

    @Nested
    class LongestWordSizeAnalyzerTest {
        private LongestWordSizeAnalyzer analyzer;

        @BeforeEach
        public void setUp() {
            analyzer = new LongestWordSizeAnalyzer();
        }

        @Test
        @DisplayName("LongestWordSizeAnalyzer: Find longest word size")
        public void testLongestWordSize() {
            analyzer.setText("Here is a sentence.");
            analyzer.analyze();
            assertEquals(9.0, analyzer.getResults());
        }

        @Test
        @DisplayName("LongestWordSizeAnalyzer: Find longest word size with non-letter characters")
        public void testLongestWordSizeWithNonLetterChars() {
            analyzer.setText("% && *** $$");
            analyzer.analyze();
            assertEquals(3.0, analyzer.getResults());
        }

        @Test
        @DisplayName("LongestWordSizeAnalyzer: Report format")
        public void testReportFormat() {
            analyzer.setText("Here is a sentence.");
            analyzer.analyze();
            assertEquals("Longest word size: 9.0", analyzer.report());
        }
    }

    @Nested
    class TextAnalysisSystemTest {
        private TextAnalysisSystem system;
        private String testText;

        @BeforeEach
        public void setUp() {
            testText = "This is a sentence";
            system = new TextAnalysisSystem(testText);
        }

        @Test
        @DisplayName("TextAnalysisSystem: Constructor sets text correctly")
        public void testConstructor() {
            assertEquals(testText, system.getCurrentText());
        }

        @Test
        @DisplayName("TextAnalysisSystem: Null text throws exception")
        public void testNullTextThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> {
                new TextAnalysisSystem(null);
            });
        }

        @Test
        @DisplayName("TextAnalysisSystem: Set and get analyzers")
        public void testSetAndGetAnalyzers() {
            TextAnalyzer[] analyzers = new TextAnalyzer[] {
                new WordCountAnalyzer(testText),
                new WordSizeAnalyzer(testText),
                new LongestWordSizeAnalyzer(testText)
            };
            system.setAnalyzers(analyzers);
            
            assertArrayEquals(analyzers, system.getAnalyzers());
        }

        @Test
        @DisplayName("TextAnalysisSystem: Run analysis")
        public void testRunAnalysis() {
            // This test checks if runAnalysis() can be called without exceptions
            TextAnalyzer[] analyzers = new TextAnalyzer[] {
                new WordCountAnalyzer(testText),
                new WordSizeAnalyzer(testText),
                new LongestWordSizeAnalyzer(testText)
            };
            system.setAnalyzers(analyzers);
            
            assertDoesNotThrow(() -> system.runAnalysis());
        }
    }
}
