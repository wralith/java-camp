package logger;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println(ConsoleColors.blue("DatabaseLogger::") + data);
    }
}
