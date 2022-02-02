import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Random;

public class Bot {
    private final double CHANCE_OF_RANDOM_RESPONSE;
    private final ArrayList<String> RESPONSES;
    private final Random RANDOM;
    private final long START_NANO_TIME;

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
            jda.addEventListener(new MessageListener(this));
        }
        catch (LoginException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public String getBotResponse(String userMessage) {
        char COMMAND_CHARACTER = '$';
        if (userMessage.charAt(0) == COMMAND_CHARACTER) {
            return getCommandResponse(userMessage.substring(1));
        }
        else if (RANDOM.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return RESPONSES.get(RANDOM.nextInt(RESPONSES.size()));
        }
        return "";
    }

    private String getCommandResponse(String userMessage) {
        return switch (userMessage) {
            case "help" -> "Commands:\n" +
                    "$help - get a list of commands\n" +
                    "$info - get bot information and diagnostics";
            case "info" -> "Info:\n" +
                    "Current Runtime: " + (Util.convertToReadableTime(System.nanoTime() - START_NANO_TIME)) + "\n" +
                    "Language: Java 11\n" +
                    "Libraries: JDA\n" +
                    "Author: Andrew Moseman\n";
            default -> userMessage + " is not a valid command.";
        };
    }
}
