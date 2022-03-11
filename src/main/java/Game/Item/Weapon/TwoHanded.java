package Game.Item.Weapon;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;

import java.util.ArrayList;

public class TwoHanded extends Weapon{
    public TwoHanded(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, ArrayList<Ability> abilities) {
        super(name, description, value, weight, attributeModifiers, abilities);
    }
}
