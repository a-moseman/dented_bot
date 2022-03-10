package Game;

import Game.Damage.Damage;
import Game.Effect.Effect;

import java.util.ArrayList;

public class Character {
    private final String NAME;
    private final Attributes ATTRIBUTES;
    private final Equipment EQUIPMENT;
    private final Inventory INVENTORY;

    private ArrayList<Effect> effects;

    private long level;
    private double exp;
    private double maxHealth;
    private double health;
    private double maxMana;
    private double mana;
    private double maxStamina;
    private double stamina;

    private boolean isAlive;

    public Character(String name) {
        this.NAME = name;
        this.ATTRIBUTES = new Attributes();
        this.EQUIPMENT = new Equipment();
        this.INVENTORY = new Inventory();

        this.effects = new ArrayList<>();

        this.level = 1;
        this.exp = 0;
        this.calculateStats();
        this.resurrect();
    }

    public void resurrect() {
        health = maxHealth;
        mana = maxMana;
        stamina = maxStamina;
        isAlive = true;
    }

    private void calculateStats() {
        // TODO: implement
        calculateMaxHealth();
        calculateMaxMana();
        calculateMaxStamina();
    }

    private void calculateLevel() {
        level = (long) Math.max(1, (Math.log(exp / 100) / Math.log(2) + 1));
    }

    public void gainExp(double amount) {
        exp += amount;
        calculateLevel();
    }

    private void calculateMaxHealth() {
        maxHealth = ATTRIBUTES.getConstitution() * 12.5;
    }

    private void calculateMaxMana() {
        maxMana = ATTRIBUTES.getIntelligence() * 12.5;
    }

    private void calculateMaxStamina() {
        maxStamina = ATTRIBUTES.getDexterity() * 12.5;
    }

    public void updateEffects() {
        for (Effect effect : effects) {
            effect.apply(this);
        }
        removeExpiredEffects();
    }

    private void removeExpiredEffects() {
        int i = 0;
        while (i < effects.size()) {
            if (effects.get(i).hasExpired()) {
                effects.remove(i);
            }
            else {
                i++;
            }
        }
    }

    public void hurt(Damage damage) {
        switch (damage.getType()) {
            case PHYSICAL:
                health -= damage.getAmount() * Math.min(1 - EQUIPMENT.getPhysicalResistance() + damage.getPenetration(), 1);
                break;
            case MAGIC:
                health -= damage.getAmount() * Math.min(1 - EQUIPMENT.getMagicResistance() + damage.getPenetration(), 1);
                break;
            case TRUE:
                health -= damage.getAmount();
                break;
        }
        if (health <= 0) {
            isAlive = false;
        }
    }

    public void heal(double amount) {
        if (isAlive) {
            health = Math.min(health + amount, maxHealth);
        }
    }

    public void giveEffect(Effect effect) {
        effects.add(effect);
    }

    private double convertAttributeToModifier(int attribute) {
        return ((double) attribute - 10) / 10;
    }

    public double getStrengthScalingMod() {
        return convertAttributeToModifier(getEffectiveStrength());
    }

    public double getDexterityScalingMod() {
        return convertAttributeToModifier(getEffectiveDexterity());
    }

    public double getConstitutionScalingMod() {
        return convertAttributeToModifier(getEffectiveConstitution());
    }

    public double getIntelligenceScalingMod() {
        return convertAttributeToModifier(getEffectiveIntelligence());
    }

    public double getWisdomScalingMod() {
        return convertAttributeToModifier(getEffectiveWisdom());
    }

    public double getCharismaScalingMod() {
        return convertAttributeToModifier(getEffectiveCharisma());
    }

    public int getEffectiveStrength() {
        return EQUIPMENT.getStrengthMod() + ATTRIBUTES.getStrength();
    }

    public int getEffectiveDexterity() {
        return EQUIPMENT.getDexterityMod() + ATTRIBUTES.getDexterity();
    }

    public int getEffectiveConstitution() {
        return EQUIPMENT.getConstitutionMod() + ATTRIBUTES.getConstitution();
    }

    public int getEffectiveIntelligence() {
        return EQUIPMENT.getIntelligenceMod() + ATTRIBUTES.getIntelligence();
    }

    public int getEffectiveWisdom() {
        return EQUIPMENT.getWisdomMod() + ATTRIBUTES.getWisdom();
    }

    public int getEffectiveCharisma() {
        return EQUIPMENT.getCharismaMod() + ATTRIBUTES.getCharisma();
    }

    //---Getter Methods---\\

    public double getHealth() {
        return health;
    }

    public String getName() {
        return NAME;
    }

    public Attributes getAttributes() {
        return ATTRIBUTES;
    }

    public Equipment getEquipment() {
        return EQUIPMENT;
    }

    public Inventory getInventory() {
        return INVENTORY;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public long getLevel() {
        return level;
    }

    public double getExp() {
        return exp;
    }
}
