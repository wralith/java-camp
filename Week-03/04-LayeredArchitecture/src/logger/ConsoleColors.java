package logger;

public class ConsoleColors {
    public static final String RESET = "\033[0m";

    public static final String RED = "\033[0;31m"; // RED
    public static final String BLUE = "\033[0;34m"; // BLUE

    public static String blue(String s) {
        return BLUE.concat(s).concat(RESET);
    }

    public static String red(String s) {
        return RED.concat(s).concat(RESET);
    }
}