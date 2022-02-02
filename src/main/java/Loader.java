import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Loader {
    private JSONObject jo;

    public Loader load(Object bot, String resource) {
        bot.getClass().getResource("/" + resource);
        try {
            // Source: https://stackoverflow.com/questions/14089146/file-loading-by-getclass-getresource
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();
            FileOutputStream out = new FileOutputStream(tempFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Read file as json
            jo = (JSONObject) new JSONParser().parse(new FileReader(tempFile));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return this;
    }

    public ArrayList<String> getResponses() {
        JSONArray ja = (JSONArray) jo.get("responses");
        ArrayList<String> data = new ArrayList<>();
        Iterator iterator = ja.iterator();
        while (iterator.hasNext()) {
            data.add((String) iterator.next());
        }
        return data;
    }
}
