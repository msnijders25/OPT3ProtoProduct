import java.util.ArrayList;
import java.util.Scanner;

public class ActieZieBestelling implements  IActie{
    Cookie cookie;
    ActieZieBestelling(Cookie cookie){
        this.cookie = cookie;
    }
    @Override
    public void voerUit() {
        System.out.println("Zie Bestellingen:");
        for(Bestelling bestelling: cookie.getBestellingen()){
            for(IKleding kleding: bestelling.getiKleding()){
            System.out.println(kleding.getNaam());}
        }
    }
}
class BestellingMenu extends  Menu{
   ArrayList<Bestelling> bestellings;
    public BestellingMenu(String naam, ArrayList<Bestelling> bestellings) {
        super(naam);
        this.bestellings = bestellings;
    }

    @Override
    protected void initializeMenuOpties() {
        int i = 0;
        for(Bestelling bestelling: bestellings)
            i++;
        voegOptieToe(new Menukeuze(i, ". Plaats Recensie:" + bestellings.get(i), new ActieZieRecensiesKlant()));
    }
}
 class ActiePlaatsRecensie implements  IActie{
    Scanner scanner;
    Cookie cookie;

    Bestelling bestelling;
    IKleding iKleding;

    ActiePlaatsRecensie(Cookie cookie){
        this.cookie = cookie;
        scanner = new Scanner(System.in);
    }
    @Override
    public void voerUit() {

        System.out.println("Plaatse een recensie:" );
        String nieuweRecensie = scanner.nextLine();
        System.out.println("Geef een beoordeeling 1 - 5:" );
        int beoordeling = scanner.nextInt();
        Recensie recensie = new Recensie(iKleding, bestelling, nieuweRecensie, beoordeling);
        bestelling.setRecensie(recensie);
        DataSeeder.getInstance().getBestellings().add(bestelling);

    }

}