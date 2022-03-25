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
}
