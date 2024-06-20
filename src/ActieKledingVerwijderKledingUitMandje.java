import java.util.ArrayList;
import java.util.Scanner;

public class ActieKledingVerwijderKledingUitMandje implements IActie {
    private Cookie cookie;
    private IKleding iKleding;

    public ActieKledingVerwijderKledingUitMandje(Cookie cookie, IKleding iKleding) {
        this.cookie = cookie;
        this.iKleding = iKleding;
    }

    @Override
    public void voerUit() {

        ArrayList<IKleding> kledingstukken = cookie.getMandje().getiKleding();
        for (int i = 0; i < kledingstukken.size(); i++) {
            if (kledingstukken.get(i).equals(iKleding)) {
                System.out.println(kledingstukken.get(i) + " is verwijderd.");
                kledingstukken.remove(i);
                break;
            }
        }
    }
}