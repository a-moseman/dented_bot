import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Hashtable;

public class FileManager {
    private static final String USER_DATA_PATH = "users.json";

    public static Hashtable<String, User> loadUserData() {
        Hashtable<String, User> users = new Hashtable<>();
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(USER_DATA_PATH));
            for (Object keyObject : jsonObject.keySet()) {
                String key = (String) keyObject;
                User user = convertJsonToUser((JSONObject) jsonObject.get(key));
                users.put(key, user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    private static User convertJsonToUser(JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        String discriminator = (String) jsonObject.get("discriminator");
        String id = (String) jsonObject.get("id");
        String uuid = (String) jsonObject.get("uuid");
        long firstSeen = (long) jsonObject.get("first_seen");
        long age = (long) jsonObject.get("age");
        long activity = (long) jsonObject.get("activity");
        long lastActivityTime = (long) jsonObject.get("last_activity_time");
        double exp = (double) jsonObject.get("exp");
        long level = (long) jsonObject.get("level");
        double presence = (double) jsonObject.get("presence");
        User user = new User(
                name,
                discriminator,
                id,
                uuid,
                firstSeen,
                age,
                lastActivityTime,
                exp,
                level,
                presence
        );
        return user;
    }

    public static void saveUserData(Hashtable<String, User> users) {
        try {
            JSONObject json = new JSONObject();

            for (String key : users.keySet()) {
                User user = users.get(key);
                JSONObject userJson = convertUserToJson(user);
                json.put(key, userJson);
            }

            FileWriter fileWriter = new FileWriter(USER_DATA_PATH);
            fileWriter.write(json.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject convertUserToJson(User user) {
        String name = user.getName();
        String discriminator = user.getDiscriminator();
        String id = user.getID();
        String uuid = user.getUUID();
        long firstSeen = user.getFirstSeen();
        long age = user.getAge();
        long activity = user.getActivity();
        long lastActivityTime = user.getLastActivityTime();
        double exp = user.getExp();
        long level = user.getLevel();
        double presence = user.getPresence();
        JSONObject userJson = new JSONObject();
        userJson.put("name", name);
        userJson.put("discriminator", discriminator);
        userJson.put("id", id);
        userJson.put("uuid", uuid);
        userJson.put("first_seen", firstSeen);
        userJson.put("age", age);
        userJson.put("activity", activity);
        userJson.put("last_activity_time", lastActivityTime);
        userJson.put("exp", exp);
        userJson.put("level", level);
        userJson.put("presence", presence);
        return userJson;
    }

    public static String[] loadResponses(String path) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(path);
            return (String[]) jsonObject.get("responses");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean exists(String path) {
        return new File(path).exists();
    }
}
