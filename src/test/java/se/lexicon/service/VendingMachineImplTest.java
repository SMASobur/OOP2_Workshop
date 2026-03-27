package se.lexicon.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {

    private IVendingMachine vendingMachine;
    private List<Product> testProducts;

    @BeforeEach
    void setUp() {
        // Initialize with test products
        testProducts = new ArrayList<>();
        testProducts.add(new Beverage(1, "Coca Cola", 20, 3, 330));
        vendingMachine = new VendingMachineImpl(testProducts);
    }

    // Test Case 1 — Insert Valid Coin
    @Test
    void testInsertValidCoin() {
        // Given: balance = 0
        assertEquals(0, vendingMachine.getBalance());

        // When: insertCoin(10)
        vendingMachine.insertCoin(10);

        // Then: balance becomes 10
        assertEquals(10, vendingMachine.getBalance());
    }

    // Test Case 2 — Reject Invalid Coin
    @Test
    void testRejectInvalidCoin() {
        // Given: balance = 0
        assertEquals(0, vendingMachine.getBalance());

        // When: insertCoin(7)
        vendingMachine.insertCoin(7);

        // Then: balance stays 0 (coin is rejected)
        assertEquals(0, vendingMachine.getBalance());
    }

    // Test Case 3 — Purchase Product Successfully
    @Test
    void testPurchaseProductSuccessfully() {
        // Given: product price = 20, product quantity = 3, balance = 0
        Product product = testProducts.get(0);
        assertEquals(20, product.getPrice());
        assertEquals(3, product.getQuantity());
        assertEquals(0, vendingMachine.getBalance());

        // When: insertCoin(20), purchaseProduct(productId)
        vendingMachine.insertCoin(20);
        Product purchased = vendingMachine.purchaseProduct(1);

        // Then: purchase succeeds (returns Product)
        assertNotNull(purchased);
        assertEquals(1, purchased.getId());
        assertEquals("Coca Cola", purchased.getName());

        // Then: balance becomes 0
        assertEquals(0, vendingMachine.getBalance());

        // Then: quantity becomes 2
        assertEquals(2, product.getQuantity());
    }

    // Test Case 4 — Purchase Fails (Insufficient Balance)
    @Test
    void testPurchaseFailsInsufficientBalance() {
        // Given: product price = 20, balance = 10
        Product product = testProducts.get(0);
        assertEquals(20, product.getPrice());
        int initialQuantity = product.getQuantity();

        vendingMachine.insertCoin(10);
        assertEquals(10, vendingMachine.getBalance());

        // When: purchaseProduct(productId)
        Product purchased = vendingMachine.purchaseProduct(1);

        // Then: purchase fails (returns null)
        assertNull(purchased);

        // Then: balance stays 10
        assertEquals(10, vendingMachine.getBalance());

        // Then: quantity unchanged
        assertEquals(initialQuantity, product.getQuantity());
    }
}