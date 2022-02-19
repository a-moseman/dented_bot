import static org.junit.Assert.assertEquals;

public class BotResponseTest {
    @org.junit.jupiter.api.Test
    void getArguments() {
        BotResponse botResponse = new BotResponse(new String[]{"a", "b", "c"});
        assertEquals("b", botResponse.getArguments()[0]);
    }
}
