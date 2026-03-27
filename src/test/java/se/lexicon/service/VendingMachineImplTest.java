package se.lexicon.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {

    private IVendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        // Initialize with empty product list for basic tests
        List<Product> testProducts = new ArrayList<>();
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
}