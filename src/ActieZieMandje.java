import java.util.Scanner;

public class ActieZieMandje implements IActie{
    Cookie cookie;
    Scanner scanner = new Scanner(System.in);
    ActieZieMandje(Cookie cookie){
     this.cookie = cookie;

    }
    @Override
    public void voerUit() {
       MandjeMenu menu = new MandjeMenu(cookie);
       menu.handleMenu(scanner);
    }
}
