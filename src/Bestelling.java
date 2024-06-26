import java.util.ArrayList;

public class Bestelling {
    public int id = 1;
    ArrayList<IKleding> iKleding;
    Recensie recensie;

    public static int volgendeId = 1;
    Bestelling(ArrayList<IKleding> iKleding){
        this.iKleding = iKleding;
        this.id = volgendeId++;

    }

    public ArrayList<IKleding> getiKleding() {
        return iKleding;
    }

    public void setRecensie(Recensie recensie) {
        this.recensie = recensie;
    }

    public Recensie getRecensie() {
        return recensie;
    }

    public void setiKleding(ArrayList<IKleding> iKleding) {
        this.iKleding = iKleding;
    }
}
class BestellingService {
    public void plaatsBestelling(AccountSessie account) {
        ActiePlaatsBestelling actie = new ActiePlaatsBestelling(account);
        actie.voerUit();
    }

    public void zieBestelling(AccountSessie cookie) {
        ActieZieBestelling actie = new ActieZieBestelling(cookie);
        actie.voerUit();
    }
}