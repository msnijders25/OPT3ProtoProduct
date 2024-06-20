public class ActieKoersConversie implements IActie {
    IKoers koers;
    AccountSessie accountSessie;
    ActieKoersConversie(IKoers koers, AccountSessie accountSessie){
        this.koers = koers;
        this.accountSessie = accountSessie;
    }
    @Override
    public void voerUit() {
        accountSessie.prijsProcesserKlant.setIkoers(koers);
        accountSessie.prijsProcesserKlant.applyKoers();

    }
}
