package Game;

import Game.Item.Equipable;

// TODO: make it specific slot based
public class Equipment {
    private Equipable[] items;

    public Equipment() {
        this.items = new Equipable[6];
    }

    public void setItem(int index, Equipable item) {
        items[index] = item;
    }

    public void removeItem(int index) {
        items[index] = null;
    }

    public Equipable getItem(int index) {
        return items[index];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            string.append("(").append(i).append(") ").append(items[i].getName()).append("\n");
        }
        return string.toString();
    }
}
