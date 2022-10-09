import java.time.LocalDateTime;

class Main {
    public static void main(String[] args) throws InterruptedException {
        ApiLogger apiLogger = new ApiLogger("localhost:8080");
        DatabaseLogger databaseLogger = new DatabaseLogger("postgres");

        apiLogger.info("user data fetched");

        Thread.sleep(1000);
        apiLogger.info("user data fetched");
        Thread.sleep(200);
        apiLogger.info("connection closed");
        Thread.sleep(200);
        databaseLogger.info("product inserted");
        Thread.sleep(200);
        databaseLogger.info("product query successful");
        Thread.sleep(200);
        databaseLogger.fatal("unable to connect");
        Thread.sleep(500);
        apiLogger.fatal("connection interrupted");
        databaseLogger.fatal("terminating in 3");
        Thread.sleep(3000);
    }
}

interface Logger {
    public void info(String message);

    public void error(String message);

    public void fatal(String message);
}

abstract class BaseLogger implements Logger {
    public void error(String message) {
        //
        System.out.println(ConsoleColors.red("ERROR::") + LocalDateTime.now() + "::" + message);
    }

    public void info(String message) {
        System.out.println(ConsoleColors.blue("INFO::") + LocalDateTime.now() + "::" + message);
    }

    public void fatal(String message) {
        System.out.println(ConsoleColors.red("FATAL::") + LocalDateTime.now() + "::" + message);
    }
}

class ApiLogger extends BaseLogger {
    private String url;

    public ApiLogger(String url) {
        this.url = url;
    }

    @Override
    public void fatal(String message) {
        System.out.println(ConsoleColors.red("FATAL::") + url + "::" + LocalDateTime.now() + "::" + message);
    }
}

class DatabaseLogger extends BaseLogger {
    private String databaseName;

    public DatabaseLogger(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public void fatal(String message) {
        System.out.println(ConsoleColors.red("FATAL::") + databaseName + "::" + LocalDateTime.now() + "::" + message);
    }
}

// Colors because why not?
class ConsoleColors {
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