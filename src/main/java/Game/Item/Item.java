package Game.Item;

public class Item {
    private String NAME;
    private String DESCRIPTION;
    private double VALUE;
    private double WEIGHT;

    public Item(String name, String description, double value, double weight) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.VALUE = value;
        this.WEIGHT = weight;
    }

    public String getName() {
        return NAME;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public double getValue() {
        return VALUE;
    }

    public double getWeight() {
        return WEIGHT;
    }
}
