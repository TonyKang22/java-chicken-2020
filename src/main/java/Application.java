import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OutputView.printAction();
        PosProgram pos = new PosProgram();
        while (true) {
            pos.runPOS();
        }
    }
}
