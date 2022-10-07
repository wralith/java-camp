import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        Random rand = new Random();

        int randomNumber = rand.nextInt(100);

        // System.out.printf("Cheat: Random number you are looking for is `%s`%n", randomNumber);
        System.out.println("------");
        System.out.println("Guess the number!! Number is between 0 and 100");
        System.out.println("------");
        System.out.println(
            "Hint: If you apply binary search algorithm your change to winning is 100%!!");
        System.out.println("------");
        
        int remainingTries = 10;
        
        while (remainingTries > 0) {
            if (remainingTries == 10) {
                System.out.printf(
                    "You have `%d` changes to guess! Enter a number: ", remainingTries);
                } else {
                    System.out.printf("`%d` changes left! Enter a number: ", remainingTries);
                }
                int guess;
                try {
                    guess = in.nextInt();
                    
                    if (guess > randomNumber) {
                        System.out.println("You Guessed `" + guess + "` guess lower!");
                        System.out.println("------");
                    } else if (guess < randomNumber) {
                        System.out.println("You Guessed `" + guess + "` guess higher!");
                        System.out.println("------");
                } else if (guess == randomNumber) {
                    System.out.println("You Won!! It was " + randomNumber);
                    in.close(); // Closes the reader
                    return; // Exists main function!
                }

                remainingTries--;
            } catch (InputMismatchException e) {
                // If the input cannot converted to integer
                System.out.println("Please enter a valid number next time!");
                in.close();
                return; // Exit
            }
        }

        System.out.println("You Lost!!");
        in.close();
    }
}
