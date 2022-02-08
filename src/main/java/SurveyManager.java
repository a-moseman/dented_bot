import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Queue;

public class SurveyManager {
    private Hashtable<String, Survey> surveys;
    private Hashtable<String, SurveyQuestion> surveyQuestions;

    public SurveyManager() {
        this.surveys = new Hashtable<>();
        this.surveyQuestions = new Hashtable<>();
    }

    public void closeSurvey(String authorUUID) {
        Survey survey = surveys.get(authorUUID);
        Iterator<String> iter = survey.getQuestionsAndVotes().keys().asIterator();
        while (iter.hasNext()) {
            surveyQuestions.remove(iter.next());
        }
        surveys.remove(authorUUID);
    }

    public Survey get(String authorUUID) {
        return surveys.get(authorUUID);
    }

    public SurveyQuestion getQuestion(String uuid) {
        return surveyQuestions.get(uuid);
    }

    public boolean contains(String authorUUID) {
        return get(authorUUID) != null;
    }

    public void add(String authorUUID, Survey survey) {
        surveys.put(authorUUID, survey);
    }

    public void addQuestion(String authorUUID, String name) {
        SurveyQuestion surveyQuestion = new SurveyQuestion(name);
        surveyQuestions.put(authorUUID + name, surveyQuestion);
        surveys.get(authorUUID).addQuestion(authorUUID + name, surveyQuestion);
    }

    public ArrayList<String> getTopVotedQuestions(String authorUUID) {
        Hashtable<String, SurveyQuestion> questions = surveys.get(authorUUID).getQuestionsAndVotes();
        Iterator<String> iter = questions.keys().asIterator();
        ArrayList<String> questionNames = new ArrayList<>();
        while (iter.hasNext()) {
            questionNames.add(iter.next());
        }
        ArrayList<String> topVoted = new ArrayList<>();
        int most = 0;
        for (int i = 0; i < questionNames.size(); i++) {
            String name = questionNames.get(i);
            int votes = questions.get(name).getVotes();
            if (votes >= most) {
                most = votes;
                topVoted.add(name);
                for (int j = 0; j < topVoted.size(); j++) {
                    if (questions.get(topVoted.get(j)).getVotes() < most) {
                        topVoted.remove(j);
                        j--;
                    }
                }
            }
        }
        return topVoted;
    }
}
