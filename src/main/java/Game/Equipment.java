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

    public Equipment() {

    }
}
