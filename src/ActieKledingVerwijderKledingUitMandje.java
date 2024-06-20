import java.util.ArrayList;

public class ActieKledingVerwijderKledingUitMandje implements IActie {
    private AccountSessie accountSessie;
    private IKleding iKleding;

    public ActieKledingVerwijderKledingUitMandje(AccountSessie accountSessie, IKleding iKleding) {
        this.accountSessie = accountSessie;
        this.iKleding = iKleding;
    }

    @Override
    public void voerUit() {
        ArrayList<IKleding> kledingstukken = accountSessie.getMandje().getiKleding();
        for (int i = 0; i < kledingstukken.size(); i++) {
            if (kledingstukken.get(i).equals(iKleding)) {
                System.out.println(kledingstukken.get(i) + " is verwijderd.");
                kledingstukken.remove(i);
                break;
            }
        }
    }
}