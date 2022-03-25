import controller.Action;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OutputView.printAction();
        while (true) {
            runPOS();
        }
    }

    private static void runPOS() {
        try {
            Action.of(InputView.inputActionId()).run();
            OutputView.printAction();
        } catch (Exception e) {
            OutputView.printException(e);
        }
    }
}
