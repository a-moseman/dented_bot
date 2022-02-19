public class BotResponse {
    private final String[] CONTENTS;
    private final String[] ARGUMENTS;
    private final int CONTENTS_SIZE;
    private final int ARGUMENTS_SIZE;
    private boolean isSurvey;
    private String surveyName;

    public BotResponse(String[] contents) {
        this.CONTENTS = contents;
        this.ARGUMENTS = new String[this.CONTENTS.length - 1];
        for (int i = 1; i < this.CONTENTS.length; i++) {
            this.ARGUMENTS[i - 1] = this.CONTENTS[i];
        }
        this.CONTENTS_SIZE = this.CONTENTS.length;
        this.ARGUMENTS_SIZE = this.ARGUMENTS.length;
    }

    public BotResponse setAsSurvey(String surveyName) {
        this.isSurvey = true;
        this.surveyName = surveyName;
        return this;
    }

    public String[] getContents() {
        return CONTENTS;
    }

    public String[] getArguments() {
        return ARGUMENTS;
    }

    public boolean isSurvey() {
        return isSurvey;
    }

    public String getSurveyName() {
        return surveyName;
    }
}
