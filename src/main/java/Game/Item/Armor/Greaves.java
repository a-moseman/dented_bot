package Game.Item.Armor;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;

public class Greaves extends Armor {
    public Greaves(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, Ability[] abilities, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, attributeModifiers, abilities, physicalResistanceMod, magicResistanceMod);
    }
}
