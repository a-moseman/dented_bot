package Game.Item.Weapon;

import Game.Ability.AttackAbility;
import Game.Item.AttributeModifiers;
import Game.Item.Equipable;

public class Weapon extends Equipable {
    private AttackAbility attackAbility;

    public Weapon(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, AttackAbility attackAbility) {
        super(name, description, value, weight, attributeModifiers);
        this.attackAbility = attackAbility;
    }

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }
}
