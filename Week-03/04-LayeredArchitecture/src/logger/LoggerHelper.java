package logger;

public class LoggerHelper {
    public static void logEach(Logger[] loggers, String s) {
        for (Logger logger : loggers) {
            logger.log(s);
        }
    }
}
