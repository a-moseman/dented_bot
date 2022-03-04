package Game;

import java.util.Hashtable;

public class GameManager {
    private Hashtable<String, Character> players;

    public GameManager() {
        this.players = new Hashtable<String, Character>();
    }

    public void addPlayer(String id, Character character) {
        players.put(id, character);
    }

    public void load() {

    }

    public void save() {

    }
}
