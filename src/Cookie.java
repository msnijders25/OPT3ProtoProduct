import java.util.ArrayList;

public class Cookie {
    public int cookie;
    public Mand mand;
    ArrayList<Bestelling> bestellingen = new ArrayList<>();

    Cookie(int cookie){
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
