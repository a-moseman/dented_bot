import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class BotResponseTest {
    @Test
    void getArguments() {
        BotResponse botResponse = new BotResponse(new String[]{"a", "b", "c"});
        assertEquals("b", botResponse.getArguments()[0]);
    }
}
