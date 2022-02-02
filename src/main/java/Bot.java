import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Random;

public class Bot {
    private final char COMMAND_CHARACTER = '$';

    private final double CHANCE_OF_RANDOM_RESPONSE;

    private ArrayList<String> responses;

    private Random random;

    private long startNanoTime;

    public Bot(double chanceOfRandomResponse) {
        this.CHANCE_OF_RANDOM_RESPONSE = chanceOfRandomResponse;
        random = new Random();
        startNanoTime = System.nanoTime();

        responses = new Loader()
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
        if (userMessage.charAt(0) == COMMAND_CHARACTER) {
            return getCommandResponse(userMessage.substring(1));
        }
        else if (random.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return responses.get(random.nextInt(responses.size()));
        }
        return "";
    }

    private String getCommandResponse(String userMessage) {
        switch (userMessage) {
            case "help":
                return "Commands:\n" +
                        "$help - get a list of commands\n" +
                        "$info - get bot information and diagnostics";
            case "info":
                return "Info:\n" +
                        "Current Runtime: " + (Util.convertToReadableTime(System.nanoTime() - startNanoTime)) + "\n" +
                        "Language: Java 11\n" +
                        "Libraries: JDA\n" +
                        "Author: Andrew Moseman\n";
            default:
                return userMessage + " is not a valid command.";
        }
    }
}
