import java.util.ArrayList;

public class Util {
    public static long NANOSECONDS_PER_SECOND = 1_000_000_000;

    public static String convertToReadableTime(Long nanoSeconds){
        long tempSec = nanoSeconds / NANOSECONDS_PER_SECOND;
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

    public Object[] mergeArrays(Object[][] arrays) {
        int length = 0;
        for (Object[] array : arrays) {
            length += array.length;
        }
        int l = 0;
        Object[] array = new Object[length];
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                array[l] = arrays[i][j];
                l++;
            }
        }
        return array;
    }
}
