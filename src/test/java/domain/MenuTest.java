package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("메뉴 만들기")
    void makeNewMenu() {
        // given
        int id = 8;
        String name = "뿌링클치킨";
        Category category = Category.CHICKEN;
        Money price = new Money(20_000);

        // when
        Menu newMenu = new Menu(id, name, category, price);

        // then
        assertEquals(newMenu.getId(), id);
        assertEquals(newMenu.getName(), name);
        assertEquals(newMenu.getCategory(), category);
        assertEquals(newMenu.getPrice(), price);
    }

    @Test
    @DisplayName("동일 메뉴 확인")
    void validateSameMenu() throws IllegalAccessException {
        // given
        Menu menu = new Menu(10, "안동찜닭", Category.CHICKEN, new Money(20_000));

        // when
        Menu findMenu = MenuRepository.findById(10);

        // then
        assertEquals(menu, findMenu);
    }

}