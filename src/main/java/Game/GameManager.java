package Game;

import java.util.Hashtable;

public class GameManager {
    private Hashtable<String, Character> players;
    private Location rootLocation;

    public GameManager() {
        this.players = new Hashtable<String, Character>();
        this.rootLocation = new Location("root", "The root location");
    }

    public void addPlayer(String id, Character character) {
        players.put(id, character);
    }

    public void load() {

    }

    public void save() {

    }
}
