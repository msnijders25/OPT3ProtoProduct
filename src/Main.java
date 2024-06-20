import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrijsProcesserKlant prijsProcesserKlant = new PrijsProcesserKlant();
        Scanner scanner = new Scanner(System.in);
        DataSeeder.getInstance().seedData();
        Cookie cookie = new Cookie(1, prijsProcesserKlant);
        KlantAdminMenu klant = new KlantAdminMenu("");
        klant.handleMenu(scanner);

    }
}