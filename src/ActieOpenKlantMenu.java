import java.util.ArrayList;
import java.util.Scanner;

public class ActieOpenKlantMenu implements IActie{

    AccountSessie accountSessie;
    ActieOpenKlantMenu(AccountSessie accountSessie){
        this.accountSessie = accountSessie;
    }
    @Override
    public void voerUit() {
        ArrayList<IKleding>  neww = new ArrayList<>();
        KlantAccountMenu klant = new KlantAccountMenu("ff", accountSessie);
        accountSessie.getMandje().setKleding(neww);
        klant.handleMenu(new Scanner(System.in));
    }
}

