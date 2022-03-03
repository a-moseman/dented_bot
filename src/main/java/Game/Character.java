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

    private double physicalResistancePercent;
    private double magicResistancePercent;

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

    private void calculateMaxHealth() {
        maxHealth = ATTRIBUTES.getConstitution() * 12.5;
    }

    private void calculateMaxMana() {
        maxMana = ATTRIBUTES.getIntelligence() * 12.5;
    }

    private void calculateMaxStamina() {
        maxStamina = ATTRIBUTES.getDexterity() * 12.5;
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

    public void updateEffects() {
        for (Effect effect : effects) {
            effect.apply(this);
        }
        removeExpiredEffects();
    }

    private void removeExpiredEffects() {
        // TODO: test
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
        //TODO: Implement damage penetration
        switch (damage.getType()) {
            case PHYSICAL:
                health -= damage.getAmount() * (1 - physicalResistancePercent);
                break;
            case MAGIC:
                health -= damage.getAmount() * (1 - magicResistancePercent);
                break;
            case TRUE:
                health -= damage.getAmount();
                break;
        }
        if (health <= 0) {
            isAlive = false;
        }
    }
}
