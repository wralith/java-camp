import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Scanner in = new Scanner(System.in);
    private final Random rand = new Random();
    private final int randomNumber = rand.nextInt(100);
    private int remainingTries = 10;
    private boolean isWon = false;

    public void play() {
        while (remainingTries > 0) {
            if (remainingTries == 10) {
                System.out.printf(
                        "You have `%d` changes to guess! Enter a number: ", remainingTries);
            } else if (isWon) {
                break;
            } else {
                System.out.printf("`%d` changes left! Enter a number: ", remainingTries);
            }

            int guess;
            try {
                guess = in.nextInt();
                tries(guess, randomNumber);
                remainingTries--;
            } catch (InputMismatchException e) {
                // If the input cannot convert to integer, punishes the player! 😈
                System.out.println("Please enter a valid number next time!");
                in.close();
                return; // Exit
            }
        }

        if (isWon) {
            System.out.println("You Won!! It was " + randomNumber);
        } else {
            System.out.println("You Lost!!");
        }
        in.close();
    }

    private void tries(int guess, int randomNumber) {
        if (guess > randomNumber) {
            System.out.println("You Guessed `" + guess + "` guess lower!");
            System.out.println("------");
        } else if (guess < randomNumber) {
            System.out.println("You Guessed `" + guess + "` guess higher!");
            System.out.println("------");
        } else {
            this.isWon = true;
        }
    }
}
