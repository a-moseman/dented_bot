package Game.Effect;

import Game.Character;
import Game.Damage.Damage;

public class Poison extends Effect{
    private final Damage DAMAGE;

    public Poison(String name, String description, long tickDuration, Damage damage) {
        super(name, description, tickDuration);
        this.DAMAGE = damage;
    }

    @Override
    public void apply(Character character) {
        super.apply(character);
        character.hurt(DAMAGE);
    }
}
