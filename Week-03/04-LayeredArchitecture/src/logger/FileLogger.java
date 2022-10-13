package logger;

public class FileLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println(ConsoleColors.blue("FileLogger::") + data);
    }
}
