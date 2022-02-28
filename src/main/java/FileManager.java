import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class FileManager {
    /**
     * DEPRECATED
     */
    public static Object load(String path) throws Exception {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);
        Object data = in.readObject();
        in.close();
        file.close();
        return data;
    }

    /**
     * DEPRECATED
     */
    public static void save(String path, Object data) throws Exception{
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(data);
        out.close();
        file.close();
    }

    public static String[] loadResponses(String path) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(path);
            return (String[]) jsonObject.get("responses");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean exists(String path) {
        return new File(path).exists();
    }
}
