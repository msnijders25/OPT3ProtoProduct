import java.util.Scanner;

public class ActieVeranderKoerss implements IActie {
    @Override
    public void voerUit() {
        Scanner scanner = new Scanner(System.in);
        ActieVeranderKoersMenu menu = new ActieVeranderKoersMenu();
        menu.handleMenu(scanner);

    }
}
