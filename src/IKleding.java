import java.util.ArrayList;


interface KledingFactory{
    IKleding  createTshirt(double basisPrijs, String naam, int voorraad, int id);
    IKleding  createBroek(double basisPrijs, String naam, int voorraad, int id);
    IKleding  createHoodie(double basisPrijs, String naam, int voorraad, int id);

}
class CasualKledingFactory implements  KledingFactory {


    @Override
    public IKleding createTshirt(double basisPrijs, String naam, int voorraad, int id) {
        return new Tshirt(basisPrijs, naam, voorraad,  id);
    }

    @Override
    public IKleding createBroek(double basisPrijs, String naam, int voorraad, int id) {
        return new Broek(basisPrijs, naam, voorraad,  id);
    }

    @Override
    public IKleding createHoodie(double basisPrijs, String naam, int voorraad, int id) {
        return new Hoodie(basisPrijs, naam, voorraad,  id);
    }
}

class FormeelKledingFactory implements  KledingFactory {

    @Override
    public IKleding createTshirt(double basisPrijs, String naam, int voorraad, int id) {
        return new Tshirt(basisPrijs, naam, voorraad,  id);
    }

    @Override
    public IKleding createBroek(double basisPrijs, String naam, int voorraad, int id) {
        return new Broek(basisPrijs, naam, voorraad,  id);
    }

    @Override
    public IKleding createHoodie(double basisPrijs, String naam, int voorraad, int id) {
        return new Hoodie(basisPrijs, naam, voorraad,  id);
    }

}

class LuxuryKledingFactory implements  KledingFactory  {

    @Override
    public IKleding createTshirt(double basisPrijs, String naam, int voorraad, int id) {
        return new Tshirt(basisPrijs, naam, voorraad,  id);
    }

    @Override
    public IKleding createBroek(double basisPrijs, String naam, int voorraad, int id) {
        return new Broek(basisPrijs, naam, voorraad,  id);
    }

    @Override
    public IKleding createHoodie(double basisPrijs, String naam, int voorraad, int id) {
        return new Hoodie(basisPrijs, naam, voorraad,  id);

    }
}
class StandaardPrijsStrategie implements PrijsStrategie {
    @Override
    public double berekenPrijs(double basisPrijs) {
        return basisPrijs;
    }
}

class SalePrijsStrategie implements PrijsStrategie {
    @Override
    public double berekenPrijs(double basisPrijs) {
        return basisPrijs * 0.8; // 20% discount
    }
}

class TaxPrijsStrategie implements PrijsStrategie {

    @Override
    public double berekenPrijs(double basisPrijs) {
        return basisPrijs * 1.21;
    }

}

abstract class PrijsProcesser {
    protected IKleding kledingFactory;
    protected PrijsStrategie prijsStrategie;
    protected ArrayList<Prijs> prijzen;
    protected ArrayList<prijsObserver> observers = new ArrayList<>();

    public PrijsProcesser(IKleding kledingFactory, PrijsStrategie prijsStrategie) {
        this.kledingFactory = kledingFactory;
        this.prijsStrategie = prijsStrategie;
        this.prijzen = new ArrayList<>();
    }

    public final ArrayList<Prijs> loadEindPrijs() {
        selectKleding();
        loadPrijzen();
        applyKoers();
        loadPrijzenMetTax();
        notificatie();
        return prijzen;
    }

    protected void selectKleding() {
        for (IKleding kleding : DataSeeder.getInstance().getAlleKleding()) {
            prijzen.add(new Prijs(kleding.getId(), kleding.getBasisPrijs()));
            System.out.println(prijzen.get(0).getPrijs());
        }
    }

    protected abstract void loadPrijzen();

    protected void applyKoers() {
    }

    protected void loadPrijzenMetTax() {
        for (Prijs prijs : prijzen) {
            double nieuwePrijs = prijsStrategie.berekenPrijs(prijs.getPrijs());
            prijs.setPrijs(nieuwePrijs);
        }
    }

    private void notificatie() {
        for (prijsObserver observer : observers) {
            observer.update(prijzen);
        }
    }

    public void addObserver(prijsObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(prijsObserver observer) {
        observers.remove(observer);
    }
}

class PrijsProcesserKoers extends PrijsProcesser {
    IKoers iKoers;

    public PrijsProcesserKoers(IKleding kledingFactory, PrijsStrategie prijsStrategie, IKoers iKoers) {
        super(kledingFactory, prijsStrategie);
        this.iKoers = iKoers;
    }

    @Override
    protected void loadPrijzen() {
        for (IKleding kleding : DataSeeder.getInstance().getAlleKleding()) {
             kleding.setBasisPrijs(kleding.getBasisPrijs() * iKoers.getKoers()); ;

        }
    }

    @Override
    protected void applyKoers() {
        for (Prijs prijs : prijzen) {
            double nieuwePrijs = prijs.getPrijs() * iKoers.getKoers();
            prijs.setPrijs(nieuwePrijs);
        }
    }
}

class PrijsProcesserKlant extends PrijsProcesser {
    public PrijsProcesserKlant(IKleding kledingFactory, PrijsStrategie prijsStrategie) {
        super(kledingFactory, prijsStrategie);
    }

    @Override
    protected void loadPrijzen() {
        for (IKleding kleding : DataSeeder.getInstance().getAlleKleding()) {
            double basisPrijs = kleding.getBasisPrijs();
            prijzen.add(new Prijs(kleding.getId(), kleding.getBasisPrijs()));
        }
    }
}

interface PrijsStrategie {

    double berekenPrijs(double basisPrijs);
}
