import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class Loader {
    private JSONObject jo;

    public Loader load(Object bot, String resource) {
        bot.getClass().getResource("/" + resource);
        try {
            // Source: https://stackoverflow.com/questions/14089146/file-loading-by-getclass-getresource
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
            try {
                assert in != null;
                File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
                tempFile.deleteOnExit();
                FileOutputStream out = new FileOutputStream(tempFile);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                try {
                    jo = (JSONObject) new JSONParser().parse(new FileReader(tempFile));
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ArrayList<String> getResponses() {
        JSONArray ja = (JSONArray) jo.get("responses");
        ArrayList<String> data = new ArrayList<>();
        for (Object o : ja) {
            data.add((String) o);
        }
        return data;
    }
}
