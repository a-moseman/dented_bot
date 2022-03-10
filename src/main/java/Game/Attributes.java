package Game;

public class Attributes {
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Attributes() {
        this.strength = 8;
        this.constitution = 8;
        this.dexterity = 8;
        this.intelligence = 8;
        this.wisdom = 8;
        this.charisma = 8;
    }

    private double convertAttributeToModifier(int attribute) {
        return ((double) attribute - 10) / 10;
    }

    public double getStrengthScalingMod() {
        return convertAttributeToModifier(strength);
    }

    public double getDexterityScalingMod() {
        return convertAttributeToModifier(dexterity);
    }

    public double getConstitutionScalingMod() {
        return convertAttributeToModifier(constitution);
    }

    public double getIntelligenceScalingMod() {
        return convertAttributeToModifier(intelligence);
    }

    public double getWisdomScalingMod() {
        return convertAttributeToModifier(wisdom);
    }

    public double getCharismaScalingMod() {
        return convertAttributeToModifier(charisma);
    }

    public int getStrength() {
        return strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void modStrength(int amount) {
        strength += amount;
    }

    public void modConstitution(int amount) {
        constitution += amount;
    }

    public void modDexterity(int amount) {
        dexterity += amount;
    }

    public void modIntelligence(int amount) {
        intelligence += amount;
    }

    public void modWisdom(int amount) {
        wisdom += amount;
    }

    public void modCharisma(int amount) {
        charisma += amount;
    }
}
