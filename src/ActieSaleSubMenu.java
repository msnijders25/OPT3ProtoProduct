import java.util.ArrayList;
import java.util.Scanner;
class ActieKiesEenSale implements IActie{

        @Override
        public void voerUit() {

            Scanner scanner = new Scanner(System.in);
            ArrayList<IKleding> iKledings = new ArrayList<>();
            ControllerKleding controllerKleding = new ControllerKleding(DataSeeder.getInstance().getAlleKleding());

            controllerKleding.zieKledingLijstje();

            while (true) {
                System.out.println("Kies kledingstukken:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Ongeldige invoer. Voer een getal in:");
                    scanner.next();
                }

                int keuze = scanner.nextInt();
                scanner.nextLine();

                iKledings.add(controllerKleding.getKleding(keuze));

                System.out.println("Wilt u nog meer items toevoegen? (y/n)");
                String choice = scanner.nextLine().trim().toLowerCase();

                while (!choice.equals("j") && !choice.equals("n")) {
                    System.out.println("Ongeldige invoer. Voer 'j' of 'n' in:");
                    choice = scanner.nextLine().trim().toLowerCase();
                }

                if (choice.equals("n")) {
                    break;
                }
            }
            System.out.println("Uw geselecteerde kledingstukken:");
            for (IKleding kleding : iKledings) {
                System.out.println(kleding);
            }
            System.out.println("Voeg de sale toe:");
            double salePercentage = scanner.nextInt();
            for (IKleding kleding : iKledings) {
                double originalPrice = kleding.getBasisPrijs();
                double newPrice = originalPrice - (originalPrice * salePercentage / 100);
                kleding.setBasisPrijs(newPrice);
            }

            // Display final prices
            System.out.println("Uw geselecteerde kledingstukken met korting:");
            for (IKleding kleding : iKledings) {
                System.out.println(kleding + " (Nieuwe prijs: " + kleding.getBasisPrijs() + ")");
            }
        }
    }

 class SaleSubMenu extends Menu{


    public SaleSubMenu(String naam) {
        super(naam);
    }

    @Override
    protected void initializeMenuOpties() {
        voegOptieToe(new Menukeuze(1, " Kies specifieke kleding voor sale", new ActieKiesEenSale()));
        voegOptieToe(new Menukeuze(2, " Kies sale categorie voor sale", false));

    }
}

public class ActieSaleSubMenu implements IActie {


    public ActieSaleSubMenu() {

    }

    @Override
    public void voerUit() {
        Scanner scanner = new Scanner(System.in);
     SaleSubMenu menu = new SaleSubMenu("");
     menu.handleMenu(scanner);
    }
}