import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {
    private final Bot BOT;
    private long lastActivityTime;

    public MessageListener(Bot bot) {
        this.BOT = bot;
        this.lastActivityTime = System.nanoTime();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            MessageChannel channel = event.getChannel();
            String authorID = event.getAuthor().getId();
            String authorUUID = generateAuthorUUID(event);
            String authorName = event.getAuthor().getName();

            if (BOT.incrementUserActivity(authorName, event.getAuthor().getDiscriminator(), authorID)) {
                sendMessage(channel, "<@" + authorID + "> has leveled up to level " + BOT.getUserLevel(authorID));
            }

            BotResponse botResponse = BOT.getBotResponse(event.getMessage().getContentRaw(), authorName, authorID, authorUUID);
            if (botResponse != null) {
                String[] contents = botResponse.getContents();
                if (botResponse.isSurvey()) {
                    channel.sendMessage(botResponse.getSurveyName() + ":").queue();
                    String[] messages = new String[contents.length - 1];
                    System.arraycopy(contents, 0, messages, 0, messages.length);
                    sendSurveyMessages(channel, messages, authorUUID);
                }
                else {
                    sendMessages(channel, contents);
                }
            }

            // Save every 12 hours on receiving a message
            if ((double) (System.nanoTime() - lastActivityTime) / Util.NANOSECONDS_PER_SECOND > 60 * 60) {
                BOT.save();
                lastActivityTime = System.nanoTime();
                sendMessage(event.getChannel(), "Notice: saved");
            }
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        super.onButtonInteraction(event);
        String authorUUID = generateAuthorUUID(event);
        SurveyQuestion question = BOT.getSurveyQuestion(event.getButton().getId());
        event.deferEdit().queue(); // Acknowledge button press but don't respond
        if (question == null) {
            sendMessage(event.getChannel(), "<@" + event.getUser().getId() + "> this survey is closed");
        }
        else if (question.containsVote(authorUUID)) {
            sendMessage(event.getChannel(),"<@" + event.getUser().getId() + "> you may only vote once per question");
        }
        else {
            BOT.getSurveyQuestion(event.getButton().getId()).addVote(authorUUID);
        }
    }

    private void sendMessage(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }

    private void sendMessages(MessageChannel channel, String[] messages) {
        for (String message : messages) {
            sendMessage(channel, message);
        }
    }

    private void sendSurveyMessage(MessageChannel channel, String message, String authorUUID) {
        channel.sendMessage(message)
                .setActionRow(Button.primary(authorUUID + message, "vote"))
                .queue();
    }

    private void sendSurveyMessages(MessageChannel channel, String[] messages, String authorUUID) {
        for (String message : messages) {
            sendSurveyMessage(channel, message, authorUUID);
        }
    }

    private String generateAuthorUUID(MessageReceivedEvent event) {
        return event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator();
    }

    private String generateAuthorUUID(ButtonInteractionEvent event) {
        return event.getUser().getName() + "#" + event.getUser().getDiscriminator();
    }
}
