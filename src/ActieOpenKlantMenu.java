import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ActieOpenKlantMenu implements IActie{

    Cookie cookie;
    ActieOpenKlantMenu(Cookie cookie){
        this.cookie = cookie;
    }
    @Override
    public void voerUit() {
        ArrayList<IKleding>  neww = new ArrayList<>();
        KlantAccountMenu klant = new KlantAccountMenu("ff", cookie);
        cookie.getMandje().setKleding(neww);
        klant.handleMenu(new Scanner(System.in));
    }
}

