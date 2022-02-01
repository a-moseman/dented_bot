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
                    "2 teaspoon vanilla extract",
            "( ͡° ͜ʖ ͡°)",
            "(˵ ͡° ͜ʖ ͡°˵)",
            "┬┴┤( ͡⚆ل͜├┬┴┬ ",
            "ᕦ( ͡° ͜ʖ ͡°)ᕤ",
            "( ͡° ͜ʖ ͡ – ✧)",
            "( ͡° ͜ʖ ͡°)╭∩╮",
            "( ＾◡＾)っ✂❤",
            "( ͠° ͟ʖ ͠°)",
            "٩(^ᴗ^)۶",
            "ᕕ( ͡° ͜ʖ ͡°)ᕗ",
            "( ಠ ͜ʖಠ)",
            "(ง ͠° ͟ل͜ ͡°)ง",
            "(͠≖ ͜ʖ͠≖)",
            "( ͡ᵔ ͜ʖ ͡ᵔ )",
            "ฅ^•ﻌ•^ฅ",
            "✌.|•͡˘‿•͡˘|.✌",
            "◕‿↼",
            "UwU",
            "OwO",
            "Now THIS is podracing!",
            "ur mom",
            "https://www.youtube.com/watch?v=hUsRR3Ac0Ro", // Hey stinky
            "https://tenor.com/bC74M.gif" // Crying spongebob gif
    };

    public static String getRandom() {
        return responses[random.nextInt(responses.length)];
    }
}
