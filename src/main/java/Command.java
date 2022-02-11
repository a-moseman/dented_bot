public class Command {
    private String[] COMMAND_TEXT;
    private String AUTHOR_NAME;
    private String AUTHOR_ID;
    private String AUTHOR_UUID;

    public Command(String[] commandText, String authorName, String authorID, String authorUUID) {
        this.COMMAND_TEXT = commandText;
        this.AUTHOR_NAME = authorName;
        this.AUTHOR_ID = authorID;
        this.AUTHOR_UUID = authorUUID;
    }

    public String[] getCommandText() {
        return COMMAND_TEXT;
    }

    public String getAuthorName() {
        return AUTHOR_NAME;
    }

    public String getAuthorID() {
        return AUTHOR_ID;
    }

    public String getAuthorUUID() {
        return AUTHOR_UUID;
    }
}
