import java.util.ArrayList;
import java.util.Scanner;

abstract class Menu {
    protected ArrayList<Menukeuze> opties;
    protected String naam;
    Scanner scanner = new Scanner(System.in);

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
    AccountSessie accountSessie;
    public KiesAccount(String naam, AccountSessie accountSessie) {
        super("LOGIN");
        this.accountSessie = accountSessie;
    }

    @Override
    protected void initializeMenuOpties() {
        this.opties.clear();

        voegOptieToe(new Menukeuze(1, "Admin", new ActieOpenAdminMenu()));
        voegOptieToe(new Menukeuze(2, "Klant",new ActieOpenKlantMenu(accountSessie)));

    }


}
interface VoorraadSubject {
    void addObserver(VoorraadObserver observer);
    void removeObserver(VoorraadObserver observer);
    void notifyObservers();
}
class MandjeMenu extends Menu implements VoorraadObserver {
    private AccountSessie account;

    public MandjeMenu(AccountSessie account) {
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
            voegOptieToe(new Menukeuze(i++, "Verwijder " + kleding.getNaam() + " uit mandje", new MandService("verwijder", account, kleding)));
            voegOptieToe(new Menukeuze(i++, "Verander hoeveelheid van " + kleding.getNaam(), new MandService("verander_hoeveelheid", account, kleding)));
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
    private AccountSessie accountSessie;


    public KlantAccountMenu(String naam, AccountSessie account) {
        super(naam);
         accountSessie = account;
        System.out.println("KlantAccountMenu geinitialiseerd met account: " + account);
    }

    @Override
    protected void initializeMenuOpties() {
        this.opties.clear();

        voegOptieToe(new Menukeuze(1, "Zie Assortiment",new ActieZieAssortiment(accountSessie)));
        voegOptieToe(new Menukeuze(2, "Open Mandje", (IActie) new MandService("zie_mandje", accountSessie, scanner)));
        voegOptieToe(new Menukeuze(3, "Zie Bestellingen",new ActieZieBestelling(accountSessie)));
        voegOptieToe(new Menukeuze(4, "Verander Koers", new ActieVeranderKoerss(accountSessie)));
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
        voegOptieToe(new Menukeuze(1, "Zie Assortiment", new ActieOpenKlantBewerkSub()));
        voegOptieToe(new Menukeuze(2, "Voeg een Sale toe", new ActieSaleSubMenu()));
        voegOptieToe(new Menukeuze(3, "Voeg een kledingstuk toe", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
    }
}

class ActieOpenKlantBewerkSub implements  IActie{


    @Override
    public void voerUit() {
        Scanner scanner = new Scanner(System.in);
        KlantAdminMenuBewerk klant = new KlantAdminMenuBewerk("");
        klant.handleMenu(scanner);
    }
}
class KlantAdminMenuBewerk extends Menu {
    public KlantAdminMenuBewerk(String naam) {
        super(naam);
    }


    protected void initializeMenuOpties() {
        this.opties.clear();
        voegOptieToe(new Menukeuze(1, "BewerkPrijs", new ActieBewerkDataKleding()));
        voegOptieToe(new Menukeuze(2, "BewerkVoorraad",false));
        voegOptieToe(new Menukeuze(3, "BewerkVoorraad", false));
        voegOptieToe(new Menukeuze(9, "Terug", true));
    }
}
class ActieBewerkDataKleding implements  IActie{
    @Override
    public void voerUit() {
        Scanner scanner = new Scanner(System.in);
        ControllerKleding controllerKleding = new ControllerKleding(DataSeeder.getInstance().getAlleKleding());
        controllerKleding.zieKledingLijstje();
        int keuze = scanner.nextInt();
        controllerKleding.bewerkKleding(keuze);
    }
}
class MenuNavigatieService {
    public void openAdminMenu(Scanner scanner) {
        KlantAdminMenu menu = new KlantAdminMenu("");
        menu.handleMenu(scanner);
    }

    public void openKlantMenu(AccountSessie cookie, Scanner scanner) {
        ArrayList<IKleding> neww = new ArrayList<>();
        KlantAccountMenu klant = new KlantAccountMenu("ff", cookie);
        cookie.getMandje().setKleding(neww);
        klant.handleMenu(scanner);
    }

    public void openSaleSubMenu(Scanner scanner) {
        SaleSubMenu menu = new SaleSubMenu("");
        menu.handleMenu(scanner);
    }

    public void veranderKoers(AccountSessie cookie, Scanner scanner) {
        ActieVeranderKoersMenu menu = new ActieVeranderKoersMenu(cookie);
        menu.handleMenu(scanner);
    }
}