package Game.Resistance;

public class ResistanceModifier {
    private final double MODIFIER;
    private final ResistanceAttribute ATTRIBUTE;

    public ResistanceModifier(double modifier, ResistanceAttribute attribute) {
        this.MODIFIER = modifier;
        this.ATTRIBUTE = attribute;
    }

    public double getModifier() {
        return MODIFIER;
    }

    public ResistanceAttribute getAttribute() {
        return ATTRIBUTE;
    }
}
