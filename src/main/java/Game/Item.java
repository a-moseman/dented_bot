package Game;

public class Item {
    private String NAME;
    private String DESCRIPTION;
    private long VALUE;

    public Item(String name, String description, long value) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.VALUE = value;
    }

    public String getName() {
        return NAME;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public long getValue() {
        return VALUE;
    }
}
