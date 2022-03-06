package Game;

import Game.Item.Item;
import java.util.ArrayList;

public class Loot extends Entity{
    private ArrayList<Item> items;
    private long gold;

    public Loot(String name, String description) {
        super(name, description);
        items = new ArrayList<>();
        gold = 0;
    }

    public void addLoot(Item item) {
        items.add(item);
    }

    public void removeLoot(Item item) {
        items.remove(item);
    }

    public void addLoot(long goldAmount) {
        gold += goldAmount;
    }

    public long removeLoot(long goldAmount) {
        // TODO: test
        if (gold - goldAmount < 0) {
            goldAmount -= (gold - goldAmount);
        }
        gold -= goldAmount;
        return goldAmount;
    }
}
