package controller;

import controller.Action;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 4, -2, 8})
    @DisplayName("잘못된 입력 값")
    void wrongInput(int input) {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> Action.of(input));
        assertEquals(exception.getMessage(), "행동은 1,2,3번만 입력 가능합니다.");
    }

}