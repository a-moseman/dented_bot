package Game.Item;

public class Equipable extends Item {
    private final double PHYSICAL_DAMAGE_MOD;
    private final double MAGIC_DAMAGE_MOD;
    private final double PHYSICAL_RESISTANCE_MOD;
    private final double MAGIC_RESISTANCE_MOD;

    public Equipable(String name, String description, double value, double weight, double physicalDamageMod, double magicDamageMod, double physicalResistanceMod, double magicResistanceMod) {
        super(name, description, value, weight);
        this.PHYSICAL_DAMAGE_MOD = physicalDamageMod;
        this.MAGIC_DAMAGE_MOD = magicDamageMod;
        this.PHYSICAL_RESISTANCE_MOD = physicalResistanceMod;
        this.MAGIC_RESISTANCE_MOD = magicResistanceMod;
    }

    public double getPhysicalDamageMod() {
        return PHYSICAL_DAMAGE_MOD;
    }

    public double getMagicDamageMod() {
        return MAGIC_DAMAGE_MOD;
    }

    public double getPhysicalResistanceMod() {
        return PHYSICAL_RESISTANCE_MOD;
    }

    public double getMagicResistanceMod() {
        return MAGIC_RESISTANCE_MOD;
    }
}
