package GameTest.Effect;

import GameTest.Character;
import GameTest.Damage.Damage;

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
