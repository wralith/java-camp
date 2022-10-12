# Single Responsibility

Each unit -class in this context- should be responsible for only one job.

```java
// Creates stuff
Patient patient = new Patient("name", "problem");
// Does stuff
PatientManager patientManager = new PatientManager(patient);
// Contains methods that does different things? Yes, since they manage patient
```

# Interfaces, Abstract Classes... Abstraction!

## Interface

Have methods with empty bodies that can be implemented in different classes.

```java
interface Logger {
    public void info(String message);
    public void error(String message);
    public void fatal(String message);
}
```

## Abstract Class

Class that implements the Interfaces methods as base for other classes that implements this abstract class -in our context-.

Let's create a BaseLogger class.

```java
abstract class BaseLogger implements Logger {
    public void info(String message) {
        System.out.println("INFO::" + LocalDateTime.now() + "::" + message);
    }
    // ...
    // ...
}
```

BaseLogger is an abstract class implements Logger interface, it simply prints the `Prefix` -log level-, `Time` and the `Log Message`. Now we can extend `BaseLogger` and the class will inherit its methods.

```java
class DatabaseLogger extends BaseLogger {
    private String databaseName;

    // Constructor
    public DatabaseLogger(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    // Overrides the method implemented in BaseLogger with new
    public void fatal(String message) {
        System.out.println("FATAL::" + databaseName + "::" + LocalDateTime.now() + "::" + message);
    }
}
```

Now we can achieve all the methods of `BaseLogger` with the `DatabaseLogger` as well. `info` and `error` did not changed and we can call them as a `DatabaseLogger`'s method. However, we defined new `fatal` method which does different job than it was in the `BaseLogger`, simply it inserts `databaseName` to the print.

# Static Methods

You are able to call static methods without instantiating the class with the `new` keyword. In sum it can be called regardless of any instance of its class exists.

Lets create ConsoleColors class which have static method `red(string)`

```java
class ConsoleColors {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m"; // RED

    // string -> red ansi code + string + reset ansi code -> `string` but red in console
    public static String red(String s) {
        return RED.concat(s).concat(RESET);
    }
}
```

Now we can call `red()` method without instantiating the `ConsoleColors` class in another class.

```java
public void warn(String message) {
        String output = ConsoleColors.red("WARN::") + message
        System.out.println(output);
    }
```

## Static means static! 📎

Additionally inside the static method we are unable to access non-static methods or data. Because it is `STATIC` and needs its elements to be `static` as well unless it would not be `static` 🤯.

```java
public class CredentialValidator {
    // static isValid method uses checkLength method
    public static boolean isValid(LoginCredentials credentials) {
        if (!checkLength(credentials.getUsername())) {
            return false;
        }

        return true;
    }

    // has to be static if we want to use it inside other static method
    private static boolean checkLength(String s) {
        if (s.length() < 5) {
            return false;
        }
        return true;
    }
}
```
