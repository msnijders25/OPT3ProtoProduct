import java.util.ArrayList;
import java.util.Scanner;

public class ActieZieAssortiment implements IActie{ private Scanner scanner;
    private AccountSessie account;
    public ActieZieAssortiment(AccountSessie account) {
        this.scanner =  new Scanner(System.in);
        this.account = account;
    }

    @Override
    public void voerUit() {
        while (true) {
            System.out.println("Kies een optie:");
            System.out.println("1. Toon Hoodies");
            System.out.println("2. Toon Shirts");
            System.out.println("3. Toon Broeken");
            System.out.println("4. Terug");

            System.out.print("Voer uw keuze in: ");
            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1":
                    toonKleding(DataSeeder.getInstance().getHoodies(), "Hoodies", account);
                    break;
                case "2":
                    toonKleding(DataSeeder.getInstance().getShirts(), "Shirts", account);
                    break;
                case "3":
                    toonKleding(DataSeeder.getInstance().getBroeken(), "Broeken", account);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    private void toonKleding(ArrayList<IKleding> kledingLijst, String categorieNaam, AccountSessie account) {

        System.out.println(categorieNaam + ":");
        for (int i = 0; i < kledingLijst.size(); i++) {
            IKleding kleding = kledingLijst.get(i);
            System.out.println((i + 1) + ". " + kleding.getNaam() + " De prijs: " + kleding.getBasisPrijs() + " Voorraad: " + kleding.getVoorraad());
        }
        System.out.println();
        System.out.print("Kies een item (of 0 om terug te gaan): ");
        int keuze = scanner.nextInt();
        if (keuze >= 1 && keuze <= kledingLijst.size()) {
            IKleding gekozenKleding = kledingLijst.get(keuze - 1);
            System.out.println("Je hebt " + gekozenKleding.getNaam() + " gekozen.");
            account.getMandje().voegKledingToe(gekozenKleding);
            scanner.nextLine();
        } else if (keuze == 0) {
            System.out.println("Terug naar het vorige menu.");
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
    }

}
