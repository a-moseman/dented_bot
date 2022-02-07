import java.util.ArrayList;
import java.util.Hashtable;

public class Survey {
    private final String NAME;
    private Hashtable<String, ArrayList<String>> questionsAndVotes;

    public Survey(String name) {
        this.NAME = name;
        this.questionsAndVotes = new Hashtable<>();
    }

    public void addQuestion(String questionUID) {
        questionsAndVotes.put(questionUID, new ArrayList<>());
    }

    public void addQuestion(String questionUID, ArrayList<String> votes) {
        questionsAndVotes.put(questionUID, votes);
    }

    public void addVote(String questionUID, String uuid) {
        questionsAndVotes.get(questionUID).add(uuid);
    }

    public Hashtable<String, ArrayList<String>> getQuestionsAndVotes() {
        return questionsAndVotes;
    }

    public String getName() {
        return NAME;
    }
}
