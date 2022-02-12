package Game.Damage;

public class DamageModifier {
    private final double MODIFIER;
    private final DamageAttribute ATTRIBUTE;

    public DamageModifier(double modifier, DamageAttribute attribute) {
        this.MODIFIER = modifier;
        this.ATTRIBUTE = attribute;
    }

    public double getModifier() {
        return MODIFIER;
    }

    public DamageAttribute getAttribute() {
        return ATTRIBUTE;
    }
}
