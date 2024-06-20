import java.util.ArrayList;
import java.util.Scanner;

abstract class Menu {
    protected ArrayList<Menukeuze> opties;
    protected String naam;

    public Menu(String naam) {
        this.naam = naam;
        this.opties = new ArrayList<>();
    }

    protected abstract void initializeMenuOpties();

    public void voegOptieToe(Menukeuze optie) {
        this.opties.add(optie);
    }

    public void toonMenu() {
        initializeMenuOpties();
        for (Menukeuze optie : opties) {
            System.out.println(optie.getIndex() + ". " + optie.getTekst());
        }
    }

    public void handleMenu(Scanner scanner) {
        while (true) {
            toonMenu();
            System.out.print("Voer uw keuze in: ");
            try {
                int keuze = Integer.parseInt(scanner.nextLine());
                kiesOptie(keuze);
                if (isTerugOptie(keuze)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer a.u.b. een getal in.");
            }
        }
    }

    private boolean isTerugOptie(int index) {
        for (Menukeuze optie : opties) {
            if (optie.getIndex() == index && optie.isTerug()) {
                return true;
            }
        }
        return false;
    }

    public void kiesOptie(int index) {
        for (Menukeuze optie : opties) {
            if (optie.getIndex() == index) {
                if (optie.getActie() != null) {
                    optie.getActie().voerUit();
                }
                break;
            }
        }
    }
}
class KiesAccount extends Menu {
    Cookie cookie;
    public KiesAccount(String naam, Cookie cookie) {
        super("LOGIN");
        this.cookie = cookie;
    }

    @Override
    protected void initializeMenuOpties() {
        this.opties.clear();

        voegOptieToe(new Menukeuze(1, "Admin", new ActieOpenAdminMenu()));
        voegOptieToe(new Menukeuze(2, "Klant",new ActieOpenKlantMenu(cookie)));

    }


}
interface VoorraadSubject {
    void addObserver(VoorraadObserver observer);
    void removeObserver(VoorraadObserver observer);
    void notifyObservers();
}
class MandjeMenu extends Menu implements VoorraadObserver {
    private Cookie account;

    public MandjeMenu(Cookie account) {
        super("Mandje Menu");
        this.account = account;
        System.out.println("Mandje geinitialiseerd: " + account);
        System.out.println("Account: " + account.getMandje());
    }

    @Override
    protected void initializeMenuOpties() {

        this.opties.clear();

        if (account.getMandje() == null) {
            System.out.println("Het mandje is leeg.");
            return;
        }

        int i = 1;
        for (IKleding kleding : account.getMandje().getiKleding()) {
            voegOptieToe(new Menukeuze(i++, "Verwijder " + kleding.getNaam() + " uit mandje", new ActieKledingVerwijderKledingUitMandje(account, kleding)));
            voegOptieToe(new Menukeuze(i++, "Verander hoeveelheid van " + kleding.getNaam(),new ActieVeranderHoeveelheid(kleding, account)));
            voegOptieToe(new Menukeuze(i++, "Bekijk details van " + kleding.getNaam(), false));
        }

        voegOptieToe(new Menukeuze(i++, "Plaats bestelling", new ActiePlaatsBestelling(account)));
        voegOptieToe(new Menukeuze(i, "Terug", true));
        update();
    }

    @Override
    public void update() {
        for(IKleding kleding: account.getMandje().getiKleding()){
            if(kleding.getVoorraad() <= 5){
        System.out.println("LET OP VOORRAAD LAAG: " + kleding.getNaam());}}
    }
}
interface VoorraadObserver{
    void update();
}
class KlantAccountMenu extends Menu {
    private Cookie cookie;

    public KlantAccountMenu(String naam, Cookie account) {
        super(naam);
         cookie = account;
        System.out.println("KlantAccountMenu geinitialiseerd met account: " + account);
    }

    @Override
    protected void initializeMenuOpties() {
        this.opties.clear();

        voegOptieToe(new Menukeuze(1, "Zie Assortiment",new ActieZieAssortiment(cookie)));
        voegOptieToe(new Menukeuze(2, "Open Mandje",new ActieZieMandje(cookie)));
        voegOptieToe(new Menukeuze(3, "Zie Bestellingen",new ActieZieBestelling(cookie)));
        voegOptieToe(new Menukeuze(4, "Verander Koers", new ActieVeranderKoerss()));
        voegOptieToe(new Menukeuze(5, "Verander Taal", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
    }
}

class KlantAdminMenu extends Menu {
    public KlantAdminMenu(String naam) {
        super(naam);
    }

    @Override
    protected void initializeMenuOpties() {
        voegOptieToe(new Menukeuze(1, "Zie Assortiment", false));
        voegOptieToe(new Menukeuze(2, "Voeg een Sale toe", false));
        voegOptieToe(new Menukeuze(3, "Voeg een kleding toe", false));
        voegOptieToe(new Menukeuze(5, "BewerkPrijs", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
    }
}

class KlantAdminMenuBewerk extends Menu {
    public KlantAdminMenuBewerk(String naam) {
        super(naam);
    }

    @Override
    protected void initializeMenuOpties() {
    }

    protected void initializeMenuOptiesBewerk(IKleding kleding) {
        this.opties.clear();
        voegOptieToe(new Menukeuze(1, "BewerkPrijs", false));
        voegOptieToe(new Menukeuze(2, "BewerkVoorraad",false));
        voegOptieToe(new Menukeuze(3, "BewerkVoorraad", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
        handleMenu(new Scanner(System.in));
    }
}