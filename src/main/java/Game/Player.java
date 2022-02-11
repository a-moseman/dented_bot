package Game;

public class Player {
    private final String NAME;
    private final Attributes ATTRIBUTES;
    private final Stats STATS;
    private final Equipment EQUIPMENT;
    private final Inventory INVENTORY;

    public Player(String name) {
        this.NAME = name;
        this.ATTRIBUTES = new Attributes();
        this.STATS = new Stats(this.ATTRIBUTES);
        this.EQUIPMENT = new Equipment();
        this.INVENTORY = new Inventory();
    }
}
