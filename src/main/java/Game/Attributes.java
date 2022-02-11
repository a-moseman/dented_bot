package Game;

public class Attributes {
    private long strength;
    private long constitution;
    private long dexterity;
    private long intelligence;
    private long wisdom;
    private long charisma;

    public Attributes() {
        this.strength = 8;
        this.constitution = 8;
        this.dexterity = 8;
        this.intelligence = 8;
        this.wisdom = 8;
        this.charisma = 8;
    }

    public long getStrength() {
        return strength;
    }

    public long getConstitution() {
        return constitution;
    }

    public long getDexterity() {
        return dexterity;
    }

    public long getIntelligence() {
        return intelligence;
    }

    public long getWisdom() {
        return wisdom;
    }

    public long getCharisma() {
        return charisma;
    }
}
