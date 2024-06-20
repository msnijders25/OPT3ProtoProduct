import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrijsProcesserKlant prijsProcesserKlant = new PrijsProcesserKlant();
        Scanner scanner = new Scanner(System.in);
        DataSeeder.getInstance().seedData();
        AccountSessie accountSessie = new AccountSessie(1, prijsProcesserKlant);
        KlantAdminMenu klant = new KlantAdminMenu("");
        klant.handleMenu(scanner);

    }
}