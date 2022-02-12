package Game.Damage;

public class Damage {
    private final double AMOUNT;
    private final DamageType TYPE;

    public Damage(double amount, DamageType type) {
        this.AMOUNT = amount;
        this.TYPE = type;
    }

    public double getAmount() {
        return AMOUNT;
    }

    public DamageType getType() {
        return TYPE;
    }
}
