import java.util.ArrayList;

public class AccountSessie {
    public int cookie;
    public Mand mand;

    PrijsProcesserKlant prijsProcesserKlant;
    ArrayList<Bestelling> bestellingen;

    AccountSessie(int cookie, PrijsProcesserKlant prijsProcesserKlant){
        this.prijsProcesserKlant = prijsProcesserKlant;
        this.cookie = cookie;
         this.mand = new Mand();
         bestellingen = new ArrayList<>();
    }
    public int getCookie(){
        return cookie;
    }

    public ArrayList<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(Bestelling bestelling) {
      bestellingen.add(bestelling);
    }

    public Mand getMandje() {
        return mand;
    }
}
