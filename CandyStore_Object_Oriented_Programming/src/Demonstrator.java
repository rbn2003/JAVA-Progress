import java.util.ArrayList;

public class Demonstrator {

        public static void main(String[] args) {
            // Create a new CandyStore instance
            CandyStore store = new CandyStore();

            // Create some candies
            Candy candy1 = new Candy("Snickers", "chocolate", 2.99, 10.0, true);
            Candy candy2 = new Candy("Centerfruit", "gummy", 3.49, 25.5, false );
            Candy candy3 = new Candy("Licorice", "candy", 1.99, 34.4, false);

            // Add candies to the store
            try {
                store.addCandy(candy1);
                store.addCandy(candy2);
                store.addCandy(candy3);
            } catch (IllegalStateException e) {
                System.out.println("Error adding candy to store: " + e.getMessage());
            }

            // Create some customers
            Customer customer1 = new Customer("SISAN BANIYA", "KARNALI33400");
            Customer customer2 = new Customer("RABIN POUDEL", "GANDAKI33800");

            // Add customers to the store
            try {
                store.addCustomer(customer1);
                store.addCustomer(customer2);
            } catch (IllegalStateException e) {
                System.out.println("Error adding customer: " + e.getMessage());
            }

            // Show current inventory size
            System.out.println("Current inventory size: " + store.getInventorySize());

            // Show customer count
            System.out.println("Current customer count: " + store.getCustomerCount());

            // Find a candy by name
            try {
                Candy foundCandy = store.findCandy( "Snickers");
                System.out.println("Found candy: " + foundCandy);
            } catch (IllegalArgumentException e) {
                System.out.println("Error finding candy: " + e.getMessage());
            }

            // Find a customer by loyalty number
            try {
                Customer foundCustomer = store.findCustomer("GANDAKI33700");
                System.out.println("Found customer: " + foundCustomer.getName());
            } catch (IllegalArgumentException e) {
                System.out.println("Error finding customer: " + e.getMessage());
            }

            // Add stock to a candy item
            try {
                candy1.addStock(50.0);
                System.out.println("Added 50 lbs of " + candy1.getName() + " to stock.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error adding stock: " + e.getMessage());
            }

            // Remove stock from a candy item
            try {
                double removed = candy2.removeStock(10.0);
                System.out.println("Removed " + removed + " lbs of " + candy2.getName() + " from stock.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error removing stock: " + e.getMessage());
            }

            // Check for nut-free candies
            ArrayList<Candy> nutFreeCandies = store.findNutFreeCandy();
            System.out.println("Nut-free candies: ");
            for (Candy candy : nutFreeCandies) {
                System.out.println(candy);
            }

            // Check for candies with low stock
            ArrayList<Candy> lowStockCandies = store.findLowStock(20.0);
            System.out.println("Low stock candies: ");
            for (Candy candy : lowStockCandies) {
                System.out.println(candy);
            }

            // Check for candies of a specific type
            ArrayList<Candy> chocolateCandies = store.findCandyByType("chocolate");
            System.out.println("Chocolate candies: ");
            for (Candy candy : chocolateCandies) {
                System.out.println(candy);
            }
        }
}


