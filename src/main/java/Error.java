public class Error {
    public static BotResponse MISSING_ARG = new BotResponse(new String[]{"ERROR: missing argument"});
    public static BotResponse EXTRA_ARG = new BotResponse(new String[]{"ERROR: extra argument"});
    public static BotResponse INVALID_ARG = new BotResponse(new String[]{"ERROR: invalid argument"});
    public static BotResponse INVALID_CMD = new BotResponse(new String[]{"ERROR: invalid command"});
}
