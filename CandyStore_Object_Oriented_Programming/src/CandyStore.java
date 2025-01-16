import java.util.ArrayList;
public class CandyStore {

    //private instance variables
    private ArrayList<Candy> inventory;
    private ArrayList<Customer> customers;
    private int MAX_INVENTORY = 1000;
    private int MAX_CUSTOMER = 1000;

    public CandyStore() {
        inventory = new ArrayList<Candy>();
        customers = new ArrayList<Customer>();
    }

    public ArrayList<Candy> getInventory() {
        return inventory;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getMaxInventory() {
        return MAX_INVENTORY;
    }

    public int getMaxCustomer() {
        return MAX_CUSTOMER;
    }

    public int getInventorySize() {
        return inventory.size();
    }

    public int getCustomerCount() {
        return customers.size();
    }

    public void addCandy(Candy candy) {
        if (inventory.size() >= MAX_INVENTORY) { //checking if adding the candy would exceed the size or not
            throw new IllegalArgumentException("Either the size of inventory is exceeding the max inventory.");
        }

        for (Candy c : inventory) { //checking if the candy with the same name already exists
            if (c.getName().equals(candy.getName())) {
                throw new IllegalArgumentException("Candy is already in the inventory.");
            }
        }

        inventory.add(candy);
    }


    public Candy findCandy(String name) {

        //searching in the inventory if the candy with the given name exists or not
        for (Candy candy : inventory) {
            if (candy.getName().equals(name)) {
                return candy;
            }
        }
        throw new IllegalArgumentException("Candy with the name:" + name + "does not exists.");
    }


    public void addCustomer(String name, String loyaltyNumber) {

        //checking if the max limit is reach or not
        if (customers.size() >= MAX_CUSTOMER) {
            throw new IllegalArgumentException("Customer can not be added. Maximum limit reached.");
        }
        for (Customer customer : customers) {
            if (customer.getLoyaltyNumber().equals(loyaltyNumber)) {
                throw new IllegalArgumentException("A Customer with the loyalty number: " + loyaltyNumber + "already exists.");
            }
        }

            //passing all the conditions, add the customer to the list
            Customer newCustomer = new Customer(name, loyaltyNumber);
            customers.add(newCustomer);
    }



    public void addCustomer(Customer c) {

        //checking if the customers size exceeds the max customers size
        if (customers.size() >= MAX_CUSTOMER) {
            throw new IllegalArgumentException("Customer cannot be added. Maximum limit reached.");
        }

        //check if the customer's loyalty number match or not
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getLoyaltyNumber().equals(c.getLoyaltyNumber())) {
                throw new IllegalArgumentException("Customer cannot be added. Loyalty Number matched.");
            }

            // if everything pass, add the customer.
            customers.add(c);
        }
    }

    public Customer findCustomer(String loyaltyNumber) {

        //checking with every customer loyalty number
        for (Customer customer : customers) {
            if (customer.getLoyaltyNumber().equals(loyaltyNumber)) {
                return customer;
            }
        }

        // if no matching customer with loyalty number found
        throw new IllegalArgumentException("Customer with the loyalty number: " + loyaltyNumber + "does not exists.");
    }


    public ArrayList<Candy> findNutFreeCandy() {

        //creating a new array list to store nut free candies
        ArrayList<Candy> nutFreeCandies = new ArrayList<>();

        //looping through the inventory and add candies that do not contain nuts
        for (Candy candy : inventory) {
            if (!candy.containNuts()) {
                nutFreeCandies.add(candy);
            }
        }

        return nutFreeCandies;
    }

    public ArrayList<Candy> findLowStock(double threshold){

        //creating a new array list to store candy items below the threshold
        ArrayList<Candy> lowStockCandies = new ArrayList<>();

        // looping through the inventory and adding candies that items are below the threshold
        for (Candy candy : inventory) {
            if (candy.getQuantityInStock() < threshold ) {
                lowStockCandies.add(candy);
            }
        }


        //returning the candies with their items below the threshold value
        return lowStockCandies;
    }

    public ArrayList<Candy> findCandyByType(String type){

        //creating a new array list to store the types of the candy
        ArrayList<Candy> candyByType = new ArrayList<>();

        //looping through the inventory to find the candy by types
        for (Candy candy : inventory) {
            if (candy.getType().equals(type)) {
                candyByType.add(candy);
            }
        }

        //if no candy matches the given type
        if (candyByType.isEmpty()) {
            throw new IllegalArgumentException("Candy didn't match the given type");
        }

        return candyByType;
    }
}

