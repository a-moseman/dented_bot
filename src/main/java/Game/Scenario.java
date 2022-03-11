package Game;

import java.util.ArrayList;

public class Scenario {
    private Character player;
    private ArrayList<Character> npcs;
    private ArrayList<Character> turnOrder;
    private int turn;

    public Scenario(Character player, ArrayList<Character> npcs) {
        this.player = player;
        this.npcs = npcs;
        this.turnOrder = this.determineTurnOrder();
        this.turn = 0;

    }

    private ArrayList<> determineTurnOrder() {
        ArrayList<Character> tempArray = new ArrayList<>(npcs);
        tempArray.add(player);

        while (tempArray.size() > 0) {
            // determine current highest dex
            Character highestDex = tempArray.get(0);
            for (Character character : tempArray) {
                if (character.getEffectiveDexterity() > highestDex.getEffectiveDexterity()) {
                    highestDex = character;
                }
            }
            // remove highest dex from temp list and add to turn order
            tempArray.remove(highestDex);
            turnOrder.add(highestDex);
        }
        return turnOrder;
    }

    public Character getCurrentCharacter() {
        return turnOrder.get(turn);
    }
}
