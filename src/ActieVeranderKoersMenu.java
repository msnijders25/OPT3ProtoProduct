public class ActieVeranderKoersMenu extends Menu {
Cookie cookie;
    ActieVeranderKoersMenu(Cookie cookie){
        super("");
this.cookie = cookie;
    }
            @Override
            protected void initializeMenuOpties() {
                this.opties.clear();
                USD usd = new USD();
                POUND pound = new POUND();
                EURO euro = new EURO();
                voegOptieToe(new Menukeuze(1, usd.naam, new ActieKoersConversie(usd, cookie)));
                voegOptieToe(new Menukeuze(2, euro.naam, new ActieKoersConversie(pound, cookie)));
                voegOptieToe(new Menukeuze(3, pound.naam, new ActieKoersConversie(euro, cookie)));
                voegOptieToe(new Menukeuze(9, "Terug", true));

            }

    }

