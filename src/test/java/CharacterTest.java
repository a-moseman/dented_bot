import Game.Character;
import Game.Damage.Damage;
import Game.Damage.DamageType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        // TODO: add more assert tests
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

}
