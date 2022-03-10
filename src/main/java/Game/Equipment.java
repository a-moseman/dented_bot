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
        int strengthMod = 0;
        strengthMod += helmet == null ? 0 : helmet.getStrengthMod();
        strengthMod += breastplate == null ? 0 : breastplate.getStrengthMod();
        strengthMod += gauntlets == null ? 0 : gauntlets.getStrengthMod();
        strengthMod += greaves == null ? 0 : greaves.getStrengthMod();
        strengthMod += shield == null ? 0 : shield.getStrengthMod();
        strengthMod += mainHand == null ? 0 : mainHand.getStrengthMod();
        strengthMod += offHand == null ? 0 : offHand.getStrengthMod();
        strengthMod += bothHands == null ? 0 : bothHands.getStrengthMod();
        return strengthMod;
    }

    public int getDexterityMod() {
        int dexterityMod = 0;
        dexterityMod += helmet == null ? 0 : helmet.getDexterityMod();
        dexterityMod += breastplate == null ? 0 : breastplate.getDexterityMod();
        dexterityMod += gauntlets == null ? 0 : gauntlets.getDexterityMod();
        dexterityMod += greaves == null ? 0 : greaves.getDexterityMod();
        dexterityMod += shield == null ? 0 : shield.getDexterityMod();
        dexterityMod += mainHand == null ? 0 : mainHand.getDexterityMod();
        dexterityMod += offHand == null ? 0 : offHand.getDexterityMod();
        dexterityMod += bothHands == null ? 0 : bothHands.getDexterityMod();
        return dexterityMod;
    }

    public int getConstitutionMod() {
        int constitutionMod = 0;
        constitutionMod += helmet == null ? 0 : helmet.getConstitutionMod();
        constitutionMod += breastplate == null ? 0 : breastplate.getConstitutionMod();
        constitutionMod += gauntlets == null ? 0 : gauntlets.getConstitutionMod();
        constitutionMod += greaves == null ? 0 : greaves.getConstitutionMod();
        constitutionMod += shield == null ? 0 : shield.getConstitutionMod();
        constitutionMod += mainHand == null ? 0 : mainHand.getConstitutionMod();
        constitutionMod += offHand == null ? 0 : offHand.getConstitutionMod();
        constitutionMod += bothHands == null ? 0 : bothHands.getConstitutionMod();
        return constitutionMod;
    }

    public int getIntelligenceMod() {
        int intelligenceMod = 0;
        intelligenceMod += helmet == null ? 0 : helmet.getIntelligenceMod();
        intelligenceMod += breastplate == null ? 0 : breastplate.getIntelligenceMod();
        intelligenceMod += gauntlets == null ? 0 : gauntlets.getIntelligenceMod();
        intelligenceMod += greaves == null ? 0 : greaves.getIntelligenceMod();
        intelligenceMod += shield == null ? 0 : shield.getIntelligenceMod();
        intelligenceMod += mainHand == null ? 0 : mainHand.getIntelligenceMod();
        intelligenceMod += offHand == null ? 0 : offHand.getIntelligenceMod();
        intelligenceMod += bothHands == null ? 0 : bothHands.getIntelligenceMod();
        return intelligenceMod;
    }

    public int getWisdomMod() {
        int wisdomMod = 0;
        wisdomMod += helmet == null ? 0 : helmet.getWisdomMod();
        wisdomMod += breastplate == null ? 0 : breastplate.getWisdomMod();
        wisdomMod += gauntlets == null ? 0 : gauntlets.getWisdomMod();
        wisdomMod += greaves == null ? 0 : greaves.getWisdomMod();
        wisdomMod += shield == null ? 0 : shield.getWisdomMod();
        wisdomMod += mainHand == null ? 0 : mainHand.getWisdomMod();
        wisdomMod += offHand == null ? 0 : offHand.getWisdomMod();
        wisdomMod += bothHands == null ? 0 : bothHands.getWisdomMod();
        return wisdomMod;
    }

    public int getCharismaMod() {
        int charismaMod = 0;
        charismaMod += helmet == null ? 0 : helmet.getCharismaMod();
        charismaMod += breastplate == null ? 0 : breastplate.getCharismaMod();
        charismaMod += gauntlets == null ? 0 : gauntlets.getCharismaMod();
        charismaMod += greaves == null ? 0 : greaves.getCharismaMod();
        charismaMod += shield == null ? 0 : shield.getCharismaMod();
        charismaMod += mainHand == null ? 0 : mainHand.getCharismaMod();
        charismaMod += offHand == null ? 0 : offHand.getCharismaMod();
        charismaMod += bothHands == null ? 0 : bothHands.getCharismaMod();
        return charismaMod;
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
