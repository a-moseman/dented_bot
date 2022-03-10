package Game.Item.Armor;

import Game.Item.Equipable;

public class Armor extends Equipable {
    public Armor(String name, String description, double value, double weight, double physicalDamageMod, double magicDamageMod, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, physicalDamageMod, magicDamageMod, physicalResistanceMod, magicResistanceMod);
    }
}
