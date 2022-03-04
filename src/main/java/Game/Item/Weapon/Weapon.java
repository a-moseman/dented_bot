package Game.Item.Weapon;

import Game.Item.Equipable;

public class Weapon extends Equipable {
    public Weapon(String name, String description, double value, double weight, double physicalDamageMod, double magicDamageMod, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, physicalDamageMod, magicDamageMod, physicalResistanceMod, magicResistanceMod);
    }
}
