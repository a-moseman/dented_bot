package Game;

public class Character {
    private final String NAME;
    private final Attributes ATTRIBUTES;
    private final Stats STATS;
    private final Equipment EQUIPMENT;
    private final Inventory INVENTORY;

    public Character(String name) {
        this.NAME = name;
        this.ATTRIBUTES = new Attributes();
        this.STATS = new Stats(this.ATTRIBUTES);
        this.EQUIPMENT = new Equipment();
        this.INVENTORY = new Inventory();
    }

    public String getName() {
        return NAME;
    }

    public Attributes getAttributes() {
        return ATTRIBUTES;
    }

    public Stats getStats() {
        return STATS;
    }

    public Equipment getEquipment() {
        return EQUIPMENT;
    }

    public Inventory getInventory() {
        return INVENTORY;
    }
}
