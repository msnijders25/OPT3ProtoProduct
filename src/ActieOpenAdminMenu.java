import java.util.Scanner;

public class ActieOpenAdminMenu implements IActie{
    @Override
    public void voerUit() {
        Scanner scanner = new Scanner(System.in);
     KlantAdminMenu menu = new KlantAdminMenu("");
     menu.handleMenu(scanner);
    }
}
