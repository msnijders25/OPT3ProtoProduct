import java.util.ArrayList;


class Koers implements IKoers {
    private double koers;
    String naam;

    public Koers(double koers, String naam) {
        this.koers = koers;
        this.naam = naam;
    }


    public double getKoers() {
    return koers;}
}
class USD extends Koers{
    USD(){
        super(0.52, "USD");

    }
    }
class EURO extends Koers{
    EURO(){
        super(0.89, "USD");

    }
}
class POUND extends Koers{
    POUND(){
        super(0.77, "USD");

    }
}


class Tax  {
    private double taxPercentage;

    public Tax(double taxPercentage) {
        this.taxPercentage = taxPercentage / 100.0;
    }

    public double getTax() {
        return taxPercentage;
    }
}

class Sale {
    private double salePercentage;

    public Sale(double salePercentage) {
        this.salePercentage = salePercentage / 100.0;
    }



    public double getSale() {
        return salePercentage;
    }
}

class Coupon  {
    private double couponPercentage;

    public Coupon(double couponPercentage) {
        this.couponPercentage = couponPercentage / 100.0;
    }

    public double getCouponPercentage() {
        return couponPercentage;
    }
}

