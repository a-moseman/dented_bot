package Game;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private long gold;

    public Inventory() {
        this.items = new ArrayList<>();
        this.gold = 10;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void removeGold(int amount) {
        gold -= amount;
    }

    public long getGold() {
        return gold;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Gold: ").append(gold).append("\n");
        for (int i = 0; i < items.size(); i++) {
            string.append("(").append(i).append(") ").append(items.get(i).getName()).append("\n");
        }
        return string.toString();
    }
}
