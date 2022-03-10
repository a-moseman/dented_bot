package Game;

import Game.Item.Armor.*;
import Game.Item.Weapon.*;

public class Equipment {
    public Helmet helmet;
    public Breastplate breastplate;
    public Gauntlets gauntlets;
    public Greaves greaves;
    public OneHanded mainHand;
    public OneHanded offHand;
    public TwoHanded bothHands; // if two handed, main and off hands must be null, and vice versa
    public Shield shield; // is treated as off hand also

    public double getPhysicalResistance() {
        double physicalResistance = 0;
        physicalResistance += helmet == null ? 0 : helmet.getPhysicalResistanceMod();
        physicalResistance += breastplate == null ? 0 : breastplate.getPhysicalResistanceMod();
        physicalResistance += gauntlets == null ? 0 : gauntlets.getPhysicalResistanceMod();
        physicalResistance += greaves == null ? 0 : greaves.getPhysicalResistanceMod();
        physicalResistance += shield == null ? 0 : shield.getPhysicalResistanceMod();
        return physicalResistance;
    }

    public double getMagicResistance() {
        double magicResistance = 0;
        magicResistance += helmet == null ? 0 : helmet.getMagicResistanceMod();
        magicResistance += breastplate == null ? 0 : breastplate.getMagicResistanceMod();
        magicResistance += gauntlets == null ? 0 : gauntlets.getMagicResistanceMod();
        magicResistance += greaves == null ? 0 : greaves.getMagicResistanceMod();
        magicResistance += shield == null ? 0 : shield.getMagicResistanceMod();
        return magicResistance;
    }

    public int getStrengthMod() {
        // TODO: implement
        return -1;
    }

    public int getDexterityMod() {
        // TODO: implement
        return -1;
    }

    public int getConstitutionMod() {
        // TODO: implement
        return -1;
    }

    public int getIntelligenceMod() {
        // TODO: implement
        return -1;
    }

    public int getWisdomMod() {
        // TODO: implement
        return -1;
    }

    public int getCharismaMod() {
        // TODO: implement
        return -1;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void setBreastplate(Breastplate breastplate) {
        this.breastplate = breastplate;
    }


    public void setGauntlets(Gauntlets gauntlets) {
        this.gauntlets = gauntlets;
    }

    public void setGreaves(Greaves greaves) {
        this.greaves = greaves;
    }

    public void setMainHand(OneHanded mainHand) {
        this.bothHands = null;
        this.mainHand = mainHand;
    }

    public void setOffHand(OneHanded offHand) {
        this.bothHands = null;
        this.shield = null;
        this.offHand = offHand;
    }

    public void setOffHand(Shield shield) {
        this.bothHands = null;
        this.offHand = null;
        this.shield = shield;
    }

    public void setBothHands(TwoHanded bothHands) {
        this.mainHand = null;
        this.offHand = null;
        this.shield = null;
        this.bothHands = bothHands;
    }
}
