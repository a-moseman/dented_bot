import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    private Bot bot;

    public MessageListener(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            MessageChannel channel = event.getChannel();
            String botResponse = bot.getBotResponse(event.getMessage().getContentRaw());
            if (!botResponse.equals("")) {
                channel.sendMessage(bot.getBotResponse(event.getMessage().getContentRaw()))
                        .queue();
            }
        }
    }
}
