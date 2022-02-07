import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.util.*;

public class Bot {
    private final double CHANCE_OF_RANDOM_RESPONSE;
    private final ArrayList<String> RESPONSES;
    private final Random RANDOM;
    private final long START_NANO_TIME;

    private MessageListener messageListener;

    public Bot(double chanceOfRandomResponse) {
        this.CHANCE_OF_RANDOM_RESPONSE = chanceOfRandomResponse;
        this.RANDOM = new Random();
        this.START_NANO_TIME = System.nanoTime();
        this.RESPONSES = new Loader()
                .load(this, "responses.json")
                .getResponses();
    }

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

    public String[] getBotResponse(String userMessage, String authorUUID) {
        char COMMAND_CHARACTER = '$';
        if (userMessage.charAt(0) == COMMAND_CHARACTER) {
            return getCommandResponse(Util.split(userMessage.substring(1)), authorUUID);
        }
        else if (RANDOM.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return new String[]{RESPONSES.get(RANDOM.nextInt(RESPONSES.size()))};
        }
        return new String[]{};
    }

    private String[] getCommandResponse(String[] command, String authorUUID) {
        switch (command[0]) {
            case "help":
                return new String[]{"Commands:\n" +
                        "$help - get a list of commands\n" +
                        "$info - get bot information and diagnostics\n" +
                        "$survey open <choices> - open a survey\n" +
                        "$survey close - close your survey"};
            case "info":
                return new String[]{"Info:\n" +
                        "Runtime: " + (Util.convertToReadableTime(System.nanoTime() - START_NANO_TIME)) + "\n" +
                        "Language: Java 11\n" +
                        "Discord API Wrapper: JDA\n" +
                        "Author: Andrew Moseman\n"};
            case "survey":
                switch (command[1]) {
                    case "open":
                        String[] choices = command[2].split(",");
                        messageListener.sendingSurveyMessage = true;
                        return choices;
                    case "close":
                        Hashtable<String, Hashtable<String, ArrayList<String>>> surveys = messageListener.surveys;
                        Hashtable<String, ArrayList<String>> questions = surveys.get(authorUUID);
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
                        response[0] = "Top choices for " + authorUUID + "'s survey:";
                        for (int i = 0; i < topVoted.size(); i++) {
                            response[i + 1] = topVoted.get(i).replaceFirst(authorUUID, "") + " - " + questions.get(topVoted.get(i)).size();
                        }
                        surveys.remove(authorUUID); //close the survey
                        return response;
                    default:
                        return new String[]{"$" + String.join(" ", command) + " is not a valid command."};
                }
            default:
                return new String[]{"$" + String.join(" ", command) + " is not a valid command."};
        }
    }
}
