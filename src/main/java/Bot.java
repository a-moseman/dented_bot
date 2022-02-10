import com.iwebpp.crypto.TweetNaclFast;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.util.*;

/**
 * Class for the bot.
 */
public class Bot {
    private char commandCharacter = '$';
    private final long START_NANO_TIME;
    private final double CHANCE_OF_RANDOM_RESPONSE;
    private final Random RANDOM;

    private RandomResponseGenerator randomResponseGenerator;
    private SurveyManager surveyManager;
    private UserManager userManager;

    /**
     * Instantiate a new bot.
     * @param chanceOfRandomResponse
     */
    public Bot(double chanceOfRandomResponse) {
        this.START_NANO_TIME = System.nanoTime();
        this.CHANCE_OF_RANDOM_RESPONSE = chanceOfRandomResponse;
        this.RANDOM = new Random();
        this.randomResponseGenerator = new RandomResponseGenerator(this.RANDOM);
        this.surveyManager = new SurveyManager();
        this.userManager = new UserManager();

        try {
            this.userManager.load();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void save() {
        userManager.save();
    }

    public boolean incrementUserActivity(String name, String discriminator, String id) {
        userManager.addUser(name, discriminator, id);
        return userManager.incrementUserActivity(id);
    }

    public long getUserLevel(String id) {
        return userManager.getUserLevel(id);
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
            jda.addEventListener(new MessageListener(this));
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
    public BotResponse getBotResponse(String userMessage, String authorID, String authorUUID) {
        if (userMessage.charAt(0) == commandCharacter) {
            return doCommand(Util.split(userMessage.substring(1)), authorID, authorUUID);
        }
        else if (RANDOM.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return new BotResponse(new String[]{randomResponseGenerator.get()});
        }
        return new BotResponse(new String[]{});
    }

    /**
     * Do a provided command.
     * @param command
     * @param authorUUID
     * @return
     */
    private BotResponse doCommand(String[] command, String authorID, String authorUUID) {
        switch (command[0]) {
            case "help":
                return help(command, authorUUID);
            case "info":
                return info(command, authorUUID);
            case "survey":
                return survey(command, authorUUID);
            case "stats":
                return stats(command, authorID, authorUUID);
            case "changecmdchar":
                return changeCommandCharacter(command, authorID, authorUUID);
            default:
                return new BotResponse(new String[]{"$" + String.join(" ", command) + " is not a valid command."});
        }
    }

    /**
     * Do the help command.
     * @param command
     * @param authorUUID
     * @return
     */
    private BotResponse help(String[] command, String authorUUID) {
        return new BotResponse(new String[]{"Commands:\n" +
                "$help - get a list of commands\n" +
                "$info - get bot information and diagnostics\n" +
                "$survey open <name> <choices> - open a survey\n" +
                "$survey close - close your survey\n" +
                "$stats - get a summary of your stats\n" +
                "$changecmdchar <character> - change the command character\n\n" +
                "Notes:\n" +
                "Lists must be contained in quotes with the elements separated by only commas.\n" +
                "Spaces are seen as delimiters unless within quotes."});
    }

    /**s
     * Do the info command.
     * @param command
     * @param authorUUID
     * @return
     */
    private BotResponse info(String[] command, String authorUUID) {
        return new BotResponse(new String[]{"Info:\n" +
                "Runtime: " + (Util.convertToReadableTime(System.nanoTime() - START_NANO_TIME)) + "\n" +
                "Language: Java 11\n" +
                "Discord API Wrapper: JDA\n" +
                "Version: 3.1\n" +
                "Author: Andrew Moseman\n"});
    }

    /**
     * Do the survey command.
     * @param command
     * @param authorUUID
     * @return
     */
    private BotResponse survey(String[] command, String authorUUID) {
        switch (command[1]) {
            case "open":
                return surveyOpen(command, authorUUID);
            case "close":
                return surveyClose(command, authorUUID);
            default:
                return new BotResponse(new String[]{"$" + String.join(" ", command) + " is not a valid command."});
        }
    }

    /**
     * Do the survey open command.
     * @param command
     * @param authorUUID
     * @return
     */
    private BotResponse surveyOpen(String[] command, String authorUUID) {
        if (!surveyManager.contains(authorUUID)) {
            String[] choices = command[3].split(",");
            ArrayList<String> tempList = new ArrayList<String>(Arrays.asList(choices));
            tempList.add(command[2]);
            surveyManager.add(authorUUID, new Survey(command[2]));
            for (String choice : choices) {
                ArrayList<String> votes = new ArrayList<>();
                surveyManager.addQuestion(authorUUID, choice);
            }
            return new BotResponse(tempList.toArray(new String[0])).setAsSurvey(command[2]);
        }
        else {
            return new BotResponse(new String[]{"You already have a survey open"});
        }
    }

    /**
     * Do the survey close command.
     * @param command
     * @param authorUUID
     * @return
     */
    private BotResponse surveyClose(String[] command, String authorUUID) {
        if (!surveyManager.contains(authorUUID)) {
            return new BotResponse(new String[]{"You do not have an open survey"});
        }
        ArrayList<String> topVotedQuestions = surveyManager.getTopVotedQuestions(authorUUID);
        String[] response = new String[topVotedQuestions.size() + 1];
        response[0] = "Results for " + authorUUID + "'s survey, " + surveyManager.get(authorUUID).getName() + ":";
        for (int i = 0; i < topVotedQuestions.size(); i++) {
            response[i + 1] = topVotedQuestions.get(i).replaceFirst(authorUUID, "") + " - " + surveyManager.getQuestion(topVotedQuestions.get(i)).getVotes();
        }
        surveyManager.closeSurvey(authorUUID);
        return new BotResponse(response);
    }

    private BotResponse stats(String[] command, String authorID, String authorUUID) {
        return new BotResponse(new String[]{userManager.getUserSummary(authorID)});
    }

    private BotResponse changeCommandCharacter(String[] command, String authorID, String authorUUID) {
        commandCharacter = command[1].charAt(0);
        return new BotResponse(new String[]{"Command character changed to " + commandCharacter});
    }

    public SurveyManager getSurveyManager() {
        return surveyManager;
    }
}
