public class Shaman extends Player {
    private String element;

    public Shaman(int id, String name, int power, String element) {
        super(id, name, power);
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
