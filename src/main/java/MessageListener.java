import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class MessageListener extends ListenerAdapter {
    private Bot bot;

    public MessageListener(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            MessageChannel channel = event.getChannel();
            String authorUUID = event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator();

            BotResponse botResponse = bot.getBotResponse(event.getMessage().getContentRaw(), authorUUID);
            String[] contents = botResponse.getContents();
            boolean isSurvey = botResponse.isSurvey();
            if (contents.length > 0) {

                if (isSurvey) { // Work around to send specific messages for surveys
                    channel.sendMessage(botResponse.getSurveyName() + ":").queue();
                    for (int i = 0; i < contents.length - 1; i++) {
                        String response = contents[i];
                        ArrayList<String> answers = new ArrayList<>();
                        Button button = Button.primary(authorUUID + response, "vote");
                        channel.sendMessage(response)
                                .setActionRow(button)
                                .queue();
                    }
                }
                else {
                    for (String response : contents) {
                        channel.sendMessage(response).queue();
                    }
                }
            }
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        super.onButtonInteraction(event);
        String authorId = event.getUser().getName() + "#" + event.getUser().getDiscriminator();
        SurveyQuestion question = bot.getSurveyManager().getQuestion(event.getButton().getId());
        if (question == null) {
            event.reply("This survey has already closed").queue();
            return;
        }
        if (question.containsVote(authorId)) {
            event.reply("You can only vote once per choice").queue();
        }
        else {
            bot.getSurveyManager().getQuestion(event.getButton().getId()).addVote(authorId);
            event.reply(event.getUser().getName() + " has voted").queue();
        }
    }
}
