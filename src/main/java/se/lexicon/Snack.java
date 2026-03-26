package se.lexicon;

public class Snack extends Product {
    private final boolean isVegan;

    public Snack(int id, String name, int price, int quantity, boolean isVegan) {
        super(id, name, price, quantity);
        this.isVegan = isVegan;
    }

    @Override
    public String getDescription() {
        return String.format("[Snack] ID: %d | %s | Price: %d | Vegan: %b | Left: %d",
                getId(), getName(),getPrice(), isVegan, getQuantity());
    }
}
