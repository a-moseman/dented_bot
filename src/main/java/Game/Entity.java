package Game;

public class Entity {
    public final String NAME;
    public final String DESCRIPTION;

    public Entity(String name, String description) {
        this.NAME = name;
        this.DESCRIPTION = description;
    }

    public String getName() {
        return NAME;
    }

    public String getDescription() {
        return DESCRIPTION;
    }
}
