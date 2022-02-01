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
                    "[Everyone dies.] ", //https://sethicals-baku.fandom.com/wiki/Bread_Bank_(No_Gluten)/Transcript
            "https://static.wikia.nocookie.net/leagueoflegends/images/c/c0/LoL_ping_missing.png/revision/latest/scale-to-width-down/128?cb=20211117143127", // LOL missing ping
            "You kid have just made the biggest mistake of your pathetic life. Do you even have a fucking clue of who you are dealing with right now? My software is top of the line and I am tracking your IP address as we speak.\n" +
                    "I will find out your address. I will find out your name. I will find every piece of information I can find out about you.\n" +
                    "And then I'm gonna use every single resource I have to wipe you off the face of planet earth. I will send the most ruthless assassins after you. Who will not hesitate to turn you into a fine red mist you fucking sub-human piece of shit.\n" +
                    "You will wish you were never born and you will feel unimaginable pain for the rest of your life, which mind you, will be cut short.\n" +
                    "You're fucked, bud.",
            "Right now, I'm a click away from using an SQL injection attack to gain access to the database of this website and gain your login credentials, as well as your IP address. I'll then proceed to leak your IP address onto my hacker forums, and then using an IP locator, I'll easily find your house and your name. With that I can access your social media accounts and proceed to ruin your life. You think I'm bluffing? You think that just because a bunch of 7 year olds say they can \"hack\", but actually can't, that I can't either? Let me shatter that facade for you. Using my team of hackers, we can trace what websites you've visited and what keystrokes you've used, and with that, I can get into your parents' bank account. I can drain it and make you dirt poor. Have you ever felt what it's like to be homeless? Well, you're about to. I can also use cross-site scripting to redirect your web browser to one of my private sites, and download illegal files onto your computer and get your parents locked up in prison. I'm your worst nightmare, and I'm about to make you endure living Hell. I'm nowhere and everywhere at the same time. Have fun regretting your existence, kiddo.",
            "You know what? I'm just going to say it. This server fucking sucks. I don't give a shit if the admins will mute me or if I get banned, but I want to get my message across, because it amazes me how many idiots in this server have a poor taste in quality. This server is like a fucking mental ward, and you all need to seek help. It's always the same damn shit everyday, and nothing new ever comes out of anyone's shriveled brains. Where are all the dank memes? Where are all of the good jokes? Where is all the dark humour? All I see is the same fucking Tumblr screenshots, and it's honestly boring as fuck. ALL of you are boring as fuck, if I'm being frank. I have pity for your parents, because I wouldn't question how would I able to nurture someone so milquetoast and ignorant for 18 years without putting a bullet through my head. You're all lame as fuck. I feel more stupider interacting with you all, and I wouldn't want to spend another second in this toxic atmosphere. Hell I'm actually glad this group exists. It keeps all the unfunny pricks away from the server that appreciate quality in their content. I hope you all get drafted and never come back. I'm done with you assholes.",
            "Have you ever had a dream that, that, um, that you had, uh, that you had to, you could, you do, you wit, you wa, you could do so, you do you could, you want, you wanted him to do you so much you could do anything?",
            "Are you kidding ??? What the **** are you talking about man ? You are a biggest looser i ever seen in my life ! You was doing PIPI in your pampers when i was beating players much more stronger then you! You are not proffesional, because proffesionals knew how to lose and congratulate opponents, you are like a girl crying after i beat you! Be brave, be honest to yourself and stop this trush talkings!!! Everybody know that i am very good blitz player, i can win anyone in the world in single game! And \"w\"esley \"s\"o is nobody for me, just a player who are crying every single time when loosing, ( remember what you say about Firouzja ) !!! Stop playing with my name, i deserve to have a good name during whole my chess carrier, I am Officially inviting you to OTB blitz match with the Prize fund! Both of us will invest 5000$ and winner takes it all!\n" +
                    "I suggest all other people who's intrested in this situation, just take a look at my results in 2016 and 2017 Blitz World championships, and that should be enough... No need to listen for every crying babe, Tigran Petrosyan is always play Fair ! And if someone will continue Officially talk about me like that, we will meet in Court! God bless with true! True will never die ! Liers will kicked off...",
            "you fool. you absolute buffoon. you think you can challenge me in my own realm? you think you can rebel against my authority? you dare come into my house and upturn my dining chairs and spill coffee grinds in my Keurig? you thought you were safe in your chain mail armor behind that screen of yours. I will take these laminate wood floor boards and destroy you. I didn't want war, but I didn't start it.",
            "What the fuck did you just fucking say about me, you little bitch? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You're fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little \"clever\" comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn't, you didn't, and now you're paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You're fucking dead, kiddo.",
            "Waluigi is the ultimate example of the individual shaped by the signifier. Waluigi is a man seen only in mirror images; lost in a hall of mirrors he is a reflection of a reflection of a reflection. You start with Mario – the wholesome all Italian plumbing superman, you reflect him to create Luigi – the same thing but slightly less. You invert Mario to create Wario – Mario turned septic and libertarian – then you reflect the inversion in the reflection: you create a being who can only exist in reference to others. Waluigi is the true nowhere man, without the other characters he reflects, inverts and parodies he has no reason to exist. Waluigi’s identity only comes from what and who he isn’t – without a wider frame of reference he is nothing. He is not his own man. In a world where our identities are shaped by our warped relationships to brands and commerce we are all Waluigi.",
            "Awesome pics. Great size. Look thick. Solid. Tight. Keep us all posted on your continued progress with any new progress pics or vid clips. Show us what you got man. Wanna see how freakin' huge, solid, thick and tight you can get. Thanks for the motivation", // TODO: make possible response to someone posting pic
            "The shopping cart is the ultimate litmus test for whether a person is capable of self-governing.\n" +
                    "To return the shopping cart is an easy, convenient task and one which we all recognize as the correct, appropriate thing to do. To return the shopping cart is objectively right. There are no situations other than dire emergencies in which a person is not able to return their cart. Simultaneously, it is not illegal to abandon your shopping cart. Therefore the shopping cart presents itself as the apex example of whether a person will do what is right without being forced to do it. No one will punish you for not returning the shopping cart, no one will fine you or kill you for not returning the shopping cart, you gain nothing by returning the shopping cart. You must return the shopping cart out of the goodness of your own heart. You must return the shopping cart because it is the right thing to do. Because it is correct.\n" +
                    "A person who is unable to do this is no better than an animal, an absolute savage who can only be made to do what is right by threatening them with a law and the force that stands behind it.\n" +
                    "The Shopping Cart is what determines whether a person is a good or bad member of society.",
            "Please put an NSFW tag on this. I was on the train and when I saw this I had to start furiously masterbating. Everyone else gave me strange looks and were saying things like “what the fuck” and “call the police”. I dropped my phone and everyone around me saw this image. Now there is a whole train of men masterbating together at this one image. This is all your fault, you could have prevented this if you had just tagged this post NSFW.", // TODO: make possible response to pic
            "apolgy for bad english\n" +
                    "where were u wen club penguin die\n" +
                    "i was at house eating dorito when phone ring\n" +
                    "\"Club penguin is kil\"\n" +
                    "\"no\"",
            "Before You Post THINK\n" +
                    "T - is it True?\n" +
                    "H - is it Helpful?\n" +
                    "I - is it Inspiring?\n" +
                    "N - is it Necessary?\n" +
                    "K - is it Kind?",
            "I CANNOT STOP OPENING WITH THE QUEEN'S GAMBIT. I LOVE IT SO MUCH. WHEN THAT PAWN MOVES TO D4 I SHAKE IN PLEASURE, AND WHEN BLACK MOVES THEIR PAWN TO D5 I FEEL THE FEELING OF 1000 CLIMAXES. I MOVE A PAWN TO C4 QUIVERING IN ANTICIPATION AND THEN, AS IT WAS PLANNED, THE ENEMY TAKES MY C4 PAWN. I SCREAM AND MOAN IN PLEASURE AS I COVER THE INSIDE OF MY PANTS WITH MY CUM. I MOVE MY PAWN TO B3 AND IT GETS CAPTURED I MOAN AND BANG THE TABLE AS I SLOWLY CAPTURE THEIR PAWN, TAKEN COMPLETE CONTROL OVER THE MIDDLE OF THE BOARD, AND PASS OUT CUDDLING MY OPPONENT, PANTS DRENCHED IN SEMEN.",
            "Look for the gummy bear album in stores on November 13th for lots of music videos and extras",
            "Hello! I have been following your tweets for the past two days, and have come to the conclusion you do not deserve to have Raymond on your island. He is my comfort character and seeing him in an environment not meant for him brings me anxiety, so I will be expecting a reply to this DM when you have him in boxes and ready to relinquish him to someone who will treasure him like he deserves.",
            "What if I... put my Minecraft bed... \uD83D\uDE33 next to yours... \uD83D\uDE33 aha ha, just kidding.. \uD83D\uDE02 unless.. ? \uD83D\uDE33",
            "This is the ideal male body. You may not like it, but this is what peak performance looks like.", // TODO: make possible response to pic
            "When you were partying, I studied the blade. When you were having premarital sex, I mastered the blockchain. While you wasted your days at the gym in pursuit of vanity, I cultivated inner strength. And now that the world is on fire and the barbarians are at the gate you have the audacity to come to me for help.",
            "i am a fully grown adult cannot fathom why you imbeciles have the impulse to say \"nice\" when you see 69 because I the fully grown adult personally have acquired the ability to suck my own dick and ipso facto do not see any niceties in a number that implies my own hindrance.",
            "Alex19 isn't so great? Are you kidding me? When was the last time you saw a player with such an ability and movement with fox? Alex puts the game in another level, and we will be blessed if we ever see a player with his skill and passion for the game again. mang0 breaks records. Armada breaks records. Alex19 breaks the rules. You can keep your statistics. I prefer the magic.",
            "Gentlemen, it is no nut November. I have planted several snipers on each of your positions, watching your every move for the rest of November. If it’s reported to see any of you have nutted, you will immediately be executed. This month goes by near-death rules, so if you get near-nut, you get bonus points.\n" +
                    "Points may be redeemed at the front of the gift store for candy and prizes.",
            "Well, \uD83D\uDE02\uD83D\uDD73 let's \uD83D\uDC82\uD83D\uDC4D say hypothetically : you \uD83D\uDC71\uD83C\uDFB7 were \uD83D\uDC76 ''doin my mom, \uD83D\uDC69 doin - doin my \uD83D\uDC6A mom''. I \uD83D\uDE21\uD83C\uDF7A find it VERY hard \uD83D\uDE1C\uD83D\uDEAA to ✋ believe \uD83D\uDCAD\uD83C\uDD70 that \uD83D\uDDFA\uD83D\uDE10 you \uD83D\uDC48 were \uD83D\uDE32 having \uD83D\uDC6C sexual \uD83C\uDF08 intercouse with my \uD83C\uDD71 mother, ☎\uD83C\uDF3E as \uD83C\uDD71 you \uD83D\uDE0B\uD83D\uDC49 are \uD83C\uDFFD a young \uD83D\uDCA6\uD83D\uDCA6 child \uD83D\uDC66 and she is an \uD83D\uDCEF adult! \uD83D\uDCA6\uD83D\uDC71 Not \uD83D\uDEAB\uD83D\uDC4F to \uD83D\uDC4F\uD83D\uDCA6 mention she \uD83C\uDFFC is \uD83D\uDCA6 dead, besides if she were alive, \uD83D\uDE07 you \uD83D\uDE2D wouldn't know \uD83D\uDE1C\uD83D\uDC67 her \uD83D\uDE1E\uD83D\uDC78 as \uD83D\uDC66 i \uD83D\uDE43 don't \uD83D\uDEAB know \uD83D\uDCAD you. so \uD83D\uDE33\uD83D\uDD65 I find \uD83D\uDD0D\uD83E\uDD14 it very \uD83D\uDC4C hard \uD83C\uDF46 to \uD83D\uDCA6 believe \uD83D\uDCAD you \uD83D\uDE29 had sex \uD83D\uDC4C with \uD83D\uDC4F\uD83D\uDC3A her. \uD83D\uDE29"

    };

    public static String getRandom() {
        return responses[random.nextInt(responses.length)];
    }
}
