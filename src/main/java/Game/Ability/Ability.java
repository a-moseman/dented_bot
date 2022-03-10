package Game.Ability;

import Game.Character;
import Game.Damage.DamageType;
import Game.Entity;

public class Ability extends Entity {
    private Character user;
    private AbilityScaling abilityScaling;

    public Ability(String name, String description, Character user, AbilityScaling abilityScaling) {
        super(name, description);
        this.user = user;
        this.abilityScaling = abilityScaling;
    }

    protected DamageType getDamageType() {
        switch (abilityScaling) {
            case STRENGTH:
            case DEXTERITY:
            case CONSTITUTION:
                return DamageType.PHYSICAL;
            case INTELLIGENCE:
            case WISDOM:
            case CHARISMA:
                return DamageType.MAGIC;
            default:
                return DamageType.TRUE; // true damage if no ability scaling? TODO: figure out how to flag as true damage
        }
    }

    protected double getScalingModifier() {
        switch (abilityScaling) {
            case STRENGTH:
                return user.getStrengthScalingMod();
            case DEXTERITY:
                return user.getDexterityScalingMod();
            case CONSTITUTION:
                return user.getConstitutionScalingMod();
            case INTELLIGENCE:
                return user.getIntelligenceScalingMod();
            case WISDOM:
                return user.getWisdomScalingMod();
            case CHARISMA:
                return user.getCharismaScalingMod();
            default:
                return 0;
        }
    }

    /**
     * Override in subclasses
     */
    public void activate(Character target) {

    }
}
