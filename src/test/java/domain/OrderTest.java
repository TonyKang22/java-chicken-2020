package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    MenuRepository menuRepository;
    Order order;

    @BeforeEach
    void createOrder() {
        order = new Order();
    }

    @Test
    @DisplayName("주문 수량 확인")
    void orderCountCorrect() {
        // given
        Menu chicken = MenuRepository.findById(1);
        int count = 10;

        // when
        order.addOrder(chicken, count);

        // then
        assertEquals(order.countChickenOrder(), 10);
    }

    @Test
    @DisplayName("주문 수량 초과")
    void exceedNumberOfChicken() {
        // given
        Menu chicken = MenuRepository.findById(1);
        int count = 100;

        // when
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> order.addOrder(chicken, count));

        // then
        assertEquals(exception.getMessage(), "한 테이블 최대 주문량은 99 마리입니다.");
    }
}
