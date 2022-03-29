package controller;

import view.InputView;
import view.OutputView;

public class PosProgram {

    public void runPOS() {
        try {
            Action.of(InputView.inputActionId()).run();
            OutputView.printAction();
        } catch (Exception e) {
            OutputView.printException(e);
        }
    }
}
