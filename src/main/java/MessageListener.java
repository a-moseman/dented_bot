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
        // TODO: implement
        if (!event.getAuthor().isBot()) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage(bot.getBotResponse(event.getMessage().getContentRaw()))
                .queue();
        }
    }
}
