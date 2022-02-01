import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.util.Random;

public class Bot {
    private double CHANCE_OF_RANDOM_RESPONSE = 0.01;

    private Random random;

    private long startNanoTime;

    public Bot(String token) {
        try {
            JDA jda = JDABuilder.createDefault(token)
                    .build();
            jda.addEventListener(new MessageListener(this));
        }
        catch (LoginException exception) {
            exception.printStackTrace();
        }
        random = new Random();
        startNanoTime = System.nanoTime();
    }

    public String getBotResponse(String userMessage) {
        if (userMessage.charAt(0) == '>') {
            return getCommandResponse(userMessage);
        }
        else if (random.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return RandomResponse.getRandom();
        }
        return "";
    }

    private String getCommandResponse(String userMessage) {
        if (userMessage.equals(">info")) {
            return "Info:\n" +
                    "Current Runtime: " + (Util.convertToReadableTime(System.nanoTime() - startNanoTime)) +
                    "Language: Java 17.0.1" +
                    "Libraries: JDA" +
                    "Author: Andrew Moseman";
        }
        return userMessage + " is not a valid command.";
    }
}
