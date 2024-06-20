class ActiePlaatsBestelling implements IActie {
    private AccountSessie account;

    public ActiePlaatsBestelling(AccountSessie account) {
        this.account = account;
    }

    @Override
    public void voerUit() {
        Mand mandje = account.getMandje();
        if (mandje == null) {
            System.out.println("Het mandje is leeg. Kan geen bestelling plaatsen.");
        } else {
            System.out.println("Bestelling geplaatst met de volgende items:");
            for (IKleding kleding : mandje.getiKleding()) {
                System.out.println("- " + kleding.getNaam());
            }
            Bestelling bestelling = new Bestelling(mandje.getiKleding());
            account.setBestellingen(bestelling);

            System.out.println();
        }
    }
}
