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

    public boolean sendingSurveyMessage; // TODO: remove usage
    public String newSurveyName; // TODO: remove usage

    public Hashtable<String, ArrayList<String>> questions;
    public Hashtable<String, Survey> surveys;

    public MessageListener(Bot bot) {
        this.bot = bot;
        this.surveys = new Hashtable<>();
        this.questions = new Hashtable<>();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            MessageChannel channel = event.getChannel();
            String[] botResponse = bot.getBotResponse(event.getMessage().getContentRaw(), event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator());
            if (botResponse.length > 0) {

                if (sendingSurveyMessage) { // Work around to send specific messages for surveys
                    String authID = event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator();
                    surveys.put(authID, new Survey(newSurveyName));
                    ArrayList<String> messageIDs = new ArrayList<>();
                    for (int i = 0; i < botResponse.length - 1; i++) {
                        String response = botResponse[i];
                        ArrayList<String> answers = new ArrayList<>();
                        questions.put(authID + response, answers);
                        surveys.get(authID).addQuestion(authID + response, answers);
                        messageIDs.add(authID + response);
                        Button button = Button.primary(authID + response, "vote");
                        channel.sendMessage(response)
                                .setActionRow(button)
                                .queue();
                    }
                    sendingSurveyMessage = false;
                    newSurveyName = "";
                }
                else {
                    for (String response : botResponse) {
                        channel.sendMessage(response).queue();
                    }
                }
            }
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        super.onButtonInteraction(event);
        String authId = event.getUser().getName() + "#" + event.getUser().getDiscriminator();
        boolean userAlreadyVoted = false;
        ArrayList<String> question = questions.get(event.getButton().getId());
        if (question == null) {
            event.reply("This survey has already closed").queue();
            return;
        }
        for (String user : question) {
            if (user.equals(authId)) {
                userAlreadyVoted = true;
                break;
            }
        }
        if (userAlreadyVoted) {
            event.reply("You can only vote once per choice").queue();
        }
        else {
            questions.get(event.getButton().getId()).add(authId);
            event.reply(event.getUser().getName() + " has voted").queue();
        }
    }
}
