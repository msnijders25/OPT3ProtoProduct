import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Mand{
    ArrayList<IKleding> iKleding = new ArrayList<>();



    public Mand() {

    }
    public void voegKledingToe(IKleding gekozenKleding) {
        iKleding.add(gekozenKleding);
    }

     public void setKleding(ArrayList<IKleding> iKleding){
        this.iKleding = iKleding;}
    protected ArrayList<IKleding> getiKleding(){
        return iKleding;
    }

    }

class MandService implements IActie{
    private String actie;
    private AccountSessie cookie;
    private IKleding item;
    private Scanner scanner;
    public MandService(String actie, AccountSessie cookie, IKleding item) {
        this.actie = actie;
        this.cookie = cookie;
        this.item = item;
    }


    public MandService(String actie, AccountSessie cookie, Scanner scanner) {
        this.actie = actie;
        this.cookie = cookie;
        this.scanner = scanner;
    }



    public void VerwijderItemUitMand(AccountSessie cookie, IKleding item) {
        ActieKledingVerwijderKledingUitMandje actie = new ActieKledingVerwijderKledingUitMandje(cookie, item);
        actie.voerUit();
    }

    public void VeranderItemHoeveelHeid(IKleding kleding, AccountSessie cookie) {
        ActieVeranderHoeveelheid actie = new ActieVeranderHoeveelheid(kleding, cookie);
        actie.voerUit();
    }

    public void zieMandje(AccountSessie cookie, Scanner scanner) {
        ActieZieMandje actie = new ActieZieMandje(cookie);
        actie.voerUit();
    }

    @Override
    public void voerUit() {
        if (actie.equals("verwijder")) {
            VerwijderItemUitMand(cookie, item);
        } else if (actie.equals("verander_hoeveelheid")) {
            VeranderItemHoeveelHeid(item, cookie);
        } else if (actie.equals("zie_mandje")) {
            zieMandje(cookie, scanner);
        } else {
            System.out.println("Ongeldige actie.");
        }
    }
}

