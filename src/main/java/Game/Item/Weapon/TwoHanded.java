package Game.Item.Weapon;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;

public class TwoHanded extends Weapon{
    public TwoHanded(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, Ability[] abilities) {
        super(name, description, value, weight, attributeModifiers, abilities);
    }
}
