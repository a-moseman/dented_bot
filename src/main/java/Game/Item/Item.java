package Game.Item;

import Game.Entity;

public class Item extends Entity {
    private double VALUE;
    private double WEIGHT;

    public Item(String name, String description, double value, double weight) {
        super(name, description);
        this.VALUE = value;
        this.WEIGHT = weight;
    }

    public double getValue() {
        return VALUE;
    }

    public double getWeight() {
        return WEIGHT;
    }
}
