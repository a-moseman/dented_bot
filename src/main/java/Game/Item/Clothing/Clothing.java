package Game.Item.Clothing;

import Game.Item.Equipable;

public class Clothing extends Equipable {
    public Clothing(String name, String description, double value, double weight, double physicalDamageMod, double magicDamageMod, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, physicalDamageMod, magicDamageMod, physicalResistanceMod, magicResistanceMod);
    }
}
