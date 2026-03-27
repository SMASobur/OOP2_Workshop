package se.lexicon.model;

public class Beverage extends Product {

    public Beverage(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getDescription() {
        return String.format("[Snack] ID: %d | %s | Price: %d | Left: %d",
                getId(), getName(),getPrice(), getQuantity());
    }
}
