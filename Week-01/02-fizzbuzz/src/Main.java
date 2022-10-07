public class Main {
    public static void main(String[] args) {
        // Soooo, lets make good old Fizz Buzz...

        for (int i = 0; i < 50; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        // QUESTION: Does switch compile same as `if, else` does? Which one for performance?
    }
}
