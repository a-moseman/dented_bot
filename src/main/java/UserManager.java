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
        users.put(id, new User(name, discriminator, id));
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
}
