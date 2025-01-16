public class Candy {


    //instance variables of the class candy
    private String name;
    private String type;
    private double pricePerPound;
    private double quantityInStock;
    private boolean containNuts;

    //constructor of the candy
    public Candy(String name, String type, double pricePerPound, double quantityInStock, boolean containNuts) {
        this.name = name;
        this.type = type;
        this.pricePerPound = pricePerPound;
        this.quantityInStock = 0.0;
        this.containNuts = containNuts;

        if (name == null || type == null || pricePerPound <= 0) {
            throw new IllegalArgumentException("Name and Type are required. PricePerPound must be greater than 0.");
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public boolean isContainNuts() {
        return containNuts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    public void isContainNuts(boolean containNuts) {
        this.containNuts = containNuts;
    }

    public void addStock(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        quantityInStock += amount;
    }

    public double removeStock(double amount) {
        if (amount > quantityInStock) {
            quantityInStock -= amount;
        } else {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }


        }
        return amount;
    }

    public String toString() {
        return " Candy Name: " + name + " Type: " + type + " PricePerPound: " + pricePerPound + " ContainNuts: " + containNuts;
    }


    public boolean containNuts() {
        return false;
    }
}



