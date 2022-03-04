package Game;

import java.util.ArrayList;

public class Location extends Entity{
    private ArrayList<Character> characters;
    private ArrayList<Location> locations;

    public Location(String name, String description) {
        super(name, description);
        characters = new ArrayList<>();
        locations = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public Location getLocation(int index) {
        return locations.get(index);
    }

    public Character getRandomEnemy() {
        // TODO: implement
        return null;
    }


}
