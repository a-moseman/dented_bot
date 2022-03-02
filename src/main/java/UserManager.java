import java.io.File;
import java.util.Hashtable;

public class UserManager {
    private final String PATH = "users.data";

    private Hashtable<String, User> users;

    public UserManager() {
        this.users = new Hashtable<>();
    }

    /**
     * TODO: save to users.json
     */
    public void save() {
        FileManager.saveUserData(users);
    }

    /**
     * TODO: load from users.json
     */
    public void load() {
        users = FileManager.loadUserData();
    }

    public void addUser(String name, String discriminator, String id) {
        if (users.get(id) == null) {
            users.put(id, new User(name, discriminator, id));
        }
    }

    public boolean incrementUserActivity(String id) {
        return users.get(id).incrementActivity();
    }

    public double getUserEXP(String id) {
        return users.get(id).getExp();
    }

    public long getUserLevel(String id) {
        return users.get(id).getLevel();
    }

    public String getUserSummary(String id) {
        User user = users.get(id);
        StringBuilder string = new StringBuilder();
        string.append("<@" + id + "> Stats:\n");
        string.append("Level: " + user.getLevel() + "\n");
        string.append("Experience: " + user.getExp() + "\n");
        string.append("Presence: " + user.getPresence() + "\n");
        string.append("Sent Messages: " + user.getActivity() + "\n");
        string.append("Age: " + Util.convertToReadableTime(user.getAge()));
        return string.toString();
    }
}
