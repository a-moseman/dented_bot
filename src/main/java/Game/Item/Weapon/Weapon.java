package Game.Item.Weapon;

import Game.Ability.BasicAttack;
import Game.Item.Equipable;

public class Weapon extends Equipable {
    private BasicAttack basicAttack;

    public Weapon(String name, String description, double value, double weight, double physicalDamageMod, double magicDamageMod, double physicalResistanceMod, double magicResistanceMod, BasicAttack basicAttack) {
        super(name, description, value, weight, physicalDamageMod, magicDamageMod, physicalResistanceMod, magicResistanceMod);
        this.basicAttack = basicAttack;
    }

    public BasicAttack getBasicAttack() {
        return basicAttack;
    }
}
