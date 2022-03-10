package Game.Ability;

import Game.Character;
import Game.Damage.Damage;

public class BasicAttack extends Ability{
    private double baseDamage;

    public BasicAttack(String name, String description, Character user, double baseDamage, AbilityScaling abilityScaling) {
        super(name, description, user, abilityScaling);
        this.baseDamage = baseDamage;
    }

    @Override
    public void activate(Character target) {
        super.activate(target);
        double dmg = baseDamage + (baseDamage * getScalingModifier());
        double dmgPen = 0; // TODO: implement
        Damage damage = new Damage(dmg, getDamageType(), dmgPen);
        target.hurt(damage);
    }
}
