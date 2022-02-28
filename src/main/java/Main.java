public class Main {
    public static void main(String[] args) {
        Bot bot = new Bot(Double.parseDouble(args[1]), args[2])
                .setupJDA(args[0]);
    }
}
