import java.util.Scanner;

public class ActieZieMandje implements IActie{
    AccountSessie accountSessie;
    Scanner scanner = new Scanner(System.in);
    ActieZieMandje(AccountSessie accountSessie){
     this.accountSessie = accountSessie;

    }
    @Override
    public void voerUit() {
       MandjeMenu menu = new MandjeMenu(accountSessie);
       menu.handleMenu(scanner);
    }
}
