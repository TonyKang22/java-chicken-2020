package processor;

public class ExitProcessor implements CommandProcessor {

    private static final int EXIT = 0;

    @Override
    public void run() {
        System.exit(EXIT);
    }
}
