public class Main {
    public static void main(String[] args) {
        int number        = 5;
        int anotherNumber = 10;

        // Pass by Value
        anotherNumber = number;
        System.out.println("Numbers, primitives are passed by values");
        System.out.printf("first::number = %d and anotherNumber = %d%n", number, anotherNumber);
        number = 10;
        System.out.printf("second::number = %d and anotherNumber = %d%n", number, anotherNumber);

        // Pass by Reference
        int[] numbers     = {1, 2};
        int[] numbersCopy = numbers;
        System.out.printf(
            "first:: numbers[0] = %d and numbersCopy[0] = %d%n", numbers[0], numbersCopy[0]);
        numbers[0] = 0;
        System.out.printf(
            "first:: numbers[0] = %d and numbersCopy[0] = %d%n", numbers[0], numbersCopy[0]);
        numbersCopy[0] = 1;
        System.out.printf(
            "first:: numbers[0] = %d and numbersCopy[0] = %d%n", numbers[0], numbersCopy[0]);
    }
}
