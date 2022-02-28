import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RandomResponseGenerator {
    private final String[] RESPONSES;
    private ArrayList<String> unused;
    private final Random RANDOM;

    public RandomResponseGenerator(Random random, String responsesPath) {
        this.RESPONSES = FileManager.loadResponses(responsesPath);
        this.RANDOM = random;
        this.unused = new ArrayList<>();
        shuffle();
    }

    private void shuffle() {
        unused.addAll(Arrays.asList(RESPONSES));
        Collections.shuffle(unused);
    }

    public String get() {
        if (unused.size() == 0) {
            shuffle();
        }
        String response = unused.get(RANDOM.nextInt(unused.size()));
        unused.remove(response);
        return response;
    }
}
