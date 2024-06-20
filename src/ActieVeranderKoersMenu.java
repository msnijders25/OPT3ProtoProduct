public class ActieVeranderKoersMenu extends Menu {
AccountSessie accountSessie;
    ActieVeranderKoersMenu(AccountSessie accountSessie){
        super("");
this.accountSessie = accountSessie;
    }
            @Override
            protected void initializeMenuOpties() {
                this.opties.clear();
                voegOptieToe(new Menukeuze(1, ". Dollar", new ActieKoersConversie(new USD(), accountSessie)));
                voegOptieToe(new Menukeuze(2, ". Pound", new ActieKoersConversie(new POUND(), accountSessie)));
                voegOptieToe(new Menukeuze(3, ". Euro", new ActieKoersConversie(new EURO(), accountSessie)));
                voegOptieToe(new Menukeuze(9, "Terug", true));

            }

    }

