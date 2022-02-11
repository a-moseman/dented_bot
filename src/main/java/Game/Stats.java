package Game;

public class Stats {
    private final Attributes ATTRIBUTES;

    private long level;
    private long exp;
    private long maxHealth;
    private long health;
    private long maxMana;
    private long mana;
    private long maxStamina;
    private long stamina;

    public Stats(Attributes attributes) {
        this.ATTRIBUTES = attributes;

        this.level = 1;
        this.exp = 0;
    }

    private void calculateStats() {
        // TODO: implement
    }
}
