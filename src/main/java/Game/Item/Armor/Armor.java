package Game.Item.Armor;

import Game.Ability.Ability;
import Game.Item.AttributeModifiers;
import Game.Item.Equipable;

import java.util.ArrayList;

public class Armor extends Equipable {
    private double physicalResistanceMod;
    private double magicResistanceMod;

    public Armor(String name, String description, double value, double weight, AttributeModifiers attributeModifiers, ArrayList<Ability> abilities, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight, attributeModifiers, abilities);
        this.physicalResistanceMod = physicalResistanceMod;
        this.magicResistanceMod = magicResistanceMod;
    }

    public double getPhysicalResistanceMod() {
        return physicalResistanceMod;
    }

    public double getMagicResistanceMod() {
        return magicResistanceMod;
    }
}
