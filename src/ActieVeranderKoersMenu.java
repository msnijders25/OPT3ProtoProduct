public class ActieVeranderKoersMenu extends Menu {

    ActieVeranderKoersMenu(){
        super("");

    }
            @Override
            protected void initializeMenuOpties() {
                this.opties.clear();
                USD usd = new USD();
                voegOptieToe(new Menukeuze(1, usd.naam, new ActieKoersConversie(usd)));
                voegOptieToe(new Menukeuze(9, "Terug", true));

            }

    }

