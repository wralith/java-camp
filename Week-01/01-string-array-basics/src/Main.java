public class Main {
    public static void main(String[] args) {

        String brandName1 = "Apple";
        String brandName2 = "Lenovo";
        String brandName3 = "Dell";
        String brandName4 = "Acer";

        String[] brandNames = new String[]{brandName1, brandName2, brandName3, brandName4};

        System.out.println("Out of " + brandNames.length + " laptop brands those are the ones that starts with 'A'");
        System.out.println("------");

        for (String name : brandNames) {
            if (name.toLowerCase().startsWith("a")) {
                System.out.println(name);
            }
        }

        System.out.println("");
        System.out.println("Most popular telecommunication brands in Turkey");
        System.out.println("------");

        String[] telBrandNames = {"Avea", "Turkcell", "Vodafone"};
        for (String name : telBrandNames) {
            if (name.toLowerCase().equals("avea")) {
                // Apparently strings are immutable in java so i cannot assign a new value directly
                System.out.println("Turk Telekom");
            } else {
                System.out.println(name);
            }
        }
    }
}