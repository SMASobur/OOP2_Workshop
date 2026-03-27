package se.lexicon.model;

public class Beverage extends Product {
    private final int milliliters;

    public Beverage(int id, String name, int price, int quantity, int milliliters) {
        super(id, name, price, quantity);
        this.milliliters = milliliters;
    }

    @Override
    public String getDescription() {
        return String.format("[Beverage] ID: %d | %s (%dml) | Price: %d SEK | Stock: %d",
                getId(), getName(), milliliters, getPrice(), getQuantity());
    }
}
