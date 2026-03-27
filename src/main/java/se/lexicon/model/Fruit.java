package se.lexicon.model;

public class Fruit extends Product{
    private final boolean isOrganic;

    public Fruit(int id, String name, int price, int quantity, boolean isOrganic) {
        super(id, name, price, quantity);
        this.isOrganic = isOrganic;

    }

    @Override
    public String getDescription() {
        return String.format("[Fruit] ID: %d | %s | Price: %d SEK | Organic: %b | Stock: %d",
                getId(), getName(), getPrice(), isOrganic, getQuantity());
    }
}
