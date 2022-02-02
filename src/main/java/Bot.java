import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.security.auth.login.LoginException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Bot {
    private double CHANCE_OF_RANDOM_RESPONSE = 0.05;

    private ArrayList<String> responses;

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

        // Load responses from file
        try {
            JSONObject jo = (JSONObject) new JSONParser().parse(new FileReader("build/resources/main/responses.json"));
            JSONArray ja = (JSONArray) jo.get("responses");
            responses = new ArrayList<>();
            Iterator iterator = ja.iterator();
            while (iterator.hasNext()) {
                responses.add((String) iterator.next());
            }

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String getBotResponse(String userMessage) {
        if (userMessage.charAt(0) == '$') {
            return getCommandResponse(userMessage);
        }
        else if (random.nextDouble() < CHANCE_OF_RANDOM_RESPONSE) {
            return responses.get(random.nextInt(responses.size()));
        }
        return "";
    }

    private String getCommandResponse(String userMessage) {
        if (userMessage.equals("$info")) {
            return "Info:\n" +
                    "Current Runtime: " + (Util.convertToReadableTime(System.nanoTime() - startNanoTime)) + "\n" +
                    "Language: Java 11\n" +
                    "Libraries: JDA\n" +
                    "Author: Andrew Moseman\n";
        }
        return userMessage + " is not a valid command.";
    }
}
