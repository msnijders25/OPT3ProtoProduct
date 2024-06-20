import java.util.ArrayList;

class DataSeeder {
    private static DataSeeder instance = null;
    public CasualKledingFactory casualFactory = new CasualKledingFactory();
    public FormeelKledingFactory formalFactory = new FormeelKledingFactory();
    public LuxuryKledingFactory luxuryFactory = new LuxuryKledingFactory();

    public ArrayList<IKleding> alleKleding = new ArrayList<>();
    public ArrayList<IKleding> hoodies = new ArrayList<>();
    public ArrayList<IKleding> broeken = new ArrayList<>();
    public final ArrayList<IKleding> shirts = new ArrayList<>();
    public  ArrayList<Bestelling> bestellings = new ArrayList<>();

    public static DataSeeder getInstance() {
        if (instance == null) {
            instance = new DataSeeder();

        }

        return instance;
    }
    public static DataSeeder getInstance(KledingFactory casualFactory, KledingFactory formalFactory,
                                         LuxuryKledingFactory luxuryFactory) {
        if (instance == null) {
            instance = new DataSeeder();
        }
        return instance;
    }

    public void seedData() {

        shirts.add(casualFactory.createTshirt(20.0, "Casual Tee", 5, 1));
        broeken.add(casualFactory.createBroek(40.0, "Casual Pants", 3, 2));
        hoodies.add(casualFactory.createHoodie(60.0, "Casual Hoodie", 2, 3));

        shirts.add(formalFactory.createTshirt(35.0, "Dress Shirt", 2, 4));
        broeken.add(formalFactory.createBroek(70.0, "Suit Pants", 3, 5));

        shirts.add(luxuryFactory.createTshirt(80.0, "Silk Shirt", 1, 6));
        hoodies.add(luxuryFactory.createHoodie(120.0, "Cashmere Hoodie", 2, 7));

        alleKleding.addAll(shirts);
        alleKleding.addAll(hoodies);
        alleKleding.addAll(broeken);

    }

    public void voegKledingToe(IKleding kleding) {
        String type = kleding.getType();
        this.alleKleding.add(kleding);

        switch (type) {
            case "Hoodie":
                this.getHoodies().add(kleding);
                break;
            case "Tshirt":
                this.getShirts().add(kleding);
                break;
            case "Broek":
                this.getBroeken().add(kleding);
                break;
            default:
                throw new IllegalArgumentException("Ongeldig kledingtype: " + type);
        }
    }

    public ArrayList<IKleding> getHoodies() {
        return hoodies;
    }

    public ArrayList<IKleding> getShirts() {
        return shirts;
    }

    public ArrayList<Bestelling> getBestellings() {
        return bestellings;
    }

    public ArrayList<IKleding> getBroeken() {
        return broeken;
    }

    public ArrayList<IKleding>  getAlleKleding() {
        return alleKleding;
    }
}