//import java.util.ArrayList;
//interface prijsObserver{
  //  void update(ArrayList<Prijs> prijzen);
//}

//class PrijsProcesserAdmin {
  //  ArrayList<IKleding> kleding;
    //ArrayList<Prijs> prijzen = new ArrayList<>();
    //ArrayList<prijsObserver> observers;
    //Koers koers;


    //PrijsProcesserAdmin(Koers koers){
      //  this.prijzen = new ArrayList<>();
      //  this.kleding = new ArrayList<>();
        //for(IKleding kledingstuk: DataSeeder.getInstance().getAlleKleding()){
          //  this.prijzen.add(new Prijs(kledingstuk.getId(),kledingstuk.getBasisPrijs()));
          //  this.kleding.add(kledingstuk);
       // }
       // this.koers=  koers;
   // }
    //void loadEindPrijs(){
     //   loadPrijzen();
       // LoadPrijzenMetTax();
       // LoadPrijzenMetSale();

   // }

   // public ArrayList<Prijs> loadPrijzen() {
     //   return prijzen;
   // }
   // public void LoadPrijzenMetTax() {
   //     for(Prijs prijs: prijzen) {
     //       System.out.println(prijs.getPrijs() * 1.05);
     //       prijs.setPrijs(prijs.getPrijs() * 1.05);
     //   }
   // }


    //public void LoadPrijzenMetSale() {
      //  for(Prijs prijs: prijzen) {
        //    System.out.println(prijs.getPrijs() * 1.05);
          //   prijs.setPrijs(prijs.getPrijs() * 1.05);
       // }
   // }
 //   public void LoadPrijzenMetCurrncy() {
 //       for(Prijs prijs: prijzen) {
 //           System.out.println(prijs.getPrijs() * koers.getKoers());
  //          prijs.setPrijs(prijs.getPrijs() * koers.getKoers());
   //     }
   // }



 //   public void notificatie(){
    //    for(prijsObserver perObserver : observers){
//            perObserver.update(prijzen);
  //      }
   // }
//}
//abstract class PrijsKledingFactory{

    //PrijsKledingFactory(){

  //  }
    //abstract void initialiseerPrijs();
    //abstract void initialiseerKleding();
//}

