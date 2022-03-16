package Game.Loading;

import Game.Ability.Ability;
import Game.Item.Armor.*;
import Game.Item.AttributeModifiers;
import Game.Item.Item;
import Game.Item.Weapon.Weapon;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class ItemLoader{
    private Random RANDOM;

    private Loader weaponLoader;
    private Loader armorLoader;

    private ArrayList<Item> items;
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;

    public ItemLoader() {
        this.RANDOM = new Random();
        this.weaponLoader = new Loader("weapon.json");
        this.armorLoader = new Loader("armor.json");
    }

    public void load() {
        JSONArray weaponJson = new JSONArray(weaponLoader.load());
        JSONArray armorJson = new JSONArray(armorLoader.load());

        for (int i = 0; i < armorJson.length(); i++) {
            Armor armor = buildArmor((JSONObject) armorJson.get(i));
            armors.add(armor);
            items.add(armor);
        }

        for (int i = 0; i < weaponJson.length(); i++) {
            // TODO: implement
        }

        // TODO: sort lists by item name for searching later
    }

    private Armor buildArmor(JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        String description = (String) jsonObject.get("description");
        double value = (double) jsonObject.get("value");
        double weight = (double) jsonObject.get("weight");
        AttributeModifiers attributeModifiers = pullAttributeModifiers((JSONObject) jsonObject.get("attribute_modifiers"));
        ArrayList<Ability> abilities = null; // TODO: implement (must have already loaded abilities)
        double physResistMod = (double) jsonObject.get("physical_resistance_modifier");
        double magResistMod = (double) jsonObject.get("magic_resistance_modifier");
        String type = (String) jsonObject.get("type");
        switch (type) {
            case "breastplate":
                return new Breastplate(name, description, value, weight, attributeModifiers, abilities, physResistMod, magResistMod);
            case "gauntlets":
                return new Gauntlets(name, description, value, weight, attributeModifiers, abilities, physResistMod, magResistMod);
            case "greaves":
                return new Greaves(name, description, value, weight, attributeModifiers, abilities, physResistMod, magResistMod);
            case "helmet":
                return new Helmet(name, description, value, weight, attributeModifiers, abilities, physResistMod, magResistMod);
            case "shield":
                return new Shield(name, description, value, weight, attributeModifiers, abilities, physResistMod, magResistMod);
            case "none":
                return new Armor(name, description, value, weight, attributeModifiers, abilities, physResistMod, magResistMod);
            default:
                return null; // only occurs if no type attribute specified
        }
    }

    private Weapon buildWeapon(JSONObject jsonObject) {
        // TODO: implement
    }

    private AttributeModifiers pullAttributeModifiers(JSONObject jsonObject) {
        int strength = (int) jsonObject.get("str");
        int dexterity = (int) jsonObject.get("str");
        int constitution = (int) jsonObject.get("str");
        int intelligence = (int) jsonObject.get("str");
        int wisdom = (int) jsonObject.get("str");
        int charisma = (int) jsonObject.get("str");
        return new AttributeModifiers(
                strength,
                dexterity,
                constitution,
                intelligence,
                wisdom,
                charisma
        );
    }

    private Item binarySearchItem(ArrayList<Item> list, int lowerBound, int upperBound, String name) {
        // TODO: test functionality
        int mid;
        if (upperBound >= lowerBound) {
            mid = (lowerBound + upperBound) / 2;
            if (list.get(mid).getName().equals(name)) {
                return list.get(mid);
            }
            else if (list.get(mid).getName().compareTo(name) < 0) {
                return binarySearchItem(list, mid + 1, upperBound, name);
            }
            else {
                return binarySearchItem(list, lowerBound, mid - 1, name);
            }
        }
        return null;
    }

    //---Getter Methods---\\

    public Weapon getWeapon(int index) {
        return weapons.get(index);
    }

    public Weapon getWeapon(String name) {
        // TODO: implement binary search tree
        return null;
    }

    public Weapon getWeapon() {
        return weapons.get(RANDOM.nextInt(weapons.size()));
    }

    public Armor getArmor(int index) {
        return armors.get(index);
    }

    public Armor getArmor(String name) {
        // TODO: implement binary search tree
        return null;
    }

    public Armor getArmor() {
        return armors.get(RANDOM.nextInt(armors.size()));
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public Item getItem(String name) {
        return binarySearchItem(items, 0, items.size(), name);
    }

    public Item getItem() {
        return items.get(RANDOM.nextInt(items.size()));
    }
}
