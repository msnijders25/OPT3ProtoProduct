import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mand{
    ArrayList<IKleding> iKleding = new ArrayList<>();



    public Mand() {

    }
    public void voegKledingToe(IKleding gekozenKleding) {
        iKleding.add(gekozenKleding);
    }

     public void setKleding(ArrayList<IKleding> iKleding){
        this.iKleding = iKleding;}
    protected ArrayList<IKleding> getiKleding(){
        return iKleding;
    }

    }

