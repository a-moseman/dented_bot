package Game.Loading;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;

public class Loader {
    private final String PATH;

    public Loader(String path) {
        this.PATH = path;
    }

    public JSONObject load() {
        String text = pullText();
        JSONParser jsonParser = new JSONParser();
        try {
            return (JSONObject) jsonParser.parse(text);
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String pullText() {
        URL resource = this.getClass().getClassLoader().getResource(PATH);
        StringBuilder text = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(resource.getFile())));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }
}
