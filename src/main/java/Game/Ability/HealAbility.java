package Game.Ability;

import Game.Character;
import Game.Effect.Effect;

public class HealAbility extends Ability{
    protected AbilityScaling abilityScaling;
    protected double baseHealing;

    public HealAbility(String name, String description, Character user, Effect[] effects, AbilityScaling abilityScaling, double baseHealing) {
        super(name, description, user, effects);
        this.abilityScaling = abilityScaling;
        this.baseHealing = baseHealing;
    }

    @Override
    public void activate(Character target) {
        super.activate(target);
        double healing = baseHealing + (baseHealing * getScalingModifier());
        target.heal(healing);
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
