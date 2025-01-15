public class ConsoleColor {
    // Color codes for console text
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    // Method to print colored text
    public static void print(String color, String message) {
        System.out.println(color + message + RESET);
    }
}
