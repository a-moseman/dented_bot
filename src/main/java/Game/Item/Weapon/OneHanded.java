package Game.Item.Weapon;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;

public class OneHanded extends Weapon{
    public OneHanded(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, Ability[] abilities) {
        super(name, description, value, weight, attributeModifiers, abilities);
    }
}
