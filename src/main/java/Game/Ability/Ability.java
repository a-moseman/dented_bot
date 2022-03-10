package Game.Ability;

import Game.Character;
import Game.Entity;

public class Ability extends Entity {
    protected Character user;

    public Ability(String name, String description, Character user) {
        super(name, description);
        this.user = user;
    }

    /**
     * Override in subclasses
     */
    public void activate(Character target) {

    }
}
