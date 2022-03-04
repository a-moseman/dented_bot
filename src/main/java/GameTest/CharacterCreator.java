package GameTest;

public class CharacterCreator {
    private final long START_ATTRIBUTE_POINTS = 10;
    private final long MINIMUM_ATTRIBUTE_SCORE = 8;


    private String USER_ID;
    private Character character;
    private long attributePoints = START_ATTRIBUTE_POINTS;


    public CharacterCreator(String userID, String name) {
        this.USER_ID = userID;
        this.character = new Character(name);
    }

    public boolean modStrength(int dir) {
        if (dir == 1 && attributePoints > 0) {
            character.getAttributes().modStrength(dir);
            return true;
        }
        else if (dir == -1 && character.getAttributes().getStrength() > MINIMUM_ATTRIBUTE_SCORE) {
            character.getAttributes().modStrength(dir);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean modDexterity(int dir) {
        if (dir == 1 && attributePoints > 0) {
            character.getAttributes().modDexterity(dir);
            return true;
        }
        else if (dir == -1 && character.getAttributes().getDexterity() > MINIMUM_ATTRIBUTE_SCORE) {
            character.getAttributes().modDexterity(dir);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean modConstitution(int dir) {
        if (dir == 1 && attributePoints > 0) {
            character.getAttributes().modConstitution(dir);
            return true;
        }
        else if (dir == -1 && character.getAttributes().getConstitution() > MINIMUM_ATTRIBUTE_SCORE) {
            character.getAttributes().modConstitution(dir);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean modIntelligence(int dir) {
        if (dir == 1 && attributePoints > 0) {
            character.getAttributes().modIntelligence(dir);
            return true;
        }
        else if (dir == -1 && character.getAttributes().getIntelligence() > MINIMUM_ATTRIBUTE_SCORE) {
            character.getAttributes().modIntelligence(dir);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean modWisdom(int dir) {
        if (dir == 1 && attributePoints > 0) {
            character.getAttributes().modWisdom(dir);
            return true;
        }
        else if (dir == -1 && character.getAttributes().getWisdom() > MINIMUM_ATTRIBUTE_SCORE) {
            character.getAttributes().modWisdom(dir);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean modCharisma(int dir) {
        if (dir == 1 && attributePoints > 0) {
            character.getAttributes().modCharisma(dir);
            return true;
        }
        else if (dir == -1 && character.getAttributes().getCharisma() > MINIMUM_ATTRIBUTE_SCORE) {
            character.getAttributes().modCharisma(dir);
            return true;
        }
        else {
            return false;
        }
    }

    public Character get() {
        return character;
    }
}
