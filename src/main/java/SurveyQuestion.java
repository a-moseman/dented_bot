import java.util.ArrayList;

public class SurveyQuestion {
    private final String NAME;
    private ArrayList<String> votes;

    public SurveyQuestion(String name) {
        this.NAME = name;
        this.votes = new ArrayList<>();
    }

    public String getName() {
        return NAME;
    }

    public int getVotes() {
        return votes.size();
    }

    public boolean containsVote(String uuid) {
        for (String vote : votes) {
            if (vote.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public void addVote(String vote) {
        votes.add(vote);
    }
}
