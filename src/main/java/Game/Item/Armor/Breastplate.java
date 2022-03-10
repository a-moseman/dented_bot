package Game.Item.Armor;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;

public class Breastplate extends Armor {
    public Breastplate(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, Ability[] abilities, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, attributeModifiers, abilities, physicalResistanceMod, magicResistanceMod);
    }
}
