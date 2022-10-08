class Main {
    public static void main(String[] args) {
        // Constructor creates a new Player with given parameters
        Player player1 = new Player(1, "Wra", 75);
        Player player2 = new Player(2, "Judy", 50);

        System.out.println("Player1::" + player1.getName());
        System.out.println("Player2::" + player2.getName());

        // Data inside the Player class cannot be reached or changed directly
        // Instead setter and getters used which encapsuled variables
        // Is that really an useful feature or remnant of the past? Who knows...

        // player1.name = "NotWra" // Wont work
        player1.setName("NotWra"); // Will do the job!
        System.out.println("Player1::" + player1.getName());

        Shaman player3 = new Shaman(3, "Thrall", 100, "Earth");
        System.out.println("Shaman::" + player3.getName());

        System.out.println("-----");

        // Fighters array contains FIGHTERS!!
        Player[] fighters = {player2, player3};

        System.out.printf("%s vs %s%n", fighters[0].getName(), fighters[1].getName());
        // Calls the fight method of first fighter and take second fighter as parameter
        String winner = fighters[0].fight(fighters[1]);

        System.out.printf("Winner is %s%n", winner);
    }
}