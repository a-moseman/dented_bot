import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Bot {
    private final char COMMAND_CHARACTER = '$';

    private final double CHANCE_OF_RANDOM_RESPONSE;

    private ArrayList<String> responses;

    private Random random;

    private long startNanoTime;

    public Bot(String token, double chanceOfRandomResponse) {
        try {
            JDA jda = JDABuilder.createDefault(token)
                    .build();
            jda.addEventListener(new MessageListener(this));
        }
        catch (LoginException exception) {
            exception.printStackTrace();
        }
        this.CHANCE_OF_RANDOM_RESPONSE = chanceOfRandomResponse;
        random = new Random();
        startNanoTime = System.nanoTime();

        this.getClass().getResource("/responses.jar");

        // Load responses from file
        try {
            // Source: https://stackoverflow.com/questions/14089146/file-loading-by-getclass-getresource
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("responses.json");
            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();
            FileOutputStream out = new FileOutputStream(tempFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Read file as json
            JSONObject jo = (JSONObject) new JSONParser().parse(new FileReader(tempFile));
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
