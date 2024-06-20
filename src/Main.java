import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataSeeder.getInstance().seedData();
        Cookie cookie = new Cookie(1);
        KlantAccountMenu klant = new KlantAccountMenu("",cookie);
        klant.handleMenu(scanner);

    }
}