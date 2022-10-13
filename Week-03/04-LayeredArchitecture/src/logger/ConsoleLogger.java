package logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println(ConsoleColors.blue("ConsoleLogger::") + data);
    }

    public static void logErr(String data) {
        System.out.println(ConsoleColors.red("ConsoleLogger::ERR::") + data);
    }
}
