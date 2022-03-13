import Game.Character;
import Game.Damage.Damage;
import Game.Damage.DamageType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Game.Effect.Poison;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class CharacterTest {
    private static Character character;

    @BeforeAll
    public static void setUp() {
        character = new Character("Test");
    }

    @Test
    public void testCharacter() {
        assertNotNull(character);
    }


    @Test
    public void testInstantiateCharacter() {
        assertEquals(100, character.getHealth(), 0);
    }

    @Test
    public void testHurt() {
        character.hurt(new Damage(50, DamageType.TRUE, 0));
        assertEquals(50, character.getHealth(), 0);
    }

    @Test
    public void testHurtWithPenetration() {
        character.hurt(new Damage(25, DamageType.PHYSICAL, 0.5));
        assertEquals(25, character.getHealth(), 0);
    }

    @Test
    public void testHeal() {
        character.heal(100);
        assertEquals(100, character.getHealth(), 0);
    }

    @Test
    public void testGainExp() {
        character.gainExp(0);
        assertEquals(1, character.getLevel());
        character.gainExp(100);
        assertEquals(1, character.getLevel());
        character.gainExp(50);
        assertEquals(1, character.getLevel());
        character.gainExp(50);
        assertEquals(2, character.getLevel());
    }

    @Test
    public void testPoison() {
        character.heal(100); // reset health
        character.giveEffect(new Poison("name", "desc", 3, new Damage(10, DamageType.TRUE, 0)));
        character.updateEffects();
        assertEquals(90, character.getHealth(), 0);
        character.updateEffects();
        assertEquals(80, character.getHealth(), 0);
        character.updateEffects();
        assertEquals(70, character.getHealth(), 0);
        character.updateEffects(); // check if effect removed
        assertEquals(70, character.getHealth(), 0);
    }

}
