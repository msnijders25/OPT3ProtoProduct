public class ActieKoersConversie implements IActie {
    Koers koers;
    ActieKoersConversie(Koers koers){
        this.koers = koers;
    }
    @Override
    public void voerUit() {
        SalePrijsStrategie prijsStrategie = new SalePrijsStrategie();
        Hoodie hoodie = new Hoodie(1, "", 1, 1);
        USD usd = new USD();

        PrijsProcesserKoers processer = new PrijsProcesserKoers(hoodie, prijsStrategie, usd) ;
        processer.loadPrijzen();
    }
}
