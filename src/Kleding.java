import java.util.ArrayList;

interface IKleding {
    String getType();
    double getBasisPrijs();
    String getNaam();
    int getVoorraad();
    int getId();
    void setBasisPrijs(double basisPrijs);

    void setVoorraad(int i);
}

abstract class AbstractKleding implements IKleding ,VoorraadSubject {

    protected ArrayList<VoorraadObserver> observers = new ArrayList<>();

    protected double basisPrijs;
    protected String type;
    protected String naam;
    protected int voorraad;
    protected int id;


    public AbstractKleding(double basisPrijs, String type, String naam, int voorraad, int id) {
        this.basisPrijs = basisPrijs;
        this.type = type;
        this.naam = naam;
        this.voorraad = voorraad;
        this.id = id;
    }

    public void setBasisPrijs(double basisPrijs) {
        this.basisPrijs = basisPrijs;
    }

    @Override
    public double getBasisPrijs() { return basisPrijs; }

    @Override
    public String getType() { return type; }

    // New methods
    @Override
    public String getNaam() { return naam; }

    @Override
    public int getVoorraad() { return voorraad; }

    @Override
    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
        notifyObservers();
    }
    @Override
    public void addObserver(VoorraadObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(VoorraadObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (VoorraadObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public int getId() { return id; }
}

class Hoodie extends AbstractKleding {
    public Hoodie(double basisPrijs, String naam, int voorraad, int id) {
        super(basisPrijs, "Hoodie", naam, voorraad, id);

    }

    @Override
    public double getBasisPrijs() { return basisPrijs; }

    @Override
    public String getType() { return type; }

    @Override
    public String getNaam() { return naam; }

    @Override
    public int getVoorraad() { return voorraad; }

    @Override
    public int getId() { return id; }

    @Override
    public void setVoorraad(int i) {
        this.voorraad = i;
    }

    @Override
    public void addObserver(VoorraadObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(VoorraadObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (VoorraadObserver observer : observers) {
            observer.update();
        }
    }
}


    class Tshirt extends AbstractKleding {
    public Tshirt(double basisPrijs, String naam, int voorraad, int id) {
        super(basisPrijs, "Tshirt", naam, voorraad, id);

        }

        @Override
        public void setVoorraad(int i) {
            this.voorraad = i;
        }
    @Override
    public double getBasisPrijs() { return basisPrijs; }

    @Override
    public String getType() { return type; }


    @Override
    public String getNaam() { return naam; }

    @Override
    public int getVoorraad() { return voorraad; }

    @Override
    public int getId() { return id; }

        @Override
        public void addObserver(VoorraadObserver observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(VoorraadObserver observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (VoorraadObserver observer : observers) {
                observer.update();
            }
        }
    }


class Broek extends AbstractKleding {
    public Broek(double basisPrijs, String naam, int voorraad, int id) {
        super(basisPrijs, "Broek", naam, voorraad, id);
    }

    @Override
    public void setVoorraad(int i) {
        this.voorraad = i;
    }
    @Override
    public double getBasisPrijs() { return basisPrijs; }

    @Override
    public String getType() { return type; }

    @Override
    public String getNaam() { return naam; }

    @Override
    public int getVoorraad() { return voorraad; }

    @Override
    public int getId() { return id; }
    @Override
    public void addObserver(VoorraadObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(VoorraadObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (VoorraadObserver observer : observers) {
            observer.update();
        }
    }}

