package Game.Ability;

import Game.Character;
import Game.Damage.Damage;
import Game.Damage.DamageType;
import Game.Effect.Effect;

public class AttackAbility extends Ability{
    protected AbilityScaling abilityScaling;
    protected double baseDamage;
    protected double penetration;

    public AttackAbility(String name, String description, Character user, Effect[] effects, AbilityScaling abilityScaling, double baseDamage, double penetration) {
        super(name, description, user, effects);
        this.abilityScaling = abilityScaling;
        this.baseDamage = baseDamage;
        this.penetration = penetration;
    }

    @Override
    public void activate(Character target) {
        super.activate(target);
        double dmg = baseDamage + (baseDamage * getScalingModifier());
        double dmgPen = penetration;
        Damage damage = new Damage(dmg, getDamageType(), dmgPen);
        target.hurt(damage);
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
}
