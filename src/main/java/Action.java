import processor.CommandProcessor;
import processor.ExitProcessor;
import processor.PayProcessor;
import processor.RegisterProcessor;

import java.util.Arrays;

public enum Action {
    Registration(1, new RegisterProcessor()),
    PAY(2, new PayProcessor()),
    EXIT(3, new ExitProcessor());

    private final int id;
    private final CommandProcessor command;

    Action(int id, CommandProcessor command) {
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
