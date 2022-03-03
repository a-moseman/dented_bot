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

    private final boolean HAS_RANDOM_RESPONSES;

    /**
     * Instantiate a new bot.
     * @param chanceOfRandomResponse The chance of a random response.
     */
    public Bot(double chanceOfRandomResponse, String responsePath) {
        this.START_NANO_TIME = System.nanoTime();
        this.CHANCE_OF_RANDOM_RESPONSE = chanceOfRandomResponse;
        this.RANDOM = new Random();
        this.HAS_RANDOM_RESPONSES = FileManager.exists(responsePath);
        if (this.HAS_RANDOM_RESPONSES) {
            this.RANDOM_RESPONSE_GENERATOR = new RandomResponseGenerator(this.RANDOM, responsePath);
        }
        else {
            this.RANDOM_RESPONSE_GENERATOR = null;
        }
        this.SURVEY_MANAGER = new SurveyManager();
        this.USER_MANAGER = new UserManager();

        try {
            this.USER_MANAGER.load();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Set up the JDA wrapper for the bot.
     * @param token The bot token.
     * @return Bot
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
        return this;
    }

    /**
     * Save.
     */
    public void save() {
        USER_MANAGER.save();
    }

    /**
     * Increment a user's activity.
     * @param name The user's name.
     * @param discriminator The user's discriminator.
     * @param id The user's id.
     * @return boolean
     */
    public boolean incrementUserActivity(String name, String discriminator, String id) {
        USER_MANAGER.addUser(name, discriminator, id);
        return USER_MANAGER.incrementUserActivity(id);
    }

    /**
     * Get the level of a user.
     * @param id The user's id.
     * @return long
     */
    public long getUserLevel(String id) {
        return USER_MANAGER.getUserLevel(id);
    }

    /**
     * Get the bot's response based on the user command.
     * @param userMessage The user's message.
     * @param authorUUID The author's uuid.
     * @return BotResponse
     */
    public BotResponse getBotResponse(String userMessage, String authorName, String authorID, String authorUUID) {
        if (userMessage.charAt(0) == commandCharacter) {
            Command command = new Command(Util.split(userMessage.substring(1)), authorName, authorID, authorUUID);
            return doCommand(command);
        }
        else if (HAS_RANDOM_RESPONSES && RANDOM.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return new BotResponse(new String[]{RANDOM_RESPONSE_GENERATOR.get()});
        }
        return null;
    }

    /**
     * Do a provided command.
     * @param command The command.
     * @return BotResponse
     */
    private BotResponse doCommand(Command command) {
        switch (command.getCommandText()[0]){
            case "help":
                return help(command);
            case "info":
                return info(command);
            case "survey":
                return survey(command);
            case "stats":
                return stats(command);
            case "changecmdchar":
                return changeCommandCharacter(command);
            default:
                return Error.INVALID_CMD;
        }
    }

    /**
     * Do the help command.
     * @param command The command.
     * @return BotResponse
     */
    private BotResponse help(Command command) {
        if (command.getCommandText().length > 1) {
            return Error.EXTRA_ARG;
        }
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
     * @param command The command.
     * @return BotResponse
     */
    private BotResponse info(Command command) {
        if (command.getCommandText().length > 1) {
            return Error.EXTRA_ARG;
        }
        return new BotResponse(new String[]{"Info:\n" +
                "Runtime: " + (Util.convertToReadableTime(System.nanoTime() - START_NANO_TIME)) + "\n" +
                "Language: Java 14\n" +
                "Discord API Wrapper: JDA\n" +
                "Version: 3.2\n" +
                "Author: Andrew Moseman\n"});
    }

    /**
     * Do the survey command.
     * @param command The command.
     * @return BotResponse
     */
    private BotResponse survey(Command command) {
        if (command.getCommandText().length < 2) {
            return Error.MISSING_ARG;
        }
        switch (command.getCommandText()[1]) {
            case "open":
                return surveyOpen(command);
            case "close":
                return surveyClose(command);
            default:
                return Error.INVALID_CMD;
        }
    }

    /**
     * Do the survey open command.
     * @param command The command.
     * @return BotResponse
     */
    private BotResponse surveyOpen(Command command) {
        if (command.getCommandText().length < 4) {
            return Error.MISSING_ARG;
        }
        if (command.getCommandText().length > 4) {
            return Error.EXTRA_ARG;
        }
        if (!SURVEY_MANAGER.contains(command.getAuthorUUID())) {
            String[] choices = command.getCommandText()[3].split(",");
            ArrayList<String> tempList = new ArrayList<>(Arrays.asList(choices));
            tempList.add(command.getCommandText()[2]);
            SURVEY_MANAGER.add(command.getAuthorUUID(), new Survey(command.getCommandText()[2]));
            for (String choice : choices) {
                SURVEY_MANAGER.addQuestion(command.getAuthorUUID(), choice);
            }
            return new BotResponse(tempList.toArray(new String[0])).setAsSurvey(command.getCommandText()[2]);
        }
        else {
            return new BotResponse(new String[]{"You already have a survey open"});
        }
    }

    /**
     * Do the survey close command.
     * @param command The command.
     * @return BotResponse
     */
    private BotResponse surveyClose(Command command) {
        if (command.getCommandText().length > 2) {
            return Error.EXTRA_ARG;
        }
        if (!SURVEY_MANAGER.contains(command.getAuthorUUID())) {
            return new BotResponse(new String[]{"You do not have an open survey"});
        }
        ArrayList<String> topVotedQuestions = SURVEY_MANAGER.getTopVotedQuestions(command.getAuthorUUID());
        String[] response = new String[topVotedQuestions.size() + 1];
        response[0] = "Results for " + command.getAuthorName() + "'s survey, " + SURVEY_MANAGER.get(command.getAuthorUUID()).getName() + ":";
        for (int i = 0; i < topVotedQuestions.size(); i++) {
            response[i + 1] = topVotedQuestions.get(i).replaceFirst(command.getAuthorUUID(), "") + " - " + SURVEY_MANAGER.getQuestion(topVotedQuestions.get(i)).getVotes();
        }
        SURVEY_MANAGER.closeSurvey(command.getAuthorUUID());
        return new BotResponse(response);
    }

    /**
     * Do the stats command.
     * @param command The command.
     * @return BotResponse
     */
    private BotResponse stats(Command command) {
        if (command.getCommandText().length > 1) {
            return Error.EXTRA_ARG;
        }
        return new BotResponse(new String[]{USER_MANAGER.getUserSummary(command.getAuthorID())});
    }

    /**
     * Do the change command character command.
     * @param command The command.
     * @return BotResponse.
     */
    private BotResponse changeCommandCharacter(Command command) {
        if (command.getCommandText().length < 1) {
            return Error.MISSING_ARG;
        }
        if (command.getCommandText().length > 2) {
            return Error.EXTRA_ARG;
        }
        if (command.getCommandText()[1].length() > 1) {
            return Error.INVALID_ARG;
        }
        char commandCharacter = command.getCommandText()[1].charAt(0);
        return new BotResponse(new String[]{"Command character changed to " + commandCharacter});
    }

    /**
     * Get a survey question.
     * @param uuid The questions uuid.
     * @return SurveyQuestion.
     */
    public SurveyQuestion getSurveyQuestion(String uuid) {
        return SURVEY_MANAGER.getQuestion(uuid);
    }
}
