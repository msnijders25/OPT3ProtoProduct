import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ObserverKleding {
    void update();
}

public class ControllerKleding {

    private List<ObserverKleding> observers = new ArrayList<>();
    private List<IKleding> kledingstukken;

    public ControllerKleding(List<IKleding> kledingstukken) {
        this.kledingstukken = kledingstukken;
    }

    public void verwijderKleding(int keuze) {
        IKleding kledingToRemove = vindKleding(keuze);
        if (kledingToRemove != null) {
            System.out.println(kledingToRemove + " is verwijderd.");
            kledingstukken.remove(kledingToRemove);
            notifeer();
        } else {
            System.out.println("Kledingstuk niet gevonden.");
        }
    }

    public void zieKledingLijstje() {
        for (int i = 0; i < kledingstukken.size(); i++) {
            IKleding kleding = kledingstukken.get(i);
            System.out.println((i + 1) + ". " + kleding.getNaam() + " Prijs: " + kleding.getBasisPrijs());
        }
    }

    public void getKleding(int keuze) {
        IKleding kleding = vindKleding(keuze);
        if (kleding != null) {
            System.out.println(kleding + " is gekozen.");
        } else {
            System.out.println("Kledingstuk niet gevonden.");
        }
    }

    public void kledingVerlaagVoorraad(int keuze) {
        IKleding kleding = vindKleding(keuze);
        if (kleding != null) {
            kleding.setVoorraad(kleding.getVoorraad() - 1);
            System.out.println(kleding + " is verlaagd.");
            notifeer();
        } else {
            System.out.println("Kledingstuk niet gevonden.");
        }
    }

    public void kledingVerhoogVoorraad(int keuze) {
        IKleding kleding = vindKleding(keuze);
        if (kleding != null) {
            kleding.setVoorraad(kleding.getVoorraad() + 1);
            System.out.println(kleding + " is verhoogd.");
            notifeer();
        } else {
            System.out.println("Kledingstuk niet gevonden.");
        }
    }
    public void bewerkKleding(int keuze) {
        IKleding kleding = vindKleding(keuze);
        if (kleding != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Bewerk Voorraad:");
            System.out.println("2. Bewerk Prijs:");
            int nieuwKeuze = scanner.nextInt();

            switch (nieuwKeuze) {
                case 1:
                    System.out.println("Voer voorraad in: ");
                    int nieuweVoorraad = scanner.nextInt();
                    kleding.setVoorraad(nieuweVoorraad);
                    break;
                case 2:
                    System.out.println("Voer prijs in: ");
                    double nieuwePrijs = scanner.nextDouble();
                    kleding.setBasisPrijs(nieuwePrijs);
                    break;
                default:
                    System.out.println("Ongeldige keuze.");
            }

            notifeer();
        } else {
            System.out.println("Kledingstuk niet gevonden.");
        }
    }

    public void addObserver(ObserverKleding observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverKleding observer) {
        observers.remove(observer);
    }

    public void notifeer() {
        for (ObserverKleding observer : observers) {
            observer.update();
        }
    }

    private IKleding vindKleding(int keuze) {
        for (IKleding kleding : kledingstukken) {
            if (kleding.getId() == keuze) {
                return kleding;
            }
        }
        return null;
    }

}