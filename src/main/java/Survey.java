import java.util.Hashtable;

public class Survey {
    private final String NAME;
    private Hashtable<String, SurveyQuestion> questionsAndVotes;

    public Survey(String name) {
        this.NAME = name;
        this.questionsAndVotes = new Hashtable<>();
    }

    public void addQuestion(String questionUID, String name) {
        questionsAndVotes.put(questionUID, new SurveyQuestion(name));
    }

    public void addQuestion(String questionUID, SurveyQuestion surveyQuestion) {
        questionsAndVotes.put(questionUID, surveyQuestion);
    }

    public void addVote(String questionUID, String uuid) {
        questionsAndVotes.get(questionUID).addVote(uuid);
    }

    public Hashtable<String, SurveyQuestion> getQuestionsAndVotes() {
        return questionsAndVotes;
    }

    public String getName() {
        return NAME;
    }
}
