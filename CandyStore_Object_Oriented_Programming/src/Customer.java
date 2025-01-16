public class Customer {

    //instance variables
    private String name;
    private String loyaltyNumber;
    private double loyaltyPoints = 0.0;


    //constructor
    public Customer (String name, String loyaltyNUmber){
        this.name = name;
        this.loyaltyNumber = loyaltyNUmber;
    }

    public String getName(){
        return name;
    }

    public String getLoyaltyNumber(){
        return loyaltyNumber;
    }

    public double getLoyaltyPoints(){
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(double loyaltyPoints){
        this.loyaltyPoints = loyaltyPoints;
    }

    public void addPoints(double points){
        this.loyaltyPoints += points;
        if (this.loyaltyPoints < 0){
            throw new IllegalArgumentException("Loyalty points should be greater than 0");
        }
    }

    public void removePoints(double points){
        this.loyaltyPoints -= points;
        if (this.loyaltyPoints < 0){
            throw new IllegalArgumentException("Loyalty points should be greater than 0");
        }
    }


}
