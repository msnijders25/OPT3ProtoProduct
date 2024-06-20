import java.util.ArrayList;

public class Account {
    String login;
    BestellingGeschiedenis bestellingGeschiedenis = new BestellingGeschiedenis();
    Account(String login){
        this.login = login;

    }
    public String getLogin(){
        return login;
    }

    public String getMandje() {
        return login;
    }

    public BestellingGeschiedenis getBestellingGeschiedenis() {
        return bestellingGeschiedenis;
    }
}
