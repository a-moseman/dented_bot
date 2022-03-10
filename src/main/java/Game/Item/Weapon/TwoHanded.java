package Game.Item.Weapon;

import Game.Ability.BasicAttack;
import Game.Item.AttributeModifiers;

public class TwoHanded extends Weapon{
    public TwoHanded(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, BasicAttack basicAttack) {
        super(name, description, value, weight, attributeModifiers, basicAttack);
    }
}
