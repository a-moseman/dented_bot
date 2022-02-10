import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomResponseGenerator {
    private final ArrayList<String> RESPONSES;
    private ArrayList<String> unused;
    private final Random RANDOM;

    public RandomResponseGenerator(Random random) {
        this.RESPONSES = new Loader()
                .load(this, "responses.json")
                .getResponses();;
        this.RANDOM = random;
        this.unused = new ArrayList<>();
        shuffle();
    }

    private void shuffle() {
        for (String string : RESPONSES) {
            unused.add(string);
        }
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
