import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Hashtable;

public class MessageListener extends ListenerAdapter {
    private Bot bot;

    public Hashtable<String, ArrayList<String>> surveyQuestions;
    public Hashtable<String, Survey> surveys;

    public MessageListener(Bot bot) {
        this.bot = bot;
        this.surveys = new Hashtable<>();
        this.surveyQuestions = new Hashtable<>();
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
                    surveys.put(authorUUID, new Survey(botResponse.getSurveyName()));
                    ArrayList<String> messageIDs = new ArrayList<>();
                    for (int i = 0; i < contents.length - 1; i++) {
                        String response = contents[i];
                        ArrayList<String> answers = new ArrayList<>();
                        surveyQuestions.put(authorUUID + response, answers);
                        surveys.get(authorUUID).addQuestion(authorUUID + response, answers);
                        messageIDs.add(authorUUID + response);
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
        boolean userAlreadyVoted = false;
        ArrayList<String> question = surveyQuestions.get(event.getButton().getId());
        if (question == null) {
            event.reply("This survey has already closed").queue();
            return;
        }
        for (String user : question) {
            if (user.equals(authorId)) {
                userAlreadyVoted = true;
                break;
            }
        }
        if (userAlreadyVoted) {
            event.reply("You can only vote once per choice").queue();
        }
        else {
            surveyQuestions.get(event.getButton().getId()).add(authorId);
            event.reply(event.getUser().getName() + " has voted").queue();
        }
    }
}
