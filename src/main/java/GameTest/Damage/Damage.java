package GameTest.Damage;

public class Damage {
    private final double AMOUNT;
    private final DamageType TYPE;
    private final double PENETRATION;

    public Damage(double amount, DamageType type, double penetration) {
        this.AMOUNT = amount;
        this.TYPE = type;
        this.PENETRATION = penetration;
    }

    public double getAmount() {
        return AMOUNT;
    }

    public DamageType getType() {
        return TYPE;
    }

    public double getPenetration() {
        return PENETRATION;
    }
}
