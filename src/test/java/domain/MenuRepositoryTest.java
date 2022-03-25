package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {

    @Test
    @DisplayName("메뉴는 더 추가할 수 없다.")
    void cantChangeMenu() {
        // given
        int id = 8;
        String name = "뿌링클치킨";
        Category category = Category.CHICKEN;
        Money price = new Money(20_000);
        List<Menu> menus = MenuRepository.menus();

        // when
        Menu newMenu = new Menu(id, name, category, price);

        // then
        assertThrows(UnsupportedOperationException.class, () -> menus.add(newMenu));
    }

    @Test
    @DisplayName("동일 메뉴 확인")
    void test() throws IllegalAccessException {
        // given
        Menu menu = MenuRepository.menus().get(0);

        // when
        Menu findMenu = MenuRepository.findById(1);

        // then
        assertEquals(menu, findMenu);
    }

}