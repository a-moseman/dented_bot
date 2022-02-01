import java.util.Random;

public class RandomResponse {
    private static Random random = new Random();

    private static String[] responses = {
            "lmao, get rotated",
            "get dented",
            "Cool Anyways here’s the Recipe for brownies:\n" +
                    "1/2 cup butter\n" +
                    "2 eggs\n" +
                    "1 cup sugar\n" +
                    "1/3 cup cocoa powder\n" +
                    "2 teaspoon vanilla extract"
    };

    public static String getRandom() {
        return responses[random.nextInt(responses.length)];
    }
}
