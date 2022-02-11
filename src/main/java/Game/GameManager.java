package Game;

import java.util.Hashtable;

public class GameManager {
    private Hashtable<String, Player> players;

    public GameManager() {
        this.players = new Hashtable<String, Player>();
    }

    public void addPlayer(String id, Player player) {
        players.put(id, player);
    }

    public void load() {

    }

    public void save() {

    }
}
