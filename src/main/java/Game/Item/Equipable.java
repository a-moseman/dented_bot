package Game.Item;

import Game.Ability.Ability;

import java.util.ArrayList;

public class Equipable extends Item {
    private AttributeModifiers ATTRIBUTE_MODIFIERS;
    private Ability[] ABILITIES;

    public Equipable(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, Ability[] abilities) {
        super(name, description, value, weight);
        this.ATTRIBUTE_MODIFIERS = attributeModifiers;
        this.ABILITIES = abilities;
    }

    public Ability[] getAbilities() {
        return ABILITIES;
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
