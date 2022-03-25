package domain.controller;

import domain.controller.CommandController;

public class ExitController implements CommandController {

    private static final int EXIT = 0;

    @Override
    public void run() {
        System.exit(EXIT);
    }
}
