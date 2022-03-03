package Game;

import Game.Item.Armor.*;
import Game.Item.Clothing.*;
import Game.Item.Weapon.*;

public class Equipment {
    public Helmet helmet;
    public Breastplate breastplate;
    public Gauntlets gauntlets;
    public Greaves greaves;
    public Shirt shirt;
    public Pants pants;
    public Shoes shoes;
    public OneHanded mainHand;
    public OneHanded offHand;
    public TwoHanded bothHands; // if two handed, main and off hands must be null, and vice versa

    public double getPhysicalResistance() {
        double physicalResistance = 0;
        physicalResistance += helmet.getPhysicalResistanceMod();
        physicalResistance += breastplate.getPhysicalResistanceMod();
        physicalResistance += gauntlets.getPhysicalResistanceMod();
        physicalResistance += greaves.getPhysicalResistanceMod();
        physicalResistance += shirt.getPhysicalResistanceMod();
        physicalResistance += pants.getPhysicalResistanceMod();
        physicalResistance += shoes.getPhysicalResistanceMod();
        if (bothHands == null) {
            physicalResistance += mainHand.getPhysicalResistanceMod();
            physicalResistance += offHand.getPhysicalResistanceMod();
        }
        else {
            physicalResistance += bothHands.getPhysicalResistanceMod();
        }
        return physicalResistance;
    }

    public double getMagicResistance() {
        double magicResistance = 0;
        magicResistance += helmet.getMagicResistanceMod();
        magicResistance += breastplate.getMagicResistanceMod();
        magicResistance += gauntlets.getMagicResistanceMod();
        magicResistance += greaves.getMagicResistanceMod();
        magicResistance += shirt.getMagicResistanceMod();
        magicResistance += pants.getMagicResistanceMod();
        magicResistance += shoes.getMagicResistanceMod();
        if (bothHands == null) {
            magicResistance += mainHand.getMagicResistanceMod();
            magicResistance += offHand.getMagicResistanceMod();
        }
        else {
            magicResistance += bothHands.getMagicResistanceMod();
        }
        return magicResistance;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public Breastplate getBreastplate() {
        return breastplate;
    }

    public void setBreastplate(Breastplate breastplate) {
        this.breastplate = breastplate;
    }

    public Gauntlets getGauntlets() {
        return gauntlets;
    }

    public void setGauntlets(Gauntlets gauntlets) {
        this.gauntlets = gauntlets;
    }

    public Greaves getGreaves() {
        return greaves;
    }

    public void setGreaves(Greaves greaves) {
        this.greaves = greaves;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public void setShirt(Shirt shirt) {
        this.shirt = shirt;
    }

    public Pants getPants() {
        return pants;
    }

    public void setPants(Pants pants) {
        this.pants = pants;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public OneHanded getMainHand() {
        return mainHand;
    }

    public void setMainHand(OneHanded mainHand) {
        this.mainHand = mainHand;
        this.bothHands = null;
    }

    public OneHanded getOffHand() {
        return offHand;
    }

    public void setOffHand(OneHanded offHand) {
        this.offHand = offHand;
        this.bothHands = null;
    }

    public TwoHanded getBothHands() {
        return bothHands;
    }

    public void setBothHands(TwoHanded bothHands) {
        this.bothHands = bothHands;
        this.mainHand = null;
        this.offHand = null;
    }
}
