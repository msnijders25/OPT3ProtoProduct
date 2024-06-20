import java.util.Scanner;

public class ActieVeranderKoerss implements IActie {
    Cookie cookie;
    ActieVeranderKoerss(Cookie cookie){
        this.cookie = cookie;
    }
    @Override
    public void voerUit() {
        Scanner scanner = new Scanner(System.in);
        ActieVeranderKoersMenu menu = new ActieVeranderKoersMenu(cookie);
        menu.handleMenu(scanner);

    }
}
