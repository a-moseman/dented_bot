package Game.Item.Weapon;

import Game.Ability.BasicAttack;
import Game.Item.AttributeModifiers;
import Game.Item.Equipable;

public class Weapon extends Equipable {
    private BasicAttack basicAttack;

    public Weapon(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, BasicAttack basicAttack) {
        super(name, description, value, weight, attributeModifiers);
        this.basicAttack = basicAttack;
    }

    public BasicAttack getBasicAttack() {
        return basicAttack;
    }
}
