package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("Menu Id로 동일 메뉴 확인")
    void validateSameMenu() throws IllegalAccessException {
        // given
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, new Money(16_000));

        // when

        // then
        assertTrue(menu.validateSameMenu(1));
    }

}