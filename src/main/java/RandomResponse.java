import java.util.Random;

public class RandomResponse {
    private static Random random = new Random();

    private static String[] responses = {
            "get dented",
            "lmao, get rotated",
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
            "https://tenor.com/bC74M.gif", // Crying spongebob gif
            "Welcome to the Bread bank. We sell bread, we sell loafs. We got bread on deck, bread on the floor. TOASTED, RO-\n" +
                    "\n" +
                    "Shut the fuck up. Listen, I just need a Baguette and a Brioche.\n" +
                    "\n" +
                    "We don't have either of those, you can get the gluten-free white bread or the potato bread-\n" +
                    "\n" +
                    "What the fuck is gluten?! Take that shit out!\n" +
                    "\n" +
                    "It's gluten-free.\n" +
                    "\n" +
                    "I don't CARE if it's free.\n" +
                    "\n" +
                    "Swear on your fucking Y E E Z Y S, if you wanna fight, we gon' fight.\n" +
                    "\n" +
                    "You tryna' be on WORLDSTAR?\n" +
                    "\n" +
                    "What, you gonna record it?\n" +
                    "\n" +
                    "Ye, I got my dollar store camera ON.\n" +
                    "\n" +
                    "What's the fucking situætion?\n" +
                    "\n" +
                    "What the fuck do you want?\n" +
                    "\n" +
                    "I'm the mother fucking M̸͈̙̪̗̺̱̊̆͋͌̋͜͝͝A̶̤̺͈̭̝̻͗̓̈́̍̈̅̎͗̈́̀̌͠N̷͉͍̘͎͉̘͂͊͗̚Ą̶̛̳̪̮͔̘̤̭̳͕̳̞̑̈́͌̾̿̾̅̈́̕G̶̰͙̈͛͐̌̆̿̕E̸̬̫̗̞̣̗͒̽͐̔͘͝ͅȒ̴̨͖̤̫̺̾͊̆͂͘͝ͅ!̴̧̡̩͚͔̟̝͔͈͙̗̣̮̀̒̊̑͐͠!̴̡̢̞̖̖̝̬̰̰̼͂͋̋́̄̍̓̚̕͝͝ͅ!̷̺̭̝͊́͝͠͝\n" +
                    "\n" +
                    "At the bread store?\n" +
                    "\n" +
                    "\uD83C\uDD71️Ŗ̷̛̺̃̅̉̒̑͆̚͝ ̶̢̼͙̝̜͚͎͋̾̌̑͑̽̍͌͊̒͒͝͝£̷̢̩̠͖̟͙̖͗͒̈́̇̏̾͆̾͒̏͋̈́̐̽̓ ̴̛̯̳͕̗̠̗͒͂̓̄̆́͋̿̌́͒͘̚A̸͉̫̅ ̷̧͚̲̭̻̗̣̙͔͇͈̯̩͆̌̌̒̂͜D̷̺͇̤̮̫̮͌\n" +
                    "\n" +
                    "Tell him to take, the motherfuckin' gluten, OUT THE BREAD.\n" +
                    "\n" +
                    "I'ma need you to shut that bullshit up chief. We can't take shit out the bread.\n" +
                    "\n" +
                    "Why put it in the first place?! I know y'all smoking that Pack.\n" +
                    "\n" +
                    "We got crackers, no gluten.\n" +
                    "\n" +
                    "Fuck crackers!!\n" +
                    "\n" +
                    "It's gluten free. Do you want the gluten or nah?\n" +
                    "\n" +
                    "Hell no. You Better take the gluten out that damn shit\n" +
                    "\n" +
                    "Look, we've got whole wheat, gluten free, texas toast, gluten free, TORTILLA-\n" +
                    "\n" +
                    "Fuck all that. What BITCH ASS country are y'all from... where they got this Bullshit at?!\n" +
                    "\n" +
                    "Florida.\n" +
                    "\n" +
                    "I knew it.\n" +
                    "\n" +
                    "Look, you can either take this YeasT, or i'm calling the police .\n" +
                    "\n" +
                    "I'm going W E A S T .\n" +
                    "\n" +
                    "Nah, don't call the police, I got a warrant...\n" +
                    "\n" +
                    "Honestly, fuck y'all! I ain't never seen nobody act like this over no bread\n" +
                    "\n" +
                    "What the fuck are you sayin'?!\n" +
                    "\n" +
                    "All I'm saying is fuck y'all's bread, fuck the gluten, a̸͉̜͆ň̶̰̪͒͑͒͗͑̉̓̚͠d̸̨̧̙͙̤̽̓ ̶̙̀́̈͐f̵̪͙͎̰̹̙̣̈́͐̔͒̿̆̃͘ȕ̸̺̿̈́͗̒͘̚̕c̴̢̺̘̞̬̯̅̏̊̾͗͘͜k̷͕̺͔̬̥̂̃̊͒͝͠ ̸̤̺̟̣͕̻̟̎ͅt̶̝̜̝͙̟͐̈́̄̈́̚͠h̷͇̭͕̦̙̳͌͂͂̐͊̎͛͑͆e̸͇̺͂͂̏́̑m̵̼̺̦̭̱̯̲̍̓̈́̽̆͗̐̕͝ ̸̯̙͓̝̈c̶̡̨͎͉̙͙̝̺̙̘̈̐̌̓r̵̝̰͑̈̾̈́̒̚̕a̵̲̓̇̂̚c̷̢̧̗͚̮̰̲̥͗̽̐͜ͅk̵̡̫͂̽̍̆͊͊̏̑͘e̷̢͆͋̅̌́̑̈́͗ͅȑ̶̛̝͔̦̉̕s̵̛͔̮̘͔̘̫̖̣̩̓̿̒͝.̴̙̳̫̹̫̜̣̃́̀̃\n" +
                    "\n" +
                    "The crackers don’t have gluten-\n" +
                    "\n" +
                    "I'll take those.\n" +
                    "\n" +
                    "Okay that's gonna be five-\n" +
                    "\n" +
                    "Nah, fuck that, I ain't payin'!\n" +
                    "\n" +
                    "[Store door slams shut.]\n" +
                    "\n" +
                    "[Everyone dies.] " //https://sethicals-baku.fandom.com/wiki/Bread_Bank_(No_Gluten)/Transcript
    };

    public static String getRandom() {
        return responses[random.nextInt(responses.length)];
    }
}
