package Game.Effect;

import Game.Character;
import Game.Entity;

public class Effect extends Entity {
    private long tickDuration; //value of -1 implies infinite duration

    public Effect(String name, String description, long tickDuration) {
        super(name, description);
        this.tickDuration = tickDuration;
    }

    public void apply(Character character) {
        if (tickDuration > 0) {
            tickDuration--;
        }
    }

    public boolean hasExpired() {
        return tickDuration == 0;
    }
}
