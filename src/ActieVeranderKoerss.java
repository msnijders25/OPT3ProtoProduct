import java.util.Scanner;

public class ActieVeranderKoerss implements IActie {
    AccountSessie accountSessie;
    ActieVeranderKoerss(AccountSessie accountSessie){
        this.accountSessie = accountSessie;
    }
    @Override
    public void voerUit() {
        Scanner scanner = new Scanner(System.in);
        ActieVeranderKoersMenu menu = new ActieVeranderKoersMenu(accountSessie);
        menu.handleMenu(scanner);

    }
}
