package se.lexicon.service;

import se.lexicon.model.Product;

import java.util.List;

// Fields
public class VendingMachineImpl implements IVendingMachine {
    private int balance;
    private List<Product> products;
    private final int[] validCoins = {1, 2, 5, 10, 20, 50};

    // Constructor
    public VendingMachineImpl(List<Product> initialProducts) {
        this.products = initialProducts;
        this.balance = 0;
    }

    // All interfaces are overridden below.
    @Override
    public void insertCoin(int coin) {
        boolean valid = false;
        for (int c : validCoins) {
            if (c == coin) { valid = true; break; }
        }
        if (valid) {
            balance += coin;
        } else {
            System.out.println("Rejected: " + coin + " is not a valid coin.");
        }
    }

    @Override
    public int getBalance() { return balance; }

    @Override
    public Product purchaseProduct(int productId) {
        for (Product p : products) {
            if (p.getId() == productId) {
                if (p.getQuantity() > 0 && balance >= p.getPrice()) {
                    balance -= p.getPrice();
                    p.reduceQuantity();
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }



    @Override
    public List<Product> getProducts() { return products; }
}
