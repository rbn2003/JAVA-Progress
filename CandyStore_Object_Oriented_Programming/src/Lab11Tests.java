import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab11Tests {
    private Candy chocolate;
    private Candy gummy;
    private Customer customer1;
    private Customer customer2;
    private CandyStore store;

    @BeforeEach
    public void setUp() {
        chocolate = new Candy("Dark Chocolate", "chocolate", 12.99, true);
        gummy = new Candy("Gummy Bears", "gummy", 5.99, false);
        customer1 = new Customer("Foo Bar", "12345");
        store = new CandyStore();
    }

    // Candy Class Tests
    @Test
    public void testCandyConstructor() {
        assertEquals("Dark Chocolate", chocolate.getName());
        assertEquals("chocolate", chocolate.getType());
        assertEquals(12.99, chocolate.getPricePerPound(), 0.001);
        assertTrue(chocolate.getContainsNuts());
        assertEquals(0.0, chocolate.getQuantityInStock(), 0.001);
    }

    @Test
    public void testCandyConstructorNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Candy(null, "chocolate", 12.99, true);
        });
    }

    @Test
    public void testCandyConstructorEmptyType() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Candy("Dark Chocolate", "", 12.99, true);
        });
    }

    @Test
    public void testCandyConstructorInvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Candy("Dark Chocolate", "chocolate", -1.0, true);
        });
    }

    @Test
    public void testAddStock() {
        chocolate.addStock(5.0);
        assertEquals(5.0, chocolate.getQuantityInStock(), 0.001);
    }

    @Test
    public void testAddStockNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            chocolate.addStock(-1.0);
        });
    }

    @Test
    public void testRemoveStock() {
        chocolate.addStock(10.0);
        assertEquals(5.0, chocolate.removeStock(5.0), 0.001);
        assertEquals(5.0, chocolate.getQuantityInStock(), 0.001);
    }

    @Test
    public void testRemoveStockMoreThanAvailable() {
        chocolate.addStock(5.0);
        assertEquals(5.0, chocolate.removeStock(10.0), 0.001);
        assertEquals(0.0, chocolate.getQuantityInStock(), 0.001);
    }

    // Customer Class Tests
    @Test
    public void testCustomerConstructor() {
        assertEquals("Foo Bar", customer1.getName());
        assertEquals("12345", customer1.getLoyaltyNumber());
        assertEquals(0.0, customer1.getLoyaltyPoints(), 0.001);
    }

    @Test
    public void testCustomerConstructorNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(null, "12345");
        });
    }

    @Test
    public void testAddPoints() {
        customer1.addPoints(100.0);
        assertEquals(100.0, customer1.getLoyaltyPoints(), 0.001);
    }

    @Test
    public void testAddPointsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            customer1.addPoints(-50.0);
        });
    }

    // CandyStore Class Tests
    @Test
    public void testStoreConstructor() {
        assertEquals(0, store.getInventorySize());
        assertEquals(0, store.getCustomerCount());
        assertEquals(1000, store.getMAX_INVENTORY());
        assertEquals(1000, store.getMAX_CUSTOMERS());
    }

    @Test
    public void testAddCandy() {
        store.addCandy(chocolate);
        assertEquals(1, store.getInventorySize());
    }

    @Test
    public void testAddDuplicateCandy() {
        store.addCandy(chocolate);
        assertThrows(IllegalStateException.class, () -> {
            store.addCandy(new Candy("Dark Chocolate", "chocolate", 13.99, true));
        });
    }

    @Test
    public void testFindCandy() {
        store.addCandy(chocolate);
        store.addCandy(gummy);
        assertEquals(chocolate, store.findCandy("Dark Chocolate"));
    }

    @Test
    public void testFindNonexistentCandy() {
        assertThrows(IllegalArgumentException.class, () -> {
            store.findCandy("Nonexistent Candy");
        });
    }

    // Stretch Goal Tests
    @Test
    public void testFindNutFreeCandy() {
        store.addCandy(chocolate);
        store.addCandy(gummy);
        var nutFree = store.findNutFreeCandy();
        assertEquals(1, nutFree.size());
        assertTrue(nutFree.contains(gummy));
    }

    @Test
    public void testFindLowStock() {
        chocolate.addStock(3.0);
        gummy.addStock(1.0);
        store.addCandy(chocolate);
        store.addCandy(gummy);
        var lowStock = store.findLowStock(2.0);
        assertEquals(1, lowStock.size());
        assertTrue(lowStock.contains(gummy));
    }

    @Test
    public void testFindCandyByType() {
        store.addCandy(chocolate);
        store.addCandy(gummy);
        var chocolates = store.findCandyByType("chocolate");
        assertEquals(1, chocolates.size());
        assertTrue(chocolates.contains(chocolate));
    }
}
