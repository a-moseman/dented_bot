package Game.Item.Armor;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;

import java.util.ArrayList;

public class Breastplate extends Armor {
    public Breastplate(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, ArrayList<Ability> abilities, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, attributeModifiers, abilities, physicalResistanceMod, magicResistanceMod);
    }
}
