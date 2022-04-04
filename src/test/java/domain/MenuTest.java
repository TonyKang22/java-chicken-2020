package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("Menu Id로 동일 메뉴 확인")
    void validateSameMenu() throws IllegalAccessException {
        // given
        int id = 1;
        String name = "후라이드";
        Money price = new Money(16_000);

        // when
        Menu menu = new Menu(id, name, Category.CHICKEN, price);

        // then
        assertTrue(menu.validateSameMenu(1));
    }

}