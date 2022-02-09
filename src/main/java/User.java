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
    private double score = 0;
    private long level = 0;

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

    public double getScore() {
        return score;
    }

    public long getLevel() {
        return level;
    }

    public long getFirstSeen() {
        return FIRST_SEEN;
    }

    public boolean incrementActivity() {
        activity++;
        long temp = lastActivityTime;
        lastActivityTime = System.nanoTime();
        long d = lastActivityTime - temp;
        updateScore(d);
        boolean leveledUp = updateLevel();
        updateAge();
        return leveledUp;
    }

    private boolean updateLevel() {
        long lastLevel = level;
        level = (long) (Math.log10(score + 1) / Math.log10(2) / 2);
        return level > lastLevel;
    }

    private void updateScore(long ns) {
        score += calculateQuality(ns);
    }

    private double calculateQuality(long ns) {
        return (double) 1 / (-((double) ns / 1_000_000_000 * 60) - 1) + 1;
    }

    private void updateAge() {
        age = System.nanoTime() - FIRST_SEEN;
    }
}
