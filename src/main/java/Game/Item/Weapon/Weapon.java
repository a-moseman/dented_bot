package Game.Item.Weapon;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;
import Game.Item.Equipable;

import java.util.ArrayList;

public class Weapon extends Equipable {

    public Weapon(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, ArrayList<Ability> abilities) {
        super(name, description, value, weight, attributeModifiers, abilities);
    }
}
