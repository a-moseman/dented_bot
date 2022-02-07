import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.util.*;

/**
 * Class for the bot.
 */
public class Bot {
    private final double CHANCE_OF_RANDOM_RESPONSE;
    private final ArrayList<String> RESPONSES;
    private final Random RANDOM;
    private final long START_NANO_TIME;

    private MessageListener messageListener;

    /**
     * Instantiate a new bot.
     * @param chanceOfRandomResponse
     */
    public Bot(double chanceOfRandomResponse) {
        this.CHANCE_OF_RANDOM_RESPONSE = chanceOfRandomResponse;
        this.RANDOM = new Random();
        this.START_NANO_TIME = System.nanoTime();
        this.RESPONSES = new Loader()
                .load(this, "responses.json")
                .getResponses();
    }

    /**
     * Set up the JDA wrapper for the bot.
     * @param token
     * @return
     */
    public Bot setupJDA(String token) {
        try {
            JDA jda = JDABuilder.createDefault(token)
                    .build();
            messageListener = new MessageListener(this);
            jda.addEventListener(messageListener);
        }
        catch (LoginException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Get the bot's response based on the user command.
     * @param userMessage
     * @param authorUUID
     * @return
     */
    public String[] getBotResponse(String userMessage, String authorUUID) {
        char COMMAND_CHARACTER = '$';
        if (userMessage.charAt(0) == COMMAND_CHARACTER) {
            return doCommand(Util.split(userMessage.substring(1)), authorUUID);
        }
        else if (RANDOM.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return new String[]{RESPONSES.get(RANDOM.nextInt(RESPONSES.size()))};
        }
        return new String[]{};
    }

    /**
     * Do a provided command.
     * @param command
     * @param authorUUID
     * @return
     */
    private String[] doCommand(String[] command, String authorUUID) {
        switch (command[0]) {
            case "help":
                return help(command, authorUUID);
            case "info":
                return info(command, authorUUID);
            case "survey":
                return survey(command, authorUUID);
            default:
                return new String[]{"$" + String.join(" ", command) + " is not a valid command."};
        }
    }

    /**
     * Do the help command.
     * @param command
     * @param authorUUID
     * @return
     */
    private String[] help(String[] command, String authorUUID) {
        return new String[]{"Commands:\n" +
                "$help - get a list of commands\n" +
                "$info - get bot information and diagnostics\n" +
                "$survey open <name> <choices> - open a survey\n" +
                "$survey close - close your survey\n\n" +
                "Notes:\n" +
                "Lists must be contained in quotes with the elements separated by only commas.\n" +
                "Spaces are seen as delimiters unless within quotes."};
    }

    /**s
     * Do the info command.
     * @param command
     * @param authorUUID
     * @return
     */
    private String[] info(String[] command, String authorUUID) {
        return new String[]{"Info:\n" +
                "Runtime: " + (Util.convertToReadableTime(System.nanoTime() - START_NANO_TIME)) + "\n" +
                "Language: Java 11\n" +
                "Discord API Wrapper: JDA\n" +
                "Author: Andrew Moseman\n"};
    }

    /**
     * Do the survey command.
     * @param command
     * @param authorUUID
     * @return
     */
    private String[] survey(String[] command, String authorUUID) {
        switch (command[1]) {
            case "open":
                return surveyOpen(command, authorUUID);
            case "close":
                return surveyClose(command, authorUUID);
            default:
                return new String[]{"$" + String.join(" ", command) + " is not a valid command."};
        }
    }

    /**
     * Do the survey open command.
     * @param command
     * @param authorUUID
     * @return
     */
    private String[] surveyOpen(String[] command, String authorUUID) {
        String[] choices = command[3].split(",");
        messageListener.sendingSurveyMessage = true;
        messageListener.newSurveyName = command[2];

        ArrayList<String> tempList = new ArrayList<String>(Arrays.asList(choices));
        tempList.add(messageListener.newSurveyName);
        return tempList.toArray(new String[0]);
    }

    /**
     * Do the survey close command.
     * @param command
     * @param authorUUID
     * @return
     */
    private String[] surveyClose(String[] command, String authorUUID) {
        // TODO: optimize
        Hashtable<String, Survey> surveys = messageListener.surveys;
        Hashtable<String, ArrayList<String>> questions = surveys.get(authorUUID).getQuestionsAndVotes();
        if (questions == null) {
            return new String[]{"You do not have an open survey"};
        }
        Iterator<String> iter = questions.keys().asIterator();
        ArrayList<String> questionNames = new ArrayList<>();
        while (iter.hasNext()) {
            questionNames.add(iter.next());
        }
        ArrayList<String> topVoted = new ArrayList<>();
        int most = 0;
        for (int i = 0; i < questionNames.size(); i++) {
            String name = questionNames.get(i);
            int votes = questions.get(name).size();
            if (votes >= most) {
                most = votes;
                topVoted.add(name);
                for (int j = 0; j < topVoted.size(); j++) {
                    if (questions.get(topVoted.get(j)).size() < most) {
                        topVoted.remove(j);
                        j--;
                    }
                }
            }
        }
        String[] response = new String[topVoted.size() + 1];
        response[0] = "Results for " + authorUUID + "'s survey, " + surveys.get(authorUUID).getName() + ":";
        for (int i = 0; i < topVoted.size(); i++) {
            response[i + 1] = topVoted.get(i).replaceFirst(authorUUID, "") + " - " + questions.get(topVoted.get(i)).size();
        }
        surveys.remove(authorUUID); //close the survey
        return response;
    }
}
