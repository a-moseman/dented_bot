import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.util.Random;

public class Bot {
    private double CHANCE_OF_RANDOM_RESPONSE = 0.01;

    private Random random;

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
    }

    public String getBotResponse(String userMessage) {
        if (random.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return RandomResponse.getRandom();
        }
        return userMessage;
    }
}
