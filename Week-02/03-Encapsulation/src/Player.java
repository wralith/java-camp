public class Player {
    private int id;
    private String name;
    private int power;

    public Player(int id, String name, int power) {
        this.id    = id;
        this.name  = name;
        this.power = power;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Compare power of the Player and given Player in parameters.
     * Returns name of the winner, name of the opponent if powers are equal
     * @param opponent
     * @return name
     */
    public String fight(Player opponent) {
        if (this.power > opponent.power) {
            return this.name;
        }

        return opponent.getName();
    }
}
