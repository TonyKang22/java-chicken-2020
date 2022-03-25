package controller;

import java.util.Arrays;

public enum Action {
    Registration(1, new RegisterController()),
    PAY(2, new PayController()),
    EXIT(3, new ExitController());

    private final int id;
    private final CommandController command;

    Action(int id, CommandController command) {
        this.id = id;
        this.command = command;
    }

    public static Action of(int idInput) {
        return Arrays.stream(values())
                .filter(value -> value.id == idInput)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("행동은 1,2,3번만 입력 가능합니다."));
    }

    public void run() throws IllegalAccessException {
        this.command.run();
    }
}
