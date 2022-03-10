package Game.Item.Armor;

import Game.Item.AttributeModifiers;

public class Shield extends Armor{
    public Shield(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, attributeModifiers, physicalResistanceMod, magicResistanceMod);
    }
}
