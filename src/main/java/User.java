import java.io.Serializable;

public class User implements Serializable {
    private final String NAME;
    private final String DISCRIMINATOR;
    private final String ID;
    private final String UUID;
    private final long FIRST_SEEN; // Time in nanoseconds when the user was first seen

    private long age = 0; // How long has the bot known the user in nanoseconds
    private long activity = 0; // How many messages the user has sent
    private long lastActivityTime = 0;
    private double exp = 0;
    private long level = 0;
    private double presence = 0;

    public User(String name, String discriminator, String id) {
        this.NAME = name;
        this.DISCRIMINATOR = discriminator;
        this.ID = id;
        this.UUID = this.NAME + "#" + this.DISCRIMINATOR;
        this.FIRST_SEEN = System.nanoTime();
    }

    public String getName() {
        return NAME;
    }

    public String getDiscriminator() {
        return DISCRIMINATOR;
    }

    public String getID() {
        return ID;
    }

    public String getUUID() {
        return UUID;
    }

    public long getActivity() {
        return activity;
    }

    public double getExp() {
        return exp;
    }

    public long getLevel() {
        return level;
    }

    public double getPresence() {
        return presence;
    }

    public long getAge() {
        return age;
    }

    public boolean incrementActivity() {
        activity++;
        long old = lastActivityTime;
        lastActivityTime = System.nanoTime();
        long ns = lastActivityTime - old;
        updateScore((double) ns / 1_000_000_000);
        boolean leveledUp = updateLevel();

        updateAge();
        updatePresence();
        return leveledUp;
    }

    private boolean updateLevel() {
        long lastLevel = level;
        level = (long) (Math.log10(exp + 1) / Math.log10(2));
        return level > lastLevel;
    }

    private void updateScore(double secs) {
        exp += calculateEXPGain(secs);
    }

    /**
     * presence = activity / days
     */
    private void updatePresence() {
        presence = (double) activity / ((double) age / 1_000_000_000 / 60 / 60 / 24 + 1);
    }

    private double calculateEXPGain(double secs) {
        return (double) Math.min(secs / 60, 1);
    }

    private void updateAge() {
        age = System.nanoTime() - FIRST_SEEN;
    }
}
