package Game.Item.Weapon;

import Game.Ability.AttackAbility;
import Game.Item.AttributeModifiers;

public class TwoHanded extends Weapon{
    public TwoHanded(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, AttackAbility attackAbility) {
        super(name, description, value, weight, attributeModifiers, attackAbility);
    }
}
