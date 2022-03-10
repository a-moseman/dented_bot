package Game.Ability;

import Game.Character;
import Game.Effect.Effect;
import Game.Entity;

public class Ability extends Entity {
    protected Character user;
    protected Effect[] effects;

    public Ability(String name, String description, Character user, Effect[] effects) {
        super(name, description);
        this.user = user;
        this.effects = effects;
    }

    public void activate(Character target) {
        for (Effect effect : effects) {
            target.giveEffect(effect);
        }
    }
}
