public class ActieKoersConversie implements IActie {
    IKoers koers;
    Cookie cookie;
    ActieKoersConversie(IKoers koers, Cookie cookie){
        this.koers = koers;
        this.cookie = cookie;
    }
    @Override
    public void voerUit() {
        cookie.prijsProcesserKlant.setIkoers(koers);
        cookie.prijsProcesserKlant.applyKoers();

    }
}
