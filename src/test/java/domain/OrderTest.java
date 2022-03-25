package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("주문 생성")
    void isOrderCorrect() {
        //given
        Menu friedChicken = new MenuRepository().menus().get(0);
        int orderCount = 10;

        //when
        Order order = new Order(friedChicken, orderCount);

        //then
        assertEquals(order.getMenu(), friedChicken);
        assertEquals(order.getCount(), orderCount);
    }

    @Test
    @DisplayName("주문 금액 확인")
    void checkOrderPrice() {
        // given
        Menu halfChicken = new MenuRepository().menus().get(3);
        int price = halfChicken.getPrice();

        // when
        Order order = new Order(halfChicken, 2);

        // then
        assertEquals(order.calculatePrice(), 32_000);
    }
}
