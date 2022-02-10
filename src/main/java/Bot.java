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

    private final RandomResponseGenerator RANDOM_RESPONSE_GENERATOR;
    private final SurveyManager SURVEY_MANAGER;
    private final UserManager USER_MANAGER;

    /**
     * Instantiate a new bot.
     * @param chanceOfRandomResponse
     */
    public Bot(double chanceOfRandomResponse) {
        this.START_NANO_TIME = System.nanoTime();
        this.CHANCE_OF_RANDOM_RESPONSE = chanceOfRandomResponse;
        this.RANDOM = new Random();
        this.RANDOM_RESPONSE_GENERATOR = new RandomResponseGenerator(this.RANDOM);
        this.SURVEY_MANAGER = new SurveyManager();
        this.USER_MANAGER = new UserManager();

        try {
            this.USER_MANAGER.load();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void save() {
        USER_MANAGER.save();
    }

    public boolean incrementUserActivity(String name, String discriminator, String id) {
        USER_MANAGER.addUser(name, discriminator, id);
        return USER_MANAGER.incrementUserActivity(id);
    }

    public long getUserLevel(String id) {
        return USER_MANAGER.getUserLevel(id);
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
            return new BotResponse(new String[]{RANDOM_RESPONSE_GENERATOR.get()});
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
        return switch (command[0]) {
            case "help" -> help(command, authorUUID);
            case "info" -> info(command, authorUUID);
            case "survey" -> survey(command, authorUUID);
            case "stats" -> stats(command, authorID, authorUUID);
            case "changecmdchar" -> changeCommandCharacter(command, authorID, authorUUID);
            default -> new BotResponse(new String[]{"$" + String.join(" ", command) + " is not a valid command."});
        };
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
        return switch (command[1]) {
            case "open" -> surveyOpen(command, authorUUID);
            case "close" -> surveyClose(command, authorUUID);
            default -> new BotResponse(new String[]{"$" + String.join(" ", command) + " is not a valid command."});
        };
    }

    /**
     * Do the survey open command.
     * @param command
     * @param authorUUID
     * @return
     */
    private BotResponse surveyOpen(String[] command, String authorUUID) {
        if (!SURVEY_MANAGER.contains(authorUUID)) {
            String[] choices = command[3].split(",");
            ArrayList<String> tempList = new ArrayList<>(Arrays.asList(choices));
            tempList.add(command[2]);
            SURVEY_MANAGER.add(authorUUID, new Survey(command[2]));
            for (String choice : choices) {
                SURVEY_MANAGER.addQuestion(authorUUID, choice);
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
        if (!SURVEY_MANAGER.contains(authorUUID)) {
            return new BotResponse(new String[]{"You do not have an open survey"});
        }
        ArrayList<String> topVotedQuestions = SURVEY_MANAGER.getTopVotedQuestions(authorUUID);
        String[] response = new String[topVotedQuestions.size() + 1];
        response[0] = "Results for " + authorUUID + "'s survey, " + SURVEY_MANAGER.get(authorUUID).getName() + ":";
        for (int i = 0; i < topVotedQuestions.size(); i++) {
            response[i + 1] = topVotedQuestions.get(i).replaceFirst(authorUUID, "") + " - " + SURVEY_MANAGER.getQuestion(topVotedQuestions.get(i)).getVotes();
        }
        SURVEY_MANAGER.closeSurvey(authorUUID);
        return new BotResponse(response);
    }

    private BotResponse stats(String[] command, String authorID, String authorUUID) {
        return new BotResponse(new String[]{USER_MANAGER.getUserSummary(authorID)});
    }

    private BotResponse changeCommandCharacter(String[] command, String authorID, String authorUUID) {
        commandCharacter = command[1].charAt(0);
        return new BotResponse(new String[]{"Command character changed to " + commandCharacter});
    }

    public SurveyQuestion getSurveyQuestion(String uuid) {
        return SURVEY_MANAGER.getQuestion(uuid);
    }
}
