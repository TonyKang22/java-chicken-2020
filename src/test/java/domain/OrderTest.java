package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    MenuRepository menuRepository;

    @Test
    @DisplayName("테이블 주문지 생성")
    void createTableOrder() {
        // given
        Order order = new Order();

        // when

        // then
        assertNotNull(order);
    }

    @Test
    @DisplayName("주문 수량 확인")
    void orderCountCorrect() {
        // given
        Order order = new Order();

        // when
        order.addOrder(MenuRepository.menus().get(0), 10);

        // then
        assertEquals(order.countChickenOrder(), 10);
    }

    @Test
    @DisplayName("주문 수량 초과")
    void exceedNumberOfChicken() {
        // given
        Order order = new Order();

        // when
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> order.addOrder(menuRepository.menus().get(1), 100));

        // then
        assertEquals(exception.getMessage(), "한 테이블 최대 주문량은 99 마리입니다.");
    }
}
