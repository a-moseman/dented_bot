package Game.Item.Armor;

import Game.Item.AttributeModifiers;

public class Helmet extends Armor {
    public Helmet(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, attributeModifiers, physicalResistanceMod, magicResistanceMod);
    }
}
