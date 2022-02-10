import java.io.*;

public class FileManager {
    public static Object load(String path) throws Exception {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);
        Object data = in.readObject();
        in.close();
        file.close();
        return data;
    }

    public static void save(String path, Object data) throws Exception{
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(data);
        out.close();
        file.close();
    }

    public static boolean exists(String path) {
        return new File(path).exists();
    }
}