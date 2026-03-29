package se.lexicon.model;

public class Snack extends Product {
    private final boolean isVegan;

    public Snack(int id, String name, int price, int quantity, boolean isVegan) {
        super(id, name, price, quantity);
        this.isVegan = isVegan;
    }

    @Override
    public String getDescription() {
        return String.format("[Snack] ID: %d | %s | Price: %d | Vegan: %b | Stock: %d",
                getId(), getName(),getPrice(), isVegan, getQuantity());
    }
}
