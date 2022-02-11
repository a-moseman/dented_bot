package Game;

public class Stats {
    private final Attributes ATTRIBUTES;

    private long level;
    private double exp;
    private double maxHealth;
    private double health;
    private double maxMana;
    private double mana;
    private double maxStamina;
    private double stamina;

    public Stats(Attributes attributes) {
        this.ATTRIBUTES = attributes;

        this.level = 1;
        this.exp = 0;
        this.calculateStats();
        this.resurrect();
    }

    public void resurrect() {
        health = maxHealth;
        mana = maxMana;
        stamina = maxStamina;
    }

    private void calculateStats() {
        // TODO: implement
        calculateMaxHealth();
        calculateMaxMana();
        calculateMaxStamina();
    }

    private void calculateMaxHealth() {
        maxHealth = ATTRIBUTES.getConstitution() * 12.5;
    }

    private void calculateMaxMana() {
        maxMana = ATTRIBUTES.getIntelligence() * 12.5;
    }

    private void calculateMaxStamina() {
        maxStamina = ATTRIBUTES.getDexterity() * 12.5;
    }
}
