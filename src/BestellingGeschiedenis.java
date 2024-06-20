import java.util.ArrayList;

public class BestellingGeschiedenis {
    ArrayList<Bestelling> bestellingen = new ArrayList<>();

    public void addBestelling(Bestelling bestelling){
        bestellingen.add(bestelling);
    }

    public ArrayList<Bestelling> getBestellingen() {
        return bestellingen;
    }
}

