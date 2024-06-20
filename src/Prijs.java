public class Prijs {
    public double prijs;
    int id;
    public Prijs(int id, double prijs) {
        this.id = id;
        this.prijs = prijs;
    }
public double getPrijs(){
        return prijs;
}
public int getId(){
        return id;
}

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setId(int id) {
        this.id = id;
    }
}


