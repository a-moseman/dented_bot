public class BotResponse {
    private final String[] CONTENTS;
    private boolean isSurvey;
    private String surveyName;

    public BotResponse(String[] contents) {
        this.CONTENTS = contents;
    }

    public BotResponse setAsSurvey(String surveyName) {
        this.isSurvey = true;
        this.surveyName = surveyName;
        return this;
    }

    public String[] getContents() {
        return CONTENTS;
    }

    public boolean isSurvey() {
        return isSurvey;
    }

    public String getSurveyName() {
        return surveyName;
    }
}
