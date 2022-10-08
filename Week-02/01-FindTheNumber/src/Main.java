public class Main {
    public static void main(String[] args) {
        head();

        // CoreGame does everything beside printing head and Bye!!
        Game game = new Game();
        game.play();

        System.out.println("Bye!");
    }

    public static void head() {
        // System.out.printf("Cheat: Random number you are looking for is `%s`%n", randomNumber);
        System.out.println("------");
        System.out.println("Guess the number!! Number is between 0 and 100");
        System.out.println("------");
        System.out.println("Hint: If you apply binary search algorithm your change to winning is 100%!!");
        System.out.println("------");
    }
}
