import java.util.ArrayList;

public class Util {
    public static String convertToReadableTime(Long nanoSeconds){
        long tempSec = nanoSeconds / 1000000000;
        long sec = tempSec % 60;
        long min = (tempSec / 60) % 60;
        long hour = (tempSec /(60 * 60)) % 24;
        long day = (tempSec / (24 * 60 * 60)) % 24;
        return String.format("%dd %dh %dm %ds", day, hour, min, sec);
    }

    public static String[] split(String string) {
        ArrayList<String> contents = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '"') {
                inQuotes = !inQuotes;
            }
            else if (!inQuotes && string.charAt(i) == ' ') {
                contents.add(content.toString());
                content = new StringBuilder();
            }
            else {
                content.append(string.charAt(i));
            }
        }
        contents.add(content.toString()); // Add the last part of the string
        return contents.toArray(new String[0]);
    }
}
