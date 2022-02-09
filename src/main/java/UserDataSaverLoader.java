import java.io.*;
import java.util.Hashtable;

public class UserDataSaverLoader {
    public static Hashtable<String, User> load() throws Exception {
        FileInputStream file = new FileInputStream("users.data");
        ObjectInputStream in = new ObjectInputStream(file);
        Hashtable<String, User> users = (Hashtable<String, User>) in.readObject();
        in.close();
        file.close();
        return users;
    }

    public static void save(Hashtable<String, User> users) throws Exception{
        FileOutputStream file = new FileOutputStream("users.data");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(users);
        out.close();
        file.close();
    }
}
