import java.util.ArrayList;

public class RecensieService {
    ArrayList<RecensieProvider> recensies;
    Recensie recensie;
    RecensieService(ArrayList<RecensieProvider> recensies){
        this.recensies = recensies;
    }
    public void getAccountRecensies(Account account){
        for(RecensieProvider recensie: recensies){
            recensie.getBestelling().getRecensie();
        }
    }
    public void plaatseenRecensies(IKleding iKleding){
        System.out.println(iKleding.getNaam());
        recensie.setRecensie("GOOD PRODUCT");
        recensie.setSterren(3);
        }
    }


interface RecensieProvider{
    public Bestelling getBestelling();
}
class Recensie implements RecensieProvider {
    private IKleding kleding;
    private Bestelling account;
    private String recensie;
    private int sterren;

    // Constructor
    public Recensie(IKleding kleding, Bestelling account, String recensie, int sterren) {
        this.kleding = kleding;
        this.account = account;
        this.recensie = recensie;
        this.sterren = sterren;
    }

    // Getters
    public IKleding getKleding() {
        return kleding;
    }

    public Bestelling getBestelling() {
        return account;
    }

    public String getRecensie() {
        return recensie;
    }

    public void setRecensie(String recensie) {
        this.recensie = recensie;
    }

    public int getSterren() {
        return sterren;
    }

    public void setSterren(int sterren) {
        this.sterren = sterren;
    }
}