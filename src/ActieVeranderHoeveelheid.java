import java.util.ArrayList;
import java.util.Scanner;

class ActieVeranderHoeveelheid implements IActie {
    private IKleding kleding;
    private Cookie cookie;
    Scanner scanner = new Scanner(System.in);

    public ActieVeranderHoeveelheid(IKleding kleding, Cookie cookie) {
        this.kleding = kleding;
        this.cookie = cookie;
    }

    @Override
    public void voerUit() {
        System.out.println("Hoeveelheid van " + kleding + " aanpassen.");
        System.out.println("1. Verhogen");
        System.out.println("2. Verlagen");
        System.out.print("Kies een optie: ");

        int keuze = scanner.nextInt();
        scanner.nextLine();

        switch (keuze) {
            //case 1:
            //    kleding.setVoorraad(kleding.getHoeveelheid() + 1);
             //   System.out.println("Hoeveelheid verhoogd.");
              //  break;
            case 2:
                //if (kleding.getHoeveelheid() > 0) {
                    //kleding.setVoorraad(kleding.getHoeveelheid() - 1);
                    System.out.println("Hoeveelheid verlaagd.");
               // } else {
                    System.out.println("Hoeveelheid kan niet verder worden verlaagd.");
             //   }
            //    break;
          //  default:
            //    System.out.println("Ongeldige keuze.");
        }
               // new ActieZieMandje(cookie);
    }//


    }

