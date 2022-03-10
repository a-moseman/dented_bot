package Game.Item;

public class Equipable extends Item {
    private AttributeModifiers ATTRIBUTE_MODIFIERS;

    public Equipable(String name, String description, double value, double weight, AttributeModifiers attributeModifiers) {
        super(name, description, value, weight);
        this.ATTRIBUTE_MODIFIERS = attributeModifiers;
    }

    public int getStrengthMod() {
        return ATTRIBUTE_MODIFIERS.STR;
    }

    public int getDexterityMod() {
        return ATTRIBUTE_MODIFIERS.DEX;
    }

    public int getConstitutionMod() {
        return ATTRIBUTE_MODIFIERS.CON;
    }

    public int getIntelligenceMod() {
        return ATTRIBUTE_MODIFIERS.INT;
    }

    public int getWisdomMod() {
        return ATTRIBUTE_MODIFIERS.WIS;
    }

    public int getCharismaMod() {
        return ATTRIBUTE_MODIFIERS.CHA;
    }
}
