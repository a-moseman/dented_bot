public class Main {
    public static void main(String[] args) {
        Bot bot = new Bot(Double.parseDouble(args[1]))
                .setupJDA(args[0]);
    }
}
