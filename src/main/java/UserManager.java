import java.util.Hashtable;

public class UserManager {
    private Hashtable<String, User> users;

    public UserManager(Hashtable<String, User> users) {
        this.users = users;
    }

    public UserManager() {
        this.users = new Hashtable<>();
    }

    public void addUser(String name, String discriminator, String id) {
        if (users.get(id) == null) {
            users.put(id, new User(name, discriminator, id));
        }
    }

    public boolean incrementUserActivity(String id) {
        return users.get(id).incrementActivity();
    }

    public double getUserScore(String id) {
        return users.get(id).getScore();
    }

    public long getUserLevel(String id) {
        return users.get(id).getLevel();
    }

    public String getUserSummary(String id) {
        User user = users.get(id);
        StringBuilder string = new StringBuilder();
        string.append("<@" + id + "> Stats:\n");
        string.append("Level: " + user.getLevel() + "\n");
        string.append("Experience: " + user.getScore() + "\n");
        string.append("Sent Messages: " + user.getActivity() + "\n");
        return string.toString();
    }
}
